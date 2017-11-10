package com.firstapp.joel.recyclerview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> mylistItems;
    ListItem listItem;

    ProgressDialog progressDialog;
    private String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recylerviewMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mylistItems = new ArrayList<>();

        /*for (int i=0;i<=10;i++){
            listItem = new ListItem(  "HEADING" + i,"my description");
            mylisteItems.add(listItem);     }
        adapter= new MyAdapter(mylisteItems,this);
        recyclerView.setAdapter(adapter);*/
        mylarRecyclerView();
    }
    private void mylarRecyclerView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading data");
        progressDialog.show();

        Log.i("MYTEST", "yes");

        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                Log.i("MYTEST", response);

                progressDialog.cancel();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray categories = jsonObject.getJSONArray("actors");
                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        ListItem ls = new ListItem(item.getString("name"),
                                item.getString("description"),
                                item.getString("dob"),
                                item.getString("country"),
                                item.getString("spouse"),
                                item.getString("image"));
                        mylistItems.add(ls);
                    }

                    adapter = new MyAdapter(mylistItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(sr);
    }
}