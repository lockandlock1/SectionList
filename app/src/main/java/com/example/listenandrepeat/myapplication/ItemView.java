package com.example.listenandrepeat.myapplication;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by ListenAndRepeat on 2016. 1. 24..
 */
public class ItemView extends FrameLayout{
    public ItemView(Context context) {
        super(context);
        init();
    }
    TextView titleView;

    private void init(){
        inflate(getContext(),R.layout.view_item,this);
        titleView = (TextView)findViewById(R.id.text_title);
    }

    public void setChildItem(ChildItem item){
        titleView.setText(item.childName);
    }

}
