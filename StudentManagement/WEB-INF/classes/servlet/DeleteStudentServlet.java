package servlet;

import dao.StudentDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            studentDAO.deleteStudent(id);
        } catch (SQLException e) {
            throw new ServletException("Cannot delete student", e);
        }
        response.sendRedirect("list");
    }
}
