package Controller;

import Controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CookiesAction implements Command {

    final String urlPattern = "Cookies";
    @Override
    public String getPattern() {
        return urlPattern;
    }

    /**
     * select cookies
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ck[]=request.getCookies();
        HttpSession session = request.getSession();
        for(Cookie c : ck)
        {
            if(c.getName().compareTo("data")==0)
                session.setAttribute("cookiesAction1", "data" + c.getValue());

        }

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/View/cookies.jsp");
        dispatcher.forward(request, response);
    }

}