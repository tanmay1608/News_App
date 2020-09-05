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

public class enterAdapter extends RecyclerView.Adapter<enterAdapter.enterMyViewHolder> {
    private Activity activity;
    private Context context;
    private List<enterList> enterLists;

    public  enterAdapter(Activity activity,Context context,List<enterList> enterLists)
    {
        this.activity=activity;
        this.context=context;
        this.enterLists=enterLists;

    }
    @NonNull
    @Override
    public enterMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.enter,parent,false);
        return new enterMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final enterMyViewHolder holder, int position) {
        final enterList enterList=enterLists.get(position);
        final enterList enterList1=enterLists.get(position);
        final enterList enterList2=enterLists.get(position);
        final enterList enterList3=enterLists.get(position);


//        holder.textView.setText(enterList.getTitle());
//        Picasso.get().load(enterList2.getImageURl()).into(holder.imageView);
//        holder.desText.setText(enterList1.getDescription());

        if(enterList2.getImageURl().contains("null") && enterList1.getDescription().contains("null"))
        {
            holder.imageView.setImageResource(R.drawable.image);
            holder.textView.setText(enterList.getTitle());
            holder.desText.setText("");
        }
        else {

            if (enterList2.getImageURl().contains("null"))
            {
                holder.imageView.setImageResource(R.drawable.image);
                holder.textView.setText(enterList.getTitle());
                holder.desText.setText(enterList1.getDescription());
            }
            else if (enterList1.getDescription().contains("null")) {
                Picasso.get().load(enterList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(enterList.getTitle());
                holder.desText.setText("");
            } else {

                Picasso.get().load(enterList2.getImageURl()).into(holder.imageView);
                holder.textView.setText(enterList.getTitle());
                holder.desText.setText(enterList1.getDescription());
            }
        }



        holder.enterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse(enterList3.getUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(browserIntent);
              //  context.startActivity(enterintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return enterLists.size();
    }

    public class enterMyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,desText;
     //   CardView cardView;
        ConstraintLayout enterLayout;
        public enterMyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.round_enter);
            textView=itemView.findViewById(R.id.enterText);
            desText=itemView.findViewById(R.id.des_text_enter);
          //  cardView=itemView.findViewById(R.id.CardView_enter);

            enterLayout=itemView.findViewById(R.id.enterLayout);
        }
    }
}
