package ObServable.guava;

import com.google.common.eventbus.EventBus;

/**
 * Created by oahnus on 2019/5/22
 * 0:09.
 */
public class GuavaDemo {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GPublisher publisher = new GPublisher();
        eventBus.register(publisher);

        GQuestion question = publisher.publishQuestion("问题2");
        GAnswer answer = new GAnswer("小红");
        answer.answerQuestion(eventBus, question);
        eventBus.post("这里是答案");
    }
}
