package Delegate;

import Delegate.Handler.MessageHandler;
import Delegate.Msg.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oahnus on 2019/4/3
 * 23:26.
 */
public class MessageDispatcher implements MessageHandler {

    Map<String, MessageHandler> handlers = new HashMap<>();

    public void initHandler(MessageHandler handler) {
        if (!handlers.containsKey(handler.getType())) {
            handlers.put(handler.getType(), handler);
        }
    }

    @Override
    public void handleMessage(Message msg) {
        MessageHandler handler = handlers.get(msg.getType());
        if (handler == null) {
            throw new RuntimeException("Cannot Find Message Handler");
        }
        handler.handleMessage(msg);
    }

    @Override
    public String getType() {
        return null;
    }
}
