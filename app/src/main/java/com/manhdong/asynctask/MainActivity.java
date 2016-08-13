package com.manhdong.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<Country> countryList;
    Button btnLoad, btnAsync;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnAsync = (Button) findViewById(R.id.btnAsyncTask);


        initData();

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    for (int i = 0; i < 15; i++) {
                        Thread.sleep(1000);
                        countryList.add(new Country(R.drawable.icon, "VN-"+i));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                adapter = new MyAdapter(MainActivity.this, R.layout.item_layout, countryList);
                gridView.setAdapter(adapter);

            }
        });

        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initData();
                MyAsyncTask async = new MyAsyncTask();
                String s[] = new String[]{"countries 1", "countries 1","countries 1","countries 1","countries 1","countries 1","countries 1","countries 1","countries 1","countries 1"};
//                async.doInBackground(s);
                async.execute(s);

                adapter = new MyAdapter(MainActivity.this, R.layout.item_layout, countryList);
                gridView.setAdapter(adapter);
            }
        });

    }

    private void initData() {
        countryList = new ArrayList<>();
    }
//
//        countryList.add(new Country(R.drawable.icon, "VN"));
//        countryList.add(new Country(R.drawable.icon, "EN"));
//        countryList.add(new Country(R.drawable.icon, "KR"));
//        countryList.add(new Country(R.drawable.icon, "GP"));
//        countryList.add(new Country(R.drawable.icon, "ID"));
//        countryList.add(new Country(R.drawable.icon, "IN"));
//        countryList.add(new Country(R.drawable.icon, "FR"));
//        countryList.add(new Country(R.drawable.icon, "VN"));
//
//    }
//    AsyncTask<String, Country, Void> asynctask = new AsyncTask<String, Country, Void>() {
//    @Override
//    protected Void doInBackground(String... params) {
//        for (int i = 0; i < params.length; i++) {
//            new Country(R.drawable.icon, "FR")
//
//        }
//        return null;
//    }
//
//    @Override
//    protected void onProgressUpdate(Country... values) {
//        super.onProgressUpdate(values);
//
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        super.onPostExecute(aVoid);
//    }
//};
    class MyAsyncTask extends AsyncTask<String, Country, Void>{

    @Override
    protected Void doInBackground(String... params) {
        for (int i=0; i<params.length; i++) {
            try {
                Thread.sleep(1000);
                Country country = new Country(R.drawable.icon, "country-"+i );

                publishProgress(country);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Country... values) {
        super.onProgressUpdate(values);
        countryList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(MainActivity.this, "DONE", Toast.LENGTH_SHORT).show();
    }
}

}

