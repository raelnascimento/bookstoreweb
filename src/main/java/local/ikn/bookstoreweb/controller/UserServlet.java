
package local.ikn.bookstoreweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import local.ikn.bookstoreweb.model.bean.User;
import local.ikn.bookstoreweb.model.dao.UserDAO;


public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String action = request.getPathInfo();
        Logger.getLogger(BookServlet.class.getName()).log(Level.INFO, "Path solicitado: {0}", action);

        try {
            switch (action) {
                case "/new":
                    showNewUserForm(request, response);
                    break;

                case "/register":
                    registerUserAction(request, response);
                    break;
                
                case "/login":
                    login(request, response);
                    break;
                    
                case "/list":
                    listUser(request, response);
                    break;
                    
                default:

                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        UserDAO userDAO = new UserDAO();
        List<User> listaUser = userDAO.getResults();

        Logger.getLogger(UserDAO.class.getName()).log(Level.INFO,
                "Total de reqistros: {0}", listaUser.size());

        request.setAttribute("listaUser", listaUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListUser.jsp");
        dispatcher.forward(request, response);

    }

    private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/FormUser.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("register");

    }

    private void registerUserAction(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        UserDAO userDAO = new UserDAO();
        User novoUser = new User();
        
        novoUser.setEmail(request.getParameter("formEmail"));
        novoUser.setFullname(request.getParameter("formFullname"));
        novoUser.setPassword(request.getParameter("formPassword"));

        userDAO.create(novoUser);
        response.sendRedirect("../login");
    }
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("../loginPage.jsp");
        dispatcher.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
