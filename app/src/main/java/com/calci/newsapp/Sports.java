package com.calci.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sports extends AppCompatActivity {

    public static final String URL_own= "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=61cb283a7d52476c92c75877ecc16d49";
    RequestQueue requestQueue;
    List<SportsList> sportsLists;
    RecyclerView newRecyclerView;
    SportsAdapter sportsAdapter;
    ViewPager2 viewPager2;
    LinearLayoutManager HorizontalLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);



        HorizontalLayout
                = new LinearLayoutManager(
                Sports.this,
                LinearLayoutManager.HORIZONTAL,
                false);

       // newRecyclerView=findViewById(R.id.sports_recycler);
        viewPager2=findViewById(R.id.view_pager_);
        sportsLists=new ArrayList<>();



        requestQueue= Volley.newRequestQueue(this);
        final JsonObjectRequest newJsonObjectRequest=new JsonObjectRequest(Request.Method.GET, URL_own, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray= response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject article = jsonArray.getJSONObject(i);


                                SportsList sportsList=new SportsList(article.getString("title"),article.getString("description"),article.getString("urlToImage"),article.getString("url"));
                                sportsLists.add(sportsList);

                            }

                            sportsAdapter=new SportsAdapter(Sports.this,getApplicationContext(),sportsLists);
                           // newRecyclerView.setAdapter(sportsAdapter);
                            viewPager2.setAdapter(sportsAdapter);
                            viewPager2.setClipToPadding(false);
                            viewPager2.setClipChildren(false);
                            viewPager2.setOffscreenPageLimit(3);
                            viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

                            CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
                            compositePageTransformer.addTransformer(new MarginPageTransformer(40 ));
                            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                                @Override
                                public void transformPage(@NonNull View page, float position) {
                                    float r=1-Math.abs(position);
                                    page.setScaleY(0.85f+r*0.15f);
                                }
                            });
                            viewPager2.setPageTransformer(compositePageTransformer);






                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();


                // textView.setText(error.getMessage());
            }
        });
        requestQueue.add(newJsonObjectRequest);


    }
}
