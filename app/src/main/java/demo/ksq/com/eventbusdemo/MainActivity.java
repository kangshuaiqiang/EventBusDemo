package demo.ksq.com.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EventBus.getDefault().register(this);

        /*button = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });*/

    }

    /**
     * 3.0之间使用的事注解方式进行传值
     * 3.0后强制规定 自定扫描方法 规定方法名
     *
     * @param event
     * @Subscribe 添加注释
     */
   /* @Subscribe
    public void onEventMainThread(MyEvent event) {

        String mug = "返回的数据" + event.getMsg();
        tv.setText(mug);
    }*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
