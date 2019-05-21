package Delegate.Handler;

import Delegate.Msg.Message;

/**
 * Created by oahnus on 2019/4/3
 * 23:29.
 */
public interface MessageHandler {
    void handleMessage(Message msg);
    String getType();
}
