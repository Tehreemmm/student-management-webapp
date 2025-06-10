package servlet;

import dao.StudentDAO;
import model.Student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String country = request.getParameter("country");

        Student student = new Student(id, name, email, course, country);
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
