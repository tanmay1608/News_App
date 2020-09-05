package com.calci.newsapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,horizontalRecyclerView;
  CustomAdapter coustmAdapter;
  ArrayList<String> arrayList;
  List<listIteam> listIteams;
  HorizontalAdapter horizontalAdapter;
  ProgressDialog progressDialog;






    public static final String URL="https://newsapi.org/v2/top-headlines?country=in&apiKey=61cb283a7d52476c92c75877ecc16d49";

    RequestQueue qu,requestQueue;
    TextView textView;
    LinearLayoutManager HorizontalLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
//                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        recyclerView=findViewById(R.id.recycler_View);
        horizontalRecyclerView=findViewById(R.id.horizontal);

//        ConnectivityManager connectivityManager=(ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
//
//        if (networkInfo==null || !networkInfo.isConnected() || !networkInfo.isAvailable())
//        {
//            progressDialog=new ProgressDialog(MainActivity.this);
//            progressDialog.show();
//            progressDialog.setContentView(R.layout.progress_dialog);
//
//            progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//
//        }




        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);


        String[] str={"Sports","Business","Health","Science","Entertainment"};
        int[] images={R.drawable.sports,R.drawable.busines,R.drawable.health,R.drawable.sciencenew,R.drawable.film};




        horizontalAdapter=new HorizontalAdapter(MainActivity.this,this,str,images);
        horizontalRecyclerView.setAdapter(horizontalAdapter);
        horizontalRecyclerView.setLayoutManager(HorizontalLayout);






        listIteams=new ArrayList<>();








        qu= Volley.newRequestQueue(this);


        final JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray= response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject article = jsonArray.getJSONObject(i);
                                //   JSONObject inside=article.getJSONObject("source");
                                listIteam listIteam = new listIteam(article.getString("title"),article.getString("description"),article.getString("urlToImage"));

                                listIteams.add(listIteam);
                            }


//                                String title=article.getString("description");
//                                arrayList.add(title);


                                coustmAdapter=new CustomAdapter(MainActivity.this,getApplicationContext(),listIteams);


                                recyclerView.setAdapter(coustmAdapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
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



        qu.add(jsonObjectRequest);

    }
}
