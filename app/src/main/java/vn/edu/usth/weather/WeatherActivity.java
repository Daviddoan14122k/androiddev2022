    final Handler ProgressHandlerMessage = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message msg) {
                String content = msg.getData().getString("Server_Response");
                Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
                toast.show();
        }
    };

    // Practical work 13
    @SuppressLint("StaticFieldLeak")
    public void Refresh() {

//        final Handler handler = new Handler(Looper.getMainLooper()) {
//            @Override
//            public void handleMessage(Message msg) {
//// This method is executed in main thread
//                String content = msg.getData().getString("Server_Response");
//                Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        };
//        Thread th = new Thread(() -> {
//// this method is run in a worker thread
//            try {
//// wait for 5 seconds to simulate a long network access
//                int i;
//                for (i=0;i<10;i++){
//                    Log.i(mess,"loop"+i);
//                    Thread.sleep(1000);
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//// Assume that we got our data from server
//            Bundle bundle = new Bundle();
//            bundle.putString("Server_Response", "Refreshing Start");
//// notify main thread
//            Message msg = new Message();
//            msg.setData(bundle);
//            handler.sendMessage(msg);
//        });
//        th.start();

        // Practical work 14
        AsyncTask<Integer, Integer, Integer> taskA = new AsyncTask<Integer, Integer, Integer>() {

            @Override
            protected void onPreExecute() {
//                String content = "Starting delay Android";
                Toast toast = Toast.makeText(getApplicationContext(), "Starting delay Android", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            protected void onPostExecute(Integer integer) {
//                String content = "Finished delay Android";
                Toast toast = Toast.makeText(getApplicationContext(),  "Finished delay Android", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
//                String content = "Uppdate  Android";
                Toast toast = Toast.makeText(getApplicationContext(), "Uppdate  Android",+ values[0]);
                toast.show();
            }
            @SuppressLint("StaticFieldLeak")
            @Override
            protected Integer doInBackground(Integer... integers) {
                try {
// wait for 5 seconds to simulate a long network access
                    int i;
                    for (i = 0; i < 10; i++) {
//                    Log.i(mess,"loop"+i);
                        Thread.sleep(1000);
                        ProgressHandlerMessage.sendEmptyMessage(i);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        };
    }
}