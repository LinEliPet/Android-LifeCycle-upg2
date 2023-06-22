package com.linda.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = this.getSharedPreferences(String.valueOf(R.string.preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Save last input for:
        //Username
        EditText username = findViewById(R.id.username);
        username.setText(sharedPreferences.getString("Username", "Can't find text"));
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "Before editing");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "During editing");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("Linda", "Finished editing "+editable.toString());
                editor.putString("Username", editable.toString());
                editor.apply();
            }
        });

        //Email
        EditText email = findViewById(R.id.email);
        email.setText(sharedPreferences.getString("Email", "Can't find mail"));
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "Before editing");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "During editing");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("Linda", "Finished editing "+editable.toString());
                editor.putString("Email", editable.toString());
                editor.apply();
            }
        });

        //Phone
        EditText phone = findViewById(R.id.phone);
        phone.setText(String.valueOf(sharedPreferences.getInt("Phone", 123)));
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "Before editing");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "During editing");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                int intValue = Integer.parseInt(input);

                Log.d("Linda", "Finished editing " + intValue);

                editor.putInt("Phone", intValue);
                editor.apply();

                int retrievedValue = sharedPreferences.getInt(getString(R.string.preference), 0);

                Log.d("Linda", "Retrieved value: " + retrievedValue);
            }
        });

        //Password
        EditText password = findViewById(R.id.password);
        password.setText(sharedPreferences.getString("Password", ""));
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "Before editing");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "During editing");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("Linda", "Finished editing "+editable.toString());
                editor.putString("Password", editable.toString());
                editor.apply();
            }
        });

        //Re-password
        EditText repassword = findViewById(R.id.repassword);
        repassword.setText(sharedPreferences.getString("Re-password", ""));
        repassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "Before editing");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Linda", "During editing");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("Linda", "Finished editing "+editable.toString());
                editor.putString("Re-password", editable.toString());
                editor.apply();
            }
        });

        Button regbtn = findViewById(R.id.signupbtn);

        Intent loginIntent = new Intent(this, MainActivity.class);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                Toast.makeText(MainActivity2.this, "Username is "+username1, Toast.LENGTH_SHORT).show();
                startActivity(loginIntent);
            }
        });

        Log.d("Linda1", sharedPreferences.getString("Firstname", "Can't find"));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("Firstname", "Linda");
        Log.d("Linda", "Firstname");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        String firstname1 = savedInstanceState.getString("Firstname");
        Toast.makeText(MainActivity2.this, firstname1, Toast.LENGTH_SHORT).show();
        Log.d("Linda", firstname1);
        super.onRestoreInstanceState(savedInstanceState);
    }

}