package servlets;

import utils.DataBaseUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clearDB")
public class ClearDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DataBaseUtils.clearDataBase();
        resp.sendRedirect(req.getContextPath() + "/index");
    }

}
