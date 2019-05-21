package ObServable.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by oahnus on 2019/5/22
 * 0:09.
 */
public class GPublisher {
    @Subscribe
    public void questionUpdate(GQuestion question) {
        System.out.println(String.format("\"%s\"回答了问题:\"%s\", 答案是:\"%s\"",
                question.getAnswerUserName(),
                question.getTitle(),
                question.getAnswerUserName()));
    }

    public GQuestion publishQuestion(String title) {
        GQuestion question = new GQuestion();
        question.setTitle(title);
        return question;
    }
}
