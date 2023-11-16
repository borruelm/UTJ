package com.utj.permitease;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request.Method;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response.ErrorListener;
import com.utj.permitease.activities.MainMenu;

public class MainActivity extends AppCompatActivity {
    private final String urlLogin = "http://localhost:8080/api/v2/user/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText user = (EditText) findViewById(R.id.user);
        EditText pass = (EditText) findViewById(R.id.pass);

        Button loginBtn = (android.widget.Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                if(!user.getText().toString().equals("") &&
                        !pass.getText().toString().toString().equals("") ){
                    Toast.makeText(view.getContext(),
                            "Validando datos, por favor espera.",
                            android.widget.Toast.LENGTH_SHORT).show();



                   JsonObjectRequest jsonRequest = new JsonObjectRequest(
                           "http://192.168.0.76:8080/api/v2/user/login",
                           new com.android.volley.Response.Listener<org.json.JSONObject>() {
                               @Override
                               public void onResponse(org.json.JSONObject response) {
                                   Toast.makeText(view.getContext(),
                                           "Error validando datos. " + response.toString(),
                                           android.widget.Toast.LENGTH_SHORT).show();

                                   //startActivity(new Intent(getApplicationContext(), MainMenu.class));



                               }
                           },
                           new com.android.volley.Response.ErrorListener() {
                               @Override
                               public void onErrorResponse(com.android.volley.VolleyError error) {
                                   System.out.println(error.toString());
                                   Toast.makeText(view.getContext(),
                                           "Error validando datos. " + error.toString(),
                                           android.widget.Toast.LENGTH_SHORT).show();
                               }
                           }

                   );

                   RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
                   StringRequest strReq = new StringRequest(
                           Method.POST,
                           "http://192.168.0.76:8080/api/v2/user/login",
                           new Response.Listener<String>() {
                               @Override
                               public void onResponse(String response) {

                               }
                           },

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.v("Error while trying to get data : >> ", error.getMessage());
                            // handling error on below line.
                            Toast.makeText(MainActivity.this, "Fail to get response..", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            // on below line we are passing our key
                            // and value pair to our parameters.
                            params.put("usrName", user.getText().toString());
                            params.put("keyPass<", pass.getText().toString());
                            return params;
                        }
                    };
                   requestQueue.add(strReq);

                }else{
                    Toast.makeText(view.getContext(),
                            "Para poder iniciar sesion deberas ingresar ambos valores.",
                            android.widget.Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}