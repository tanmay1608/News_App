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

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.MyHealthAdapter> {
    private Activity activity;
    private Context context;
    private List<HealthList> healthLists;

    public HealthAdapter(Activity activity,Context context,List<HealthList> healthLists)
    {
        this.activity=activity;
        this.context=context;
        this.healthLists=healthLists;

    }
    @NonNull
    @Override
    public MyHealthAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.health_adapter,parent,false);
        return new MyHealthAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHealthAdapter holder, int position) {
        final HealthList healthList=healthLists.get(position);
        final HealthList healthList1=healthLists.get(position);
        final HealthList healthList2=healthLists.get(position);
        final HealthList healthList3=healthLists.get(position);

//        holder.textView.setText(healthList.getTitle());
//        Picasso.get().load(healthList2.getImageURL()).into(holder.imageView);
//        holder.des_health.setText(healthList1.getDescription());

        if(healthList2.getImageURL().contains("null") && healthList1.getDescription().contains("null"))
        {
            holder.imageView.setImageResource(R.drawable.image);
            holder.textView.setText(healthList.getTitle());
            holder.des_health.setText("");
        }
        else {

            if (healthList2.getImageURL().contains("null"))
            {
                holder.imageView.setImageResource(R.drawable.image);
                holder.textView.setText(healthList.getTitle());
                holder.des_health.setText(healthList1.getDescription());
            }
            else if (healthList1.getDescription().contains("null")) {
                Picasso.get().load(healthList2.getImageURL()).into(holder.imageView);
                holder.textView.setText(healthList.getTitle());
                holder.des_health.setText("");
            } else {

                Picasso.get().load(healthList2.getImageURL()).into(holder.imageView);
                holder.textView.setText(healthList.getTitle());
                holder.des_health.setText(healthList1.getDescription());
            }
        }



        holder.healthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent healthIntent=new Intent(context,HealthWhole.class);
//                healthIntent.putExtra("healthImage",healthList1.getImageURL());
//                healthIntent.putExtra("healthTitle",healthList.getTitle());
//                healthIntent.putExtra("healthDes",healthList2.getDescription());
//
//                ActivityOptions healthOption=ActivityOptions.makeSceneTransitionAnimation(activity,holder.imageView,"healthImageTransition");
//                activity.startActivityForResult(healthIntent,1,healthOption.toBundle());

                Uri uri=Uri.parse(healthList3.getUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(browserIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return healthLists.size();
    }

    public class MyHealthAdapter extends RecyclerView.ViewHolder {

        TextView textView,des_health;
        ImageView imageView;
        ConstraintLayout healthLayout;
        CardView cardView;
        public MyHealthAdapter(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.healthText);
            des_health=itemView.findViewById(R.id.des_text_health);
            imageView=itemView.findViewById(R.id.round_health);
          //  cardView=itemView.findViewById(R.id.cardView);

            healthLayout=itemView.findViewById(R.id.healthLayout);
        }
    }
}
