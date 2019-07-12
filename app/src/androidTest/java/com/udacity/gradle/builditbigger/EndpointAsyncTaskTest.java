package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    public EndpointAsyncTaskTest() {
        super();
    }

    @Test
    public void testGetJokeTask() throws ExecutionException, InterruptedException {
        EndpointAsyncTask testJoke = new EndpointAsyncTask(new EndpointAsyncTask.OnRequestFinish() {
            @Override
            public void onFinish(String s) {

            }

        });
        testJoke.execute();
        String joke = testJoke.get();
        assertNotNull(joke);
    }
}
