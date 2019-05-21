package ObServable.guava;

import lombok.Data;

/**
 * Created by oahnus on 2019/5/22
 * 0:13.
 */
@Data
public class GQuestion {
    private String title;
    private String answer;
    private String answerUserName;

    public void answer(String answer, String userName) {
        this.answer = answer;
        this.answerUserName = userName;
    }
}
