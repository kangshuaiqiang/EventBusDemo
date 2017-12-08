package demo.ksq.com.eventbusdemo.test2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import demo.ksq.com.eventbusdemo.MyEvent;
import demo.ksq.com.eventbusdemo.R;

/**
 * Created by 黑白 on 2017/12/8.
 */

public class ListFragment extends android.app.ListFragment {


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] str = {"主线程消息", "子线程消息1", "主线程消息2"};

        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, str));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {
            case 0:
                //主线程
                Log.d("zzzzzz", "主线程发送的消息1" + "Thread" + Thread.currentThread().getName() + Thread.currentThread().getId());

                EventBus.getDefault().post(new MyEvent("主线程消息"));

                break;
            case 1:
                //子线程
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Log.d("zzzzzz", "子线程发送的消息1" + "Thread" + Thread.currentThread().getName() + Thread.currentThread().getId());
                        EventBus.getDefault().post(new MyEvent("子线程消息"));
                    }
                }.start();
                break;
            case 2:
                //主线程2

                Log.d("zzzzzz", "主线程发送的消息2" + "Thread" + Thread.currentThread().getName() + Thread.currentThread().getId());

                EventBus.getDefault().post(new MyEvent1("主线程消息2"));
                break;
        }
    }
}
