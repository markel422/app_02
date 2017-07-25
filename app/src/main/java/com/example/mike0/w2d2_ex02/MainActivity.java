package com.example.mike0.w2d2_ex02;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyAppSettings";

    EditText name;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.user_name);
        lastName = (EditText) findViewById(R.id.user_lastName);
    }

    public void clearNames(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("1", name.getText().toString());
        editor.putString("2", lastName.getText().toString());
        editor.commit();

        name.setText("");
        lastName.setText("");
    }

    public void alertName(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String value = settings.getString("1", name.getText().toString());
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void alertLastName(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String value = settings.getString("2", lastName.getText().toString());
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void updateNames(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String nameValue = settings.getString("1", name.getText().toString());
        String lastNameValue = settings.getString("2", lastName.getText().toString());

        name.setText(nameValue);
        lastName.setText(lastNameValue);
    }
}
