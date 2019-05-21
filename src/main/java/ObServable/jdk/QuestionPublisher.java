package ObServable.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by oahnus on 2019/5/21
 * 23:49.
 */
public class QuestionPublisher implements Observer {
    public void update(Observable o, Object arg) {
        Question question = (Question) o;
        System.out.println(String.format("\"%s\"回答了问题:\"%s\", 答案是:\"%s\"",
                question.getAnswerUserName(),
                question.getTitle(),
                question.getAnswerUserName()));
    }

    public Question publishQuestion(String title) {
        Question question = new Question();
        question.setTitle(title);
        question.addObserver(this);
        return question;
    }
}
