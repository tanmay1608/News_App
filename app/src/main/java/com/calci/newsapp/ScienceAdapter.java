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

public class ScienceAdapter extends RecyclerView.Adapter<ScienceAdapter.MyScienceViewHolder> {
    private Activity activity;
    private Context context;
    private List<ScienceList> scienceLists;

    public ScienceAdapter(Activity activity,Context context,List<ScienceList> scienceLists) {
        this.activity=activity;
        this.context=context;
        this.scienceLists=scienceLists;
    }

    @NonNull
    @Override
    public MyScienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.science_adapter,parent,false);

        return new MyScienceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyScienceViewHolder holder, int position) {
        final ScienceList scienceList=scienceLists.get(position);
        final ScienceList scienceList1=scienceLists.get(position);
        final ScienceList scienceList2=scienceLists.get(position);
        final ScienceList scienceList3=scienceLists.get(position);

        if(scienceList2.getImageURl().contains("null") && scienceList1.getDescription().contains("null"))
        {
            holder.imageView.setImageResource(R.drawable.image);
            holder.textView.setText(scienceList.getTitle());
            holder.des_sci.setText("");
        }
        else {

            if (scienceList2.getImageURl().contains("null"))
            {
                holder.imageView.setImageResource(R.drawable.image);
                holder.textView.setText(scienceList.getTitle());
                holder.des_sci.setText(scienceList1.getDescription());
            }
            else if (scienceList1.getDescription().contains("null")) {
                Picasso.get().load(scienceList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(scienceList.getTitle());
                holder.des_sci.setText("");
            } else {

                Picasso.get().load(scienceList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(scienceList.getTitle());
                holder.des_sci.setText(scienceList1.getDescription());
            }
        }

//        Picasso.get().load(scienceList2.getImageURl()).into(holder.imageView);
//        holder.textView.setText(scienceList.getTitle());
//        holder.des_sci.setText(scienceList1.getDescription());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse(scienceList3.getUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return scienceLists.size();
    }

    public class MyScienceViewHolder extends RecyclerView.ViewHolder {
        TextView textView,des_sci;
        ImageView imageView;
        CardView cardView;
        ConstraintLayout linearLayout;
        public MyScienceViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.sciText);
            des_sci=itemView.findViewById(R.id.des_text_sci);
            imageView=itemView.findViewById(R.id.round_sci);
         //   cardView=itemView.findViewById(R.id.sciencecardView);
            linearLayout=itemView.findViewById(R.id.scienceLayout);

        }
    }
}
