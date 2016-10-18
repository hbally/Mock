package com.example.yaoli.mock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private static final String ENC = "UTF-8";
    private static final String URL_TEST_FOR_HAWAII = "http://10.5.5.9:8080/gp/gpControl";
    static final String TAG = "test_mock";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getTest();
                //get();
//                get2();
                getGoPro();
            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());
    }


    private String urlEncode(String value) {
        try {
            value = URLEncoder.encode(value, ENC);
        } catch (UnsupportedEncodingException e) {
        }
        return value;
    }

    public void getGoPro() {
        String url = URL_TEST_FOR_HAWAII +"/command/mode?p=1";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "onErrorResponse " +error.toString());
            }
        });
        queue.add(request);

    }

    public void getTest() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://localhost:8099/v1/projects/1", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.v(TAG, "onsuccess " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.v(TAG, "onFailure ");
            }
        });

    }
//    http://localhost:8099/rewards/1b?signature=1427292197.abcd

    private void get() {
        String url = "http://localhost:8099/v1/discover?client_id=.*";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", "onResponse"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "onErrorResponse " +error.toString());
            }
        });
        queue.add(request);
    }


    private void get2() {
        String url = "http://localhost:8099/rewards/1b?signature=1427292197.abcd";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", "onResponse"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "onErrorResponse " +error.toString());
            }
        });
        queue.add(request);
    }
}
