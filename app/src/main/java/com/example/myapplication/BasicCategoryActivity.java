package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BasicCategoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //ConnectionDetector connection_detector;
    ProductAdapter adapter;
    List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if (connection_detector.isConnected())
        {
        }else
        {
            Intent intent = new Intent(this,ConnectionError.class);
            startActivity(intent);
            //Toast.makeText(this,"Not Connected",Toast.LENGTH_LONG).show();
        }*/
        productList = new ArrayList<>();
        recyclerView = findViewById(R.id.id_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadProducts();
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://msrpromotion.lk/iot_application/api.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray products = new JSONArray(response);
                            for (int i=0; i<products.length(); i++){
                                JSONObject object = products.getJSONObject(i);
                                int id = object.getInt("id");
                                String title = object.getString("title");
                                String description = object.getString("description");
                                double price = object.getDouble("price");
                                double rating = object.getDouble("rating");
                                String image = object.getString("image");
                                Product product = new Product(id,title,description,rating,price,image);
                                productList.add(product);
                            }
                            adapter = new ProductAdapter(BasicCategoryActivity.this,productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BasicCategoryActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
