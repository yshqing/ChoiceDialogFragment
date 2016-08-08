package com.ysq.android.widget.choicedialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ChoiceDialogFragment extends DialogFragment {
    public static final String KEY_ARGUMENT_LIST = "KEY_ARGUMENT_LIST";
    public static final String KEY_ARGUMENT_LAYOUT_RES = "KEY_ARGUMENT_LAYOUT_RES";
    private OnItemChoiceListener mOnItemChoiceListener;
    private ChoiceAdapter mAdapter;
    private List<ChoiceItem> mData;
    private int mLayoutRes;

    public void setOnItemChoiceListener(OnItemChoiceListener listener) {
        mOnItemChoiceListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bundle args = getArguments();
        if (args != null) {
            mData = args.getParcelableArrayList(KEY_ARGUMENT_LIST);
            mLayoutRes = args.getInt(KEY_ARGUMENT_LAYOUT_RES, -1);
        }
        View view = null;
        if (mLayoutRes != -1) {
            view = inflater.inflate(mLayoutRes, null);
        } else {
            view = inflater.inflate(R.layout.fragment_choice_dialog, null);
        }
        mAdapter = new ChoiceAdapter(getActivity(), mData);
        ListView listView = (ListView) view.findViewById(android.R.id.list);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnItemChoiceListener != null) {
                    mOnItemChoiceListener.onItemChoice(mData.get(position));
                }
                getDialog().hide();
            }
        });
        return view;
    }

    public interface OnItemChoiceListener {
        public void onItemChoice(ChoiceItem item);
    }

}