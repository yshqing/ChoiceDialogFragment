package com.ysq.android.widget.choicedialogfragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ysq.android.widget.choicedialogfragment.ChoiceDialogFragment;
import com.ysq.android.widget.choicedialogfragment.ChoiceItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtnChoiceDefault;
    private Button mBtnChoiceCustom;
    private ArrayList<Test> mTests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.setName("Test" + i);
            mTests.add(test);
        }
        mBtnChoiceDefault = (Button) findViewById(R.id.btn_choice_default);
        mBtnChoiceDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceDialogFragment choiceDialogFragment = new ChoiceDialogFragment();
                Bundle args = new Bundle();
                args.putParcelableArrayList(ChoiceDialogFragment.KEY_ARGUMENT_LIST, mTests);
                choiceDialogFragment.setArguments(args);
                choiceDialogFragment.setOnItemChoiceListener(new ChoiceDialogFragment.OnItemChoiceListener() {
                    @Override
                    public void onItemChoice(ChoiceItem item) {
                        mBtnChoiceDefault.setText(item.getShowName());
                    }
                });
                choiceDialogFragment.show(getFragmentManager(), "choiceDialogFragment");
            }
        });
        mBtnChoiceCustom = (Button) findViewById(R.id.btn_choice_custom);
        mBtnChoiceCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoiceDialogFragment choiceDialogFragment = new ChoiceDialogFragment();
                Bundle args = new Bundle();
                args.putParcelableArrayList(ChoiceDialogFragment.KEY_ARGUMENT_LIST, mTests);
                args.putInt(ChoiceDialogFragment.KEY_ARGUMENT_LAYOUT_RES, R.layout.fragment_choice_dialog_custom);
                choiceDialogFragment.setArguments(args);
                choiceDialogFragment.setOnItemChoiceListener(new ChoiceDialogFragment.OnItemChoiceListener() {
                    @Override
                    public void onItemChoice(ChoiceItem item) {
                        mBtnChoiceCustom.setText(item.getShowName());
                    }
                });
                choiceDialogFragment.show(getFragmentManager(), "choiceDialogFragment");
            }
        });
    }
}
