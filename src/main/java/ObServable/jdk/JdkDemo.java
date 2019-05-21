package ObServable.jdk;

/**
 * Created by oahnus on 2019/5/21
 * 23:55.
 */
public class JdkDemo {
    public static void main(String[] args) {
        QuestionPublisher publisher = new QuestionPublisher();
        Question question = publisher.publishQuestion("问题");
        Answer answer = new Answer("回答者");
        // 回答者回答问题后，会触发通知 发布者有人回答了问题
        answer.answerQuestion(question);
    }
}
