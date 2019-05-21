package Delegate.Msg;

/**
 * Created by oahnus on 2019/4/3
 * 23:32.
 */
public class BusinessMessage extends Message {
    public BusinessMessage(String msg) {
        this.type = "BUSINESS";
        this.msg = msg;
    }
}
