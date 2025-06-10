package servlet;

import dao.StudentDAO;
import model.Student;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.List;

public class ListStudentsServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = studentDAO.selectAllStudents();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student List</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 80%; margin: auto; }");
        out.println("th, td { border: 1px solid #000; padding: 8px; text-align: center; }");
        out.println("</style></head><body>");
        out.println("<h2 style='text-align:center;'>All Students</h2>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Country</th></tr>");

        for (Student s : students) {
            out.println("<tr>");
            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getEmail() + "</td>");
            out.println("<td>" + s.getCourse() + "</td>");
            out.println("<td>" + s.getCountry() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
