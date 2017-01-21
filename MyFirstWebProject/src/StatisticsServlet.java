import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ootka on 18-Jan-17.
 */
public class StatisticsServlet extends HttpServlet {

    static final String TEMPLATE = "<html lang=\"en\">" +
            "<head><meta charset=\"UTF-8\"><title>My1Web</title>" +
            "</head><body><p>%s</p></body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        sb.append("<p><b>" + MainServlet.dzen.getQuestion() + "</b><br/>");
        for (Answer a: MainServlet.dzen.answers) {
            if (a.answer.equals("neDzen")){
                sb.append("Не дзен - " + a.couter + " ответа(ов).<br/>");
            } else if (a.answer.equals("dzen")){
                sb.append("Дзен - " + a.couter + " ответа(ов).<br/>");
            } else if (a.answer.equals("pDzen")){
                sb.append("Полный дзен - " + a.couter + " ответа(ов).<br/></p>");
            }
        }
        sb.append("<p><b>" + MainServlet.gym.getQuestion() + "</b><br/>");
        for (Answer a: MainServlet.gym.answers) {
            if (a.answer.equals("neHozhu")){
                sb.append("Не хожу - " + a.couter + " ответа(ов).<br/>");
            } else if (a.answer.equals("threeTimes")){
                sb.append("Три раза в неделю - " + a.couter + " ответа(ов).<br/>");
            } else if (a.answer.equals("everyDay")){
                sb.append("Каждый день - " + a.couter + " ответа(ов).<br/></p>");
            }
        }
        resp.getWriter().println(String.format(TEMPLATE, sb.toString()));
    }
}
