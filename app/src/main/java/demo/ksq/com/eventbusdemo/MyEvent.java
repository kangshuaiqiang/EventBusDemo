package demo.ksq.com.eventbusdemo;

/**
 * Created by 黑白 on 2017/12/8.
 */

public class MyEvent {
    private String msg;

    public MyEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
