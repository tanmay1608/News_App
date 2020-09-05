package com.calci.newsapp;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList id_list, today_list;
    Animation translate_anim;
    ArrayList data;
   // String[] data;
     private  List<listIteam> listIteams;
Dialog dialog;


    CustomAdapter(Activity activity, Context context,List<listIteam> listIteams){
        this.activity=activity;
        this.context = context;
        this.listIteams=listIteams;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom, parent, false);
        return new MyViewHolder(view);
    }

    //   @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //  holder.text1.setText(String.valueOf(id_list.get(position)));

       // holder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_anim));
        holder.mainLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_anim));
        final listIteam listIteam=listIteams.get(position);
        final listIteam listIteam1=listIteams.get(position);
        final listIteam listItem3=listIteams.get(position);
//        final String string=listIteam1.toString();

  //      Picasso.get().load(listItem3.get(position).getImageURL()).into(holder.imageView);

        if(listItem3.getImageURL().contains("null") ) {
           holder.imageView.setImageResource(R.drawable.image);

        }
        else
        {
            Picasso.get().load(listItem3.getImageURL()).into(holder.imageView);

        }
     //   holder.text1.setText(listIteam1.getMain());


        if (listIteam.getHeading().length()>=50)
        {
            holder.text2.setText(listIteam.getHeading().substring(0,50)+"...");
        }
        else {
            holder.text2.setText(listIteam.getHeading());
        }




        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,WholeNewsActivity.class);
                intent.putExtra("WholeNews",listIteam.getHeading());
                intent.putExtra("image",listItem3.getImageURL());
                intent.putExtra("des",listIteam1.getMain());


                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(activity,holder.cardView,"imageTransition");
                activity.startActivityForResult(intent,1,options.toBundle());

//                context.startActivity(intent);

            }
        });

//        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
//        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        //Recyclerview onClickListener
//


    }

    @Override
    public int getItemCount() {
        return listIteams.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2;
        ImageView imageView;
        LinearLayout mainLayout;
        CardView cardView;


        MyViewHolder(@NonNull View itemView) {
            super(itemView);
             //   text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text);
            imageView=itemView.findViewById(R.id.image_view);

            mainLayout=itemView.findViewById(R.id.mainLayout);
            cardView=itemView.findViewById(R.id.card);





        }

    }

}
