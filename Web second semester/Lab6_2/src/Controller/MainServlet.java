package Controller;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import dao.DaoChecks;
import dao.DaoFree;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    DaoChecks daoChecks;

    @EJB
    DaoFree daoFree;

    public MainServlet() {
        super();
    }

    @Override
    public void init() {

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        ActionManager manager = new ActionManager();
        try {
            String pageName = request.getParameter("command");
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            Cookie ck=new Cookie("data",timeStamp);
            response.addCookie(ck);
            manager.setBeans(daoChecks, daoFree);
            manager.getCommand(pageName).doGet(request, response);
        }
        catch (Exception e) {
            HttpSession session = request.getSession();
            session.setAttribute("error", e);
            response.sendRedirect("error.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {

        }
    }
}
