package ObServable.jdk;

import lombok.Data;

import java.util.Observable;

/**
 * Created by oahnus on 2019/5/21
 * 23:49.
 */
@Data
public class Question extends Observable {
    private String title;
    private String answer;
    private String answerUserName;

    public void answer(String answer, String userName) {
        this.answer = answer;
        this.answerUserName = userName;
        setChanged();
    }
}
