package es.jmruirod.servletcrud.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddEmployee", urlPatterns = {"/add-employee"})
public class AddEmployee extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println(request.getAttribute("name"));
        System.out.println(request.getAttribute("salary"));
        System.out.println(request.getAttribute("position"));

        // switch (request.getAttribute("position").toString()) 
        // {
        //     case "developer":
        //         System.out.println(request.getAttribute("language"));
            
        //         break;
        //     case "designer":
        //         System.out.println(request.getAttribute("tool"));
            
        //         break;
        //     case "projectManager":
        //         System.out.println(request.getAttribute("projects"));
        //         break;
        
        //     default:
        //         break;
        // }

        response.sendRedirect("/servlet-crud");        
    }
}
