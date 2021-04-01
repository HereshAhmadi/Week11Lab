package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        String sessionuuid = (String)request.getSession().getAttribute("uuid");

        if (sessionuuid != null) {
            accountService.changePassword(sessionuuid, request.getParameter("nPass"));
            request.setAttribute("message", "Password has been changed");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else{
                String path = getServletContext().getRealPath("/WEB-INF");                
                String url = request.getRequestURL().toString();
                String uuid = accountService.resetPassword(request.getParameter("email_address"), path, url);
                request.getSession().setAttribute("uuid", uuid);

                String message = "Reset email send";
                request.getSession().setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
    

}
