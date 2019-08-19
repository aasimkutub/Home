package com.tthings.home;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tthings.home.adapter.RoomViewSwichBoardAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayRoom extends Fragment {


    public DisplayRoom() {
        // Required empty public constructor
    }

    DrawerLayout dr;

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

        RoomViewSwichBoardAdapter ad1 = new RoomViewSwichBoardAdapter(this.getContext(),3);

        rvs.setAdapter(ad1);

        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        }
        dr = v.findViewById(R.id.room_slider);
        dr.closeDrawers();

        NavigationView nv = v.findViewById(R.id.nav_view);

        LinearLayout l = v.findViewById(R.id.room);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dr.openDrawer(Gravity.LEFT);
            }
        });




        //getActivity().onBackPressed();
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
