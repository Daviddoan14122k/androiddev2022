package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Chuong", "onCreate");
        // Create a new Fragment to be placed in the activity layout
        ForecastFragment firstFragment = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Chuong", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Chuong","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Chuong","onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Chuong","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Chuong","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Chuong","onResume");
    }
}
