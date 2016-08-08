package com.ysq.android.widget.choicedialogfragmentexample;

import android.os.Parcel;

import com.ysq.android.widget.choicedialogfragment.ChoiceItem;

/**
 * Created by ysq on 16/8/8.
 */
public class Test implements ChoiceItem {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShowName() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Test() {
    }

    protected Test(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Test> CREATOR = new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel source) {
            return new Test(source);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };
}
