package servlet;

import dao.StudentDAO;
import model.Student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String country = request.getParameter("country");

        Student newStudent = new Student(name, email, course, country);
        try {
            studentDAO.insertStudent(newStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
