package com.calci.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class WholeNewsActivity extends AppCompatActivity {
    private TextView textView,description;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_news);
        textView=findViewById(R.id.whole_text);
        imageView=findViewById(R.id.image_view);
        description=findViewById(R.id.description);
//        id=getIntent().getStringExtra("id");


        String URL=getIntent().getStringExtra("image");
        if (URL.contains("null"))
        {
            imageView.setImageResource(R.drawable.image);
        }
        else {
            Picasso.get().load(URL).into(imageView);
        }
        String str=getIntent().getStringExtra("WholeNews");
        textView.setText(str);

        String  string=getIntent().getStringExtra("des");
        if (string.contains("null"))
        {
            description.setText("");

        }
        else
        {
            description.setText(string);
        }


    }
}
