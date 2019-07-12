package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class EndpointAsyncTask  extends AsyncTask<Void, Void, String> {
    final CountDownLatch signal = new CountDownLatch(1);
    private OnRequestFinish onRequestFinish;
    private static MyApi myApiServices = null;
    public EndpointAsyncTask(OnRequestFinish onRequestFinish) {
        this.onRequestFinish = onRequestFinish;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiServices == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName("Jokes App");

            myApiServices = builder.build();
        }
        try {
            return myApiServices.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result!= null) {
            signal.countDown();
            onRequestFinish.onFinish(result);
        }
    }

    public interface OnRequestFinish {
        void onFinish(String s);
    }
}

