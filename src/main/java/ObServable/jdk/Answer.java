package ObServable.jdk;

import lombok.Data;

/**
 * Created by oahnus on 2019/5/21
 * 23:49.
 */
@Data
public class Answer {
    private String name;

    public Answer(String name) {
        this.name = name;
    }

    public void answerQuestion(Question question) {
        question.answer("回答问题", this.name);
        question.notifyObservers();
    }
}
