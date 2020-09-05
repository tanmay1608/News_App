package com.calci.newsapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.MySortsViewHolder> {
    private Activity activity;
    private Context context;
    private List<SportsList> sportsLists;


    public SportsAdapter(Activity activity,Context context,List<SportsList> sportsLists) {
        this.activity=activity;
        this.context=context;
        this.sportsLists=sportsLists;

    }

    @NonNull
    @Override
    public MySortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.sports_adapter,parent,false);

        return new MySortsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MySortsViewHolder holder, int position) {

       // holder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.new_fade_anim));
        final SportsList sportsList=sportsLists.get(position);
        final SportsList sportsList1=sportsLists.get(position);
        final SportsList sportsList2=sportsLists.get(position);
        final SportsList sportsList3=sportsLists.get(position);





        if(sportsList2.getImageURl().contains("null") && sportsList1.getDescription().contains("null"))
        {
            holder.imageView.setImageResource(R.drawable.image);
            holder.textView.setText(sportsList.getTitle());
            holder.desText.setText("");
        }
        else {

            if (sportsList2.getImageURl().contains("null"))
            {
                holder.imageView.setImageResource(R.drawable.image);
                holder.textView.setText(sportsList.getTitle());
                holder.desText.setText(sportsList1.getDescription());
            }
        else if (sportsList1.getDescription().contains("null")) {
                Picasso.get().load(sportsList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(sportsList.getTitle());
                holder.desText.setText("");
            } else {

                Picasso.get().load(sportsList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(sportsList.getTitle());
                holder.desText.setText(sportsList1.getDescription());
            }
        }


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context,SportsWhole.class);
//                intent.putExtra("sportsImage",sportsList2.getImageURl());
//                intent.putExtra("sportsTitle",sportsList.getTitle());
//                intent.putExtra("sportsDes",sportsList1.getDescription());
//                ActivityOptions sportsOptions=ActivityOptions.makeSceneTransitionAnimation(activity,holder.imageView,"sportsImageTransition");
//                activity.startActivityForResult(intent,1,sportsOptions.toBundle());
                Uri uri=Uri.parse(sportsList3.getUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(browserIntent);

         }
        });



    }

    @Override
    public int getItemCount() {
        return sportsLists.size();
    }

    public class MySortsViewHolder extends RecyclerView.ViewHolder {
        TextView textView,desText;
        RoundedImageView imageView;
       ConstraintLayout linearLayout;
//        CardView cardView;
        public MySortsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.sportsText);
            desText=itemView.findViewById(R.id.des_text);
            imageView=itemView.findViewById(R.id.round);
            linearLayout=itemView.findViewById(R.id.sportsLayout);
           // cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
