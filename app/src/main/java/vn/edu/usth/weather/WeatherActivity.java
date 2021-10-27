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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_items, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                Toast toast = Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT);
                toast.show();
                super.onRestart();

            case R.id.settings:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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

    final Handler ProgressHandlerMessage = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message msg) {
                String content = msg.getData().getString("Server_Response");
                Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
                toast.show();
        }
    };

    @SuppressLint("StaticFieldLeak")
    public void Refresh() {
        // Practical work 13

        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
// This method is executed in main thread
                String content = msg.getData().getString("Server_Response");
                Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        Thread th = new Thread(() -> {
// this method is run in a worker thread
            try {
// wait for 5 seconds to simulate a long network access
                int i;
                for (i=0;i<10;i++){
                    Log.i(mess,"loop"+i);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
// Assume that we got our data from server
            Bundle bundle = new Bundle();
            bundle.putString("Server_Response", "Refreshing Start");
// notify main thread
            Message msg = new Message();
            msg.setData(bundle);
            handler.sendMessage(msg);
        });
        th.start();
    }
}