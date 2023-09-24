package es.jmruirod.servletcrud.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.jmruirod.servletcrud.dao.DesignerDao;
import es.jmruirod.servletcrud.dao.DeveloperDao;
import es.jmruirod.servletcrud.dao.EmployeeDao;
import es.jmruirod.servletcrud.dao.ProjectManagerDao;
import es.jmruirod.servletcrud.model.Designer;
import es.jmruirod.servletcrud.model.Developer;
import es.jmruirod.servletcrud.model.Employee;
import es.jmruirod.servletcrud.model.ProjectManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexServlet", urlPatterns = {"/servlet-crud"})
public class IndexServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        EmployeeDao employeeDao = new EmployeeDao();
        DeveloperDao developerDao = new DeveloperDao();
        DesignerDao designerDao = new DesignerDao();
        ProjectManagerDao projectManagerDao = new ProjectManagerDao();

        developerDao.save(new Developer("Ramon", 23000, "Java"));
        designerDao.save(new Designer("Lucia", 19000, "Canva"));
        projectManagerDao.save(new ProjectManager("Juan Pablo", 30000, 5));

        List<Employee> employeeList = employeeDao.getAll();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }    
}
