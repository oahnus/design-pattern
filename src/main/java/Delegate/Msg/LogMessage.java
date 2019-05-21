package Delegate.Msg;

/**
 * Created by oahnus on 2019/4/3
 * 23:33.
 */
public class LogMessage extends Message {
    public LogMessage(String msg) {
        this.msg = msg;
        this.type = "LOG";
    }
}
