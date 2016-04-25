package com.Uddhav.ENTTool.utils;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class MainThreadBus extends Bus {
    // I am using the Otto bus. Otto is a great way to communicate between your activity and fragments or
    // to communicate between an activity and a service.
    //Bus does communication through handlers. Handler is the android OS's handler. Means, android.os.handler


    private final Handler mHandler = new Handler(Looper.getMainLooper()); //This return the Application's main looper
    // to the Handler. Handler is used to send messages and runnable objects to the.
    //A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue.

//    There are two main uses for a Handler:
// (1) to schedule messages and runnables to be executed as some point in the future; and (
// 2) to enqueue an action to be performed on a different thread than your own.

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) { // means, I am in the active Looper

            super.post(event); // post and event. event, here, is an object. So, I am posting Object
            //Super.post(event) does post the event to all registered handlers of the MainLooper
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadBus.super.post(event);
                }
            });
        } // hover mouse over arrow to know the above code
    }
}