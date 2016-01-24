package com.example.listenandrepeat.myapplication;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.security.acl.Group;

/**
 * Created by ListenAndRepeat on 2016. 1. 24..
 */
public class SectionHeaderView extends FrameLayout {

    public SectionHeaderView(Context context) {
        super(context);
        init();
    }
    TextView titleView;

    private void init(){
        inflate(getContext(),R.layout.view_section_header,this);
        titleView = (TextView)findViewById(R.id.text_title);
    }

    public void setGroupItem(GroupItem item){
        titleView.setText(item.groupName);
    }
}
