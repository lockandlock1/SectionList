package com.example.listenandrepeat.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SectionAdapter mAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new SectionAdapter();
        listView.setAdapter(mAdapter);

        initData();

    }
    private void initData(){
        Random r = new Random();

        for (int i = 0 ; i <  2 ; i++){
            int childCount = 2 + r.nextInt(9);
            for(int j  = 0 ; j < childCount ; j++){
                mAdapter.put("group" + i , "child:"+i+"-"+j);
            }
        }
    }
}
