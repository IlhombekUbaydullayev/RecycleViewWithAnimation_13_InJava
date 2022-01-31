package com.example.recycleviewwithanimation_13_injava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.recycleviewwithanimation_13_injava.R;
import com.example.recycleviewwithanimation_13_injava.adapter.CustomAdapter;
import com.example.recycleviewwithanimation_13_injava.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemerList();
        refreshAdapter(members);
    }

    private List<Member> prepareMemerList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            members.add(new Member("Ilhombek" + i, "Ubaydullayev" + i));
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(animation);

    }

}