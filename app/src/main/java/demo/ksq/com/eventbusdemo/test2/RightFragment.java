package demo.ksq.com.eventbusdemo.test2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import demo.ksq.com.eventbusdemo.MyEvent;
import demo.ksq.com.eventbusdemo.R;

/**
 * Created by 黑白 on 2017/12/8.
 */

public class RightFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        textView = view.findViewById(R.id.text3);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

    }

    //接收到的线程和发送的线程是同一个线程

    /**
     * 与发布者再同一个线程中
     *
     * @param event
     */
    @Subscribe
    public void onEvent(MyEvent event) {
        String content = event.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEvent----myevent" + content);
    }

    //接收到的线程和发送的线程是同一个线程

    /**
     * 与发布者再同一个线程中
     *
     * @param event
     */
    @Subscribe
    public void onEvent(MyEvent1 event) {
        String content = event.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEvent----myevent1" + content);
    }

    /**
     * 执行在主线程中
     * 非常实用直接可以进行UI操作
     *
     * @param event
     */
    @Subscribe
    public void onEventMainThread(MyEvent1 event) {
        String content = event.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEventMainThread----myevent1" + content);
    }

    @Subscribe
    public void onEventMainThread(MyEvent event) {
        String content = event.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEventMainThread----myevent" + content);
    }


    /**
     * 执行在一个新的线程
     * 适用多线程处理，内部有线程池管理
     *
     * @param event1
     */
    @Subscribe
    public void onEventAsync(MyEvent event1) {
        String content = event1.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEventAsync----myevent" + content);
    }

    /**
     * 执行在子线程  如果发布者在子线程就会直接执行
     * 如果不是在子线程就会创建一个新的线程
     *
     * @param event1
     */
    @Subscribe
    public void onEventBackgroundThread(MyEvent event1) {
        String content = event1.getMsg() + "\nthreadName" + Thread.currentThread().getName() + Thread.currentThread().getId();
        Log.d("zzzzzz", "onEventBackgroundThread----myevent" + content);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
