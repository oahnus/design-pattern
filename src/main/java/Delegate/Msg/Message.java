package Delegate.Msg;

/**
 * Created by oahnus on 2019/4/3
 * 23:30.
 */
public abstract class Message {
    protected String type;
    protected String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
