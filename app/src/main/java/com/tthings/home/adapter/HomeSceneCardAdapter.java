package com.tthings.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tthings.home.R;

public class HomeSceneCardAdapter extends RecyclerView.Adapter<HomeSceneCardAdapter.viewHolder> {

    private Context context;

    public HomeSceneCardAdapter(Activity activity) {
        this.context = activity;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.scene_card,parent,false);

        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
