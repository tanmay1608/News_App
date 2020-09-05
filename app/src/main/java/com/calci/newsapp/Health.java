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

public class Health extends AppCompatActivity {
    public static final String URL_own="https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=61cb283a7d52476c92c75877ecc16d49";
    RequestQueue requestQueue;
    List<HealthList> healthLists;
    RecyclerView newRecyclerView;
    HealthAdapter healthAdapter;
    ViewPager2 viewPager2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

       // newRecyclerView=findViewById(R.id.health_recyclerView);
        viewPager2=findViewById(R.id.view_pager_health);
        healthLists=new ArrayList<>();



        requestQueue= Volley.newRequestQueue(this);
        final JsonObjectRequest newJsonObjectRequest=new JsonObjectRequest(Request.Method.GET, URL_own, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray= response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject article = jsonArray.getJSONObject(i);


                                HealthList healthList=new HealthList(article.getString("title"),article.getString("description"),article.getString("urlToImage"),article.getString("url"));
                                healthLists.add(healthList);

                            }

                            healthAdapter=new HealthAdapter(Health.this,getApplicationContext(),healthLists);
//                            newRecyclerView.setAdapter(healthAdapter);
//                            newRecyclerView.setLayoutManager(new LinearLayoutManager(Health.this));

                            viewPager2.setAdapter(healthAdapter);
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



//                                String title=article.getString("description");
//                                arrayList.add(title);



//                            horizontalAdapter=new HorizontalAdapter()
//
//
//                                    recyclerView.setAdapter(coustmAdapter);
//                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            //arrayList.add(title);
                            //   ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                            //  listView.setAdapter(arrayAdapter);
                            //  textView.setText(title);






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
