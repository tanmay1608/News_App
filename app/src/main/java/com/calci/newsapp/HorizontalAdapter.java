package com.calci.newsapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyHorizontalViewHolder> {
    private String[] data;
    private Context context;
    private int[] images;
    private Activity activity;



    public HorizontalAdapter(Activity activity,Context context,String[] data,int[] images)
    {
        this.activity=activity;
        this.context=context;
        this.data=data;
        this.images=images;

    }


    @NonNull
    @Override
    public MyHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.horizontal, parent, false);
        return new MyHorizontalViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHorizontalViewHolder holder, int position) {
        final String str=data[position];
        holder.textView.setText(str);
        int image=images[position];
        holder.imageView.setImageResource(image);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (str)
                {
                    case "Business":
                        Intent ownIntent=new Intent(context, Business.class);

                        activity.startActivityForResult(ownIntent,1);
                        break;
                    case "Entertainment":
                        Intent enterIntent=new Intent(context,Entertainment.class);
                        activity.startActivityForResult(enterIntent,1);
                        break;

                    case "Science":
                        Intent sciIntent=new Intent(context,Science.class);

                        activity.startActivityForResult(sciIntent,1);
                        break;
                    case "Sports":
                        Intent sportsIntent=new Intent(context,Sports.class);
                        activity.startActivityForResult(sportsIntent,1);
                        break;

                    case "Health":
                        Intent healthIntent=new Intent(context,Health.class);
                        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(activity,holder.cardView,"anim");
                        activity.startActivityForResult(healthIntent,1,options.toBundle());
                        break;
//                context.startActivity(ownIntent);


                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyHorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        CardView cardView;
        public MyHorizontalViewHolder(@NonNull View itemView) {

            super(itemView);

            textView=itemView.findViewById(R.id.option);
            imageView=itemView.findViewById(R.id.horizontal_image);
            linearLayout=itemView.findViewById(R.id.horizontal_layout);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

}
