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
//        ForecastFragment firstFragment = new ForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container,firstFragment).commit();
//        WeatherFragment secondFragement =new WeatherFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container,secondFragement).commit();
        PagerAdapter adapter = new AdapterPage(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
//        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

	# add play music
	MediaPlayer play = MediaPlayer.create(getApplicationContext(), R.raw.audiomusic);
        play.start();
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
