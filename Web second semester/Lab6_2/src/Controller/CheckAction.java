package Controller;

import Controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.DaoChecks;
import java.io.IOException;
import java.util.ArrayList;


public class CheckAction implements Command {

    final String urlPattern = "check";

    DaoChecks daoChecks;

    public CheckAction(DaoChecks dch){
        this.daoChecks = dch;
    }


    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String errorString = null;

        ArrayList<String> checks = null;
        try {
            checks = daoChecks.NotClosedChecks();
        } catch (Exception daoExceptions) {
            daoExceptions.printStackTrace();
            errorString = daoExceptions.getMessage();
        }
        request.setAttribute("checksAction",checks );

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/View/getChecksResult.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

