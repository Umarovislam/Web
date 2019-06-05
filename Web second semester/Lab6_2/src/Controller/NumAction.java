package Controller;

import Controller.command.Command;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFree;
import java.io.IOException;
import java.util.ArrayList;


public class NumAction implements Command {

    @EJB
    DaoFree daoFree;

    public NumAction(DaoFree df){
        this.daoFree = df;
    }

    @Override
    public String getPattern() {
        return null;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String errorString = null;

        ArrayList<String> nums = null;
        try {
            nums = daoFree.getFreeNum();
        } catch (Exception daoExceptions) {
            daoExceptions.printStackTrace();
            errorString = daoExceptions.getMessage();
        }
        request.setAttribute("numsAction",nums );

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/View/getNumResult.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
