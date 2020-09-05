package com.calci.newsapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BuisnessAdapter extends RecyclerView.Adapter<BuisnessAdapter.MyNewViewHolder> {
    private Context context;
    private List<newList> newLists;
    private Activity activity;

    public BuisnessAdapter(Activity activity, Context context, List<newList> newLists)
    {
        this.activity=activity;
        this.context=context;
        this.newLists=newLists;

    }

    @NonNull
    @Override
    public MyNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.adapter_new,parent,false);

        return new MyNewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyNewViewHolder holder, int position) {
        final newList newList=newLists.get(position);
        final newList newList1=newLists.get(position);
        final newList newList2=newLists.get(position);
        final  newList newList3=newLists.get(position);

//        holder.newTextView.setText(newList.getTitle());
//        Picasso.get().load(newList2.getImageURL()).into(holder.newImageView);
//        holder.busi_text.setText(newList1.getDescription());

        if(newList2.getImageURL().contains("null") && newList1.getDescription().contains("null"))
        {
            holder.newImageView.setImageResource(R.drawable.image);
            holder.newTextView.setText(newList.getTitle());
            holder.busi_text.setText("");
        }
        else {

            if (newList2.getImageURL().contains("null"))
            {
                holder.newImageView.setImageResource(R.drawable.image);
                holder.newTextView.setText(newList.getTitle());
                holder.busi_text.setText(newList1.getDescription());
            }
            else if (newList1.getDescription().contains("null")) {
                Picasso.get().load(newList2.getImageURL()).into(holder.newImageView);
                holder.newTextView.setText(newList.getTitle());
                holder.busi_text.setText("");
            } else {

                Picasso.get().load(newList2.getImageURL()).into(holder.newImageView);
                holder.newTextView.setText(newList.getTitle());
                holder.busi_text.setText(newList1.getDescription());
            }
        }





        holder.newLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse(newList3.getUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newLists.size();
    }

    public class MyNewViewHolder extends RecyclerView.ViewHolder {
        TextView newTextView,busi_text;
        ImageView newImageView;
        ConstraintLayout newLayout;
        CardView cardView;

        public MyNewViewHolder(@NonNull View itemView) {

            super(itemView);
            newImageView=itemView.findViewById(R.id.round_busi);
            newTextView=itemView.findViewById(R.id.busi_Text);
            busi_text=itemView.findViewById(R.id.des_text_busi);
            newLayout=itemView.findViewById(R.id.businessLayout);
           // cardView=itemView.findViewById(R.id.busi_cardView);
        }
    }
}
