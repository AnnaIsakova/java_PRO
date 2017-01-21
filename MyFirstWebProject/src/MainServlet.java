/**
 * Created by Ootka on 17-Jan-17.
 */
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


public class MainServlet extends HttpServlet{

    static ArrayList<User> users = new ArrayList<>();
    static Question dzen;
    static Question gym;

    public MainServlet() {
        dzen = new Question("Какое у вас состояние разума?");
        dzen.answers.add(new Answer("neDzen"));
        dzen.answers.add(new Answer("dzen"));
        dzen.answers.add(new Answer("pDzen"));

        gym = new Question("Как часто вы ходите в тренажерный зал?");
        gym.answers.add(new Answer("neHozhu"));
        gym.answers.add(new Answer("threeTimes"));
        gym.answers.add(new Answer("everyDay"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String ageS = req.getParameter("age");
        int age = Integer.parseInt(ageS);
        users.add(new User(firstName, lastName, age));
        String answer1 = req.getParameter("dzen");

        for (Answer a:dzen.answers) {
            if (a.answer.equals(answer1)){
                a.couter++;
            }
        }
        String answer2 = req.getParameter("gym");
        for (Answer a:gym.answers) {
            if (a.answer.equals(answer2)){
                a.couter++;
            }
        }
        resp.sendRedirect("/statistics");
    }

}
