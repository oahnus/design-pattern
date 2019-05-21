package Delegate.Handler;

import Delegate.Msg.Message;

/**
 * Created by oahnus on 2019/4/3
 * 23:42.
 */
public class LogMsgHandler implements MessageHandler {
    @Override
    public void handleMessage(Message msg) {
        System.out.println("Log Handler Receive Msg: " + msg.getMsg());
    }

    @Override
    public String getType() {
        return "LOG";
    }
}
