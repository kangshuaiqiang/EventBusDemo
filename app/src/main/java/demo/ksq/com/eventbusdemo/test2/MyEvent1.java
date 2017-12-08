package demo.ksq.com.eventbusdemo.test2;

/**
 * Created by 黑白 on 2017/12/8.
 */

public class MyEvent1 {
    private String msg;

    public MyEvent1(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
