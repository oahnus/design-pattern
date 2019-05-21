package ObServable.guava;

import ObServable.jdk.Question;
import com.google.common.eventbus.EventBus;
import lombok.Data;

/**
 * Created by oahnus on 2019/5/21
 * 23:49.
 */
@Data
public class GAnswer {
    private String name;

    public GAnswer(String name) {
        this.name = name;
    }

    public void answerQuestion(EventBus bus, GQuestion question) {
        question.answer("回答问题", this.name);
        bus.post(question);
    }
}
