package Delegate.Handler;

import Delegate.Msg.Message;

/**
 * Created by oahnus on 2019/4/3
 * 23:44.
 */
public class BusinessMsgHandler implements MessageHandler {
    @Override
    public void handleMessage(Message msg) {
        System.out.println("Business Handler Receive Msg: " + msg.getMsg());
    }

    @Override
    public String getType() {
        return "BUSINESS";
    }
}
