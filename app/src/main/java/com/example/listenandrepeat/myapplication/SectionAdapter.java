package com.example.listenandrepeat.myapplication;

import android.app.LauncherActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ListenAndRepeat on 2016. 1. 24..
 */
public class SectionAdapter extends BaseAdapter{

    List<GroupItem> items = new ArrayList<GroupItem>();

    public static final int VIEW_TYPE_SECTION_HEADER = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    Random r = new Random();
    public void put(String groupName,String childName){
        GroupItem group = null;
        for (GroupItem g : items) {
            if(g.groupName.equals(groupName)){
                group = g;
                break;
            }
        }

        if(group ==  null){
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }

        if(!TextUtils.isEmpty(childName)){
            ChildItem child = new ChildItem();
            child.childName = childName;
            child.fontSize = 20 + r.nextInt(20);
            group.children.add(child);
        }

        notifyDataSetChanged();
    }
    @Override
    public int getCount() {

        int cnt  = 0;

        for (GroupItem g : items) {
            cnt += (1 + g.children.size());
        }
        return cnt;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        for (int i = 0 ; i < items.size() ; i++){


            if (position < 1) return VIEW_TYPE_SECTION_HEADER;

            position--;

            if(position < items.get(i).children.size()) return VIEW_TYPE_ITEM;

            position -= items.get(i).children.size();
        }
        return super.getItemViewType(position);
    }

    @Override
    public Object getItem(int position) {

        for (int i = 0 ; i < items.size() ; i++){


            if (position < 1) return items.get(i);

            position--;

            if(position < items.get(i).children.size()) return items.get(i).children.get(position);

            position -= items.get(i).children.size();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        for (int i = 0 ; i < items.size() ; i++){


            if (position < 1) {
                SectionHeaderView view;
                if(convertView == null) view  = new SectionHeaderView(parent.getContext());

                else view = (SectionHeaderView)convertView;

                view.setGroupItem(items.get(i));
                return view;
            }

            position--;

            if(position < items.get(i).children.size()){
                ItemView view;
                if(convertView == null) view = new ItemView(parent.getContext());

                else view = (ItemView)convertView;

                view.setChildItem(items.get(i).children.get(position));
                return view;
            }

            position -= items.get(i).children.size();
        }

        /*
        if (getItemViewType(position) == VIEW_TYPE_SECTION_HEADER){
            SectionHeaderView view;
            if (convertView == null) view = new SectionHeaderView(parent.getContext());

            else view = (SectionHeaderView)convertView;


            for (int i = 0 ; i < items.size() ; i++){


                if (position < 1) {
                    view.setGroupItem(items.get(i));
                    return view;
                }

                position--;



                position -= items.get(i).children.size();
            }
            //view.setGroupItem((GroupItem) getItem(position));



        } else {
            ItemView view;
            if (convertView == null) view = new ItemView(parent.getContext());

            else view = (ItemView)convertView;



            for (int i = 0 ; i < items.size() ; i++){



                position--;

                if(position < items.get(i).children.size()) {
                    view.setChildItem(items.get(i).children.get(position));
                    return view;
                }
                position -= items.get(i).children.size();
            }

            //view.setChildItem((ChildItem) getItem(position));


        }
        */

        return null;
    }
}
