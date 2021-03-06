package com.nazirov.recyclerview8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.nazirov.recyclerview8.adapter.CustomAdapter;
import com.nazirov.recyclerview8.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        List<Member> members =prepareMemerList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter= new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
    private List<Member> prepareMemerList () {
        List<Member> members =new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Nazirov" +i ,"Elmurod"+i));
        }
        return members;
    }
}