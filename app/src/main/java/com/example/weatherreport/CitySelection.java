package com.example.weatherreport;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CitySelection extends AppCompatActivity {

    //测试数据
    private String[] city = {"北京","上海","广州","天津","张家口","重庆","成都","长沙","哈尔滨","长春","包头","大连","桂林","杭州"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_selection);

        //填充列表内容
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                CitySelection.this, android.R.layout.simple_list_item_1, city);
        final ListView cityList = (ListView)findViewById(R.id.cityList);
        cityList.setAdapter(adapter);
        //设置列表点击监听
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cityClicked = city[position];
                //Toast.makeText(CitySelection.this,cityClicked,Toast.LENGTH_SHORT).show();

                //将点击的城市名储存起来
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("city",cityClicked);
                editor.apply();
                CitySelection.this.finish();
            }
        });
    }
}
