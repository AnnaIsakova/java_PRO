import java.util.ArrayList;

/**
 * Created by Ootka on 18-Jan-17.
 */
public class Question {
    private String question;
    ArrayList<Answer> answers = new ArrayList<>();

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
