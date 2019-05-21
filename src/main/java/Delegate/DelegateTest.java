package Delegate;

import Delegate.Handler.BusinessMsgHandler;
import Delegate.Handler.LogMsgHandler;
import Delegate.Msg.BusinessMessage;
import Delegate.Msg.LogMessage;

/**
 * Created by oahnus on 2019/4/3
 * 23:39.
 */
public class DelegateTest {
    public static void main(String... args) {
        MessageDispatcher dispatcher = new MessageDispatcher();
        dispatcher.initHandler(new BusinessMsgHandler());
        dispatcher.initHandler(new LogMsgHandler());

        dispatcher.handleMessage(new LogMessage("This Is A Log Info"));
        dispatcher.handleMessage(new BusinessMessage("This Is A Business Info"));
    }
}
