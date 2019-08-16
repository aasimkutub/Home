package com.tthings.home;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tthings.home.adapter.RoomViewSwichBoardAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayRoom extends Fragment {


    public DisplayRoom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_display_room, container, false);
        RecyclerView rv = v.findViewById(R.id.rvDisplayRoomSwitchBoard);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        rv.setAdapter(new RoomViewSwichBoardAdapter(getActivity(),1));

        RecyclerView rvr = v.findViewById(R.id.rvDisplayRoomRoomCard);
        rvr.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rvr.setAdapter(new RoomViewSwichBoardAdapter(getActivity(),2));

        RecyclerView rvs = v.findViewById(R.id.rvDisplayRoomSwitchCard1);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);

        rvs.setLayoutManager(manager);
        rvs.setAdapter(new RoomViewSwichBoardAdapter(getActivity(),3));

        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        }



        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}
