package com.tthings.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tthings.home.DisplayRoom;
import com.tthings.home.MainActivity;
import com.tthings.home.R;

import java.util.zip.Inflater;

public class HomeRoomCardAdapter extends RecyclerView.Adapter<HomeRoomCardAdapter.viewHolder> implements RecyclerView.OnClickListener{

    private Context context;

    public HomeRoomCardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_room_card, parent, false);
        view.setOnClickListener(this);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onClick(View view) {


        ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder,new DisplayRoom()).addToBackStack("Dashboard").commit();
        ((MainActivity)context).findViewById(R.id.nav_view).setVisibility(View.GONE);
    }

    class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

