package com.tthings.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tthings.home.R;

import org.w3c.dom.Text;

public class RoomViewSwichBoardAdapter extends RecyclerView.Adapter<RoomViewSwichBoardAdapter.viewHolder> {

    private Context context;
    private int id = 1;
    private int pos = -1;
    private boolean flag = false;


    public RoomViewSwichBoardAdapter(Context context, int id) {
        this.context = context;
        this.id = id;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = null;
        if (id == 1) {
            v = inflater.inflate(R.layout.card_room_view_switch_board,parent,false);
        }
        else if (id == 2) {
            v = inflater.inflate(R.layout.card_room_view_room,parent,false);
        }
        else {
            v = inflater.inflate(R.layout.card_room_view_switch,parent,false);
        }


        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        if (id == 3) {
            if (holder.aSwitch.isChecked()) {
                holder.aNameDisc.setText("ON");
                holder.switchCard.setCardBackgroundColor(context.getResources().getColor(R.color.SwitchColor));

            }
            else {
                holder.aNameDisc.setText("OFF");
                holder.switchCard.setCardBackgroundColor(Color.WHITE);

            }
            holder.flagDot.setCardBackgroundColor(context.getResources().getColor(R.color.RED));
            holder.aName.setText("Switch "+position);

        }

    }


    @Override
    public int getItemCount() {
        return 10;
    }



    class viewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{

        Switch aSwitch;
        TextView aName, aNameDisc;
        CardView switchCard,flagDot;
        ImageView image;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            if (id == 3) {
                aSwitch = itemView.findViewById(R.id.switchToggle);
                aName = itemView.findViewById(R.id.switchName);
                aNameDisc = itemView.findViewById(R.id.switchDisc);
                switchCard = itemView.findViewById(R.id.switchCard);
                flagDot = itemView.findViewById(R.id.switchFlag);
                image = itemView.findViewById(R.id.switchImage);
                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            aNameDisc.setText("ON");
                            switchCard.setCardBackgroundColor(context.getResources().getColor(R.color.SwitchColor));
                            switchCard.setRadius(20.0f);
                        }
                        else {
                            aNameDisc.setText("OFF");
                            switchCard.setCardBackgroundColor(Color.WHITE);
                        }
                    }
                });
            }

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            pos = getAdapterPosition();
            Log.d("Position", "onClick: "+getAdapterPosition());
            if (id == 1) {
                Toast.makeText(context, "Switch Board " + pos, Toast.LENGTH_SHORT).show();



            }

            else if (id == 2){
                Toast.makeText(context, "Room " + pos, Toast.LENGTH_SHORT).show();



            }

            else {
                Toast.makeText(context, "Switch " + pos, Toast.LENGTH_SHORT).show();
                /*Switch s = view.findViewById(R.id.switchToggle);
                if (s.isChecked()) {
                    s.setChecked(false);
                } else {
                    s.setChecked(true);
                }*/
                if (flagDot.getCardBackgroundColor().getDefaultColor() == context.getResources().getColor(R.color.GREEN)) {
                    flagDot.setCardBackgroundColor(context.getResources().getColor(R.color.RED));
                    switchCard.setCardBackgroundColor(Color.WHITE);
                    aNameDisc.setText("OFF");
                    image.setImageDrawable(context.getDrawable(R.drawable.ic_lightbulb_off_24dp));
                }
                else {
                    flagDot.setCardBackgroundColor(context.getResources().getColor(R.color.GREEN));
                    switchCard.setCardBackgroundColor(context.getResources().getColor(R.color.SwitchColor));
                    aNameDisc.setText("ON");
                    image.setImageDrawable(context.getDrawable(R.drawable.ic_lightbulb_on_24dp));
                }
            }

        }
    }


}
