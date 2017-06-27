package com.example.vaibhav.cb_asynctask;

import android.os.AsyncTask;

/**
 * Created by vaibhav on 25-06-2017.
 */
class NSecWaitTask extends AsyncTask<Integer, Float, String> {

    private MainActivity mainActivity;

    public NSecWaitTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... integers) {

        for (int i = 0; i < integers[0] * 2; i++) {
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() < startTime + 500) {
                publishProgress(((float) i)/2);
            }
        }


        return "BOOM";
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        mainActivity.tvResult.setText(String.valueOf(values[0]));

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {

        mainActivity.tvResult.setText(s);

        super.onPostExecute(s);
    }
}
