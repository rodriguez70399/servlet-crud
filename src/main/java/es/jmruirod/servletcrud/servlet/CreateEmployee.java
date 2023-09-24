package es.jmruirod.servletcrud.servlet;

import java.io.IOException;

import es.jmruirod.servletcrud.dao.DesignerDao;
import es.jmruirod.servletcrud.dao.DeveloperDao;
import es.jmruirod.servletcrud.dao.ProjectManagerDao;
import es.jmruirod.servletcrud.model.Designer;
import es.jmruirod.servletcrud.model.Developer;
import es.jmruirod.servletcrud.model.ProjectManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateEmployee", urlPatterns = {"/create-employee"})
public class CreateEmployee extends HttpServlet
{
    private DesignerDao designerDao;
    private DeveloperDao developerDao;
    private ProjectManagerDao projectManagerDao;
    
    @Override
    public void init() throws ServletException 
    {
        designerDao = new DesignerDao();
        developerDao = new DeveloperDao();
        projectManagerDao = new ProjectManagerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String position = request.getParameter("position");
        boolean prueba = false;
    
        switch (position) 
        {
            case "developer":
                String language = request.getParameter("language");
                prueba = this.developerDao.save(new Developer(name, salary, language));     
                break;
            case "designer":
                String tool = request.getParameter("tool");
                this.designerDao.save(new Designer(name, salary, tool));
                break;
            case "projectManager":
                int projects = Integer.parseInt(request.getParameter("projects"));
                this.projectManagerDao.save(new ProjectManager(name, salary, projects));
                break;
        }

        System.out.println(prueba);

        // request.getRequestDispatcher("index.jsp").forward(request, response);

        response.sendRedirect("/servlet-crud");        
    }
}
