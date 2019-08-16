package com.tthings.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tthings.home.adapter.HomeRoomCardAdapter;
import com.tthings.home.adapter.HomeSceneCardAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePage extends Fragment {


    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home_page, container, false);
        RecyclerView rv = v.findViewById(R.id.rv_roomCardHome);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rv.setAdapter(new HomeRoomCardAdapter(getContext()));

        RecyclerView rvs = v.findViewById(R.id.scene);
        rvs.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL,false));
        rvs.setAdapter(new HomeSceneCardAdapter(getActivity()));

        v.findViewById(R.id.navigationMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Open Navigation Drawer",Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }



}
