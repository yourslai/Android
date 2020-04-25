package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuResActicity extends AppCompatActivity {

    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_res_acticity);

        textView = (TextView) findViewById(R.id.xml_test);
        registerForContextMenu(textView);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(R.menu.menu_setting,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_font_small:
                textView.setTextSize(10 * 2);
                break;
            case R.id.menu_font_middle:
                textView.setTextSize(16 * 2);
                break;
            case R.id.menu_font_big:
                textView.setTextSize(20 * 2);
                break;
            case R.id.menu_normal:
                Toast.makeText(MenuResActicity.this, "这是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_color_red:
                textView.setTextColor(Color.RED);
                break;
            case R.id.menu_color_black:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return true;
    }

}
