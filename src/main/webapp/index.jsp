<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="es.jmruirod.servletcrud.model.Employee" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Inicio</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/servlet-crud">RRHH</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/servlet-crud">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="add-employee.jsp">Contratar Empleado</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="container">

        <div class="row justify-content-center mt-5">
            
            <div class="col-auto">
                
            <%
                List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
                
                if(employeeList.size() > 0)
                {
                    
            %>
                    <h2>Listado de empleados</h2>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Salario Base</th>
                                <th scope="col">Puesto</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">${employee.employeeId()}</th>
                                <td>${employee.name}</td>
                                <td>${employee.baseSalary}</td>
                                <td>${employee.position}</td>
                                <td>
                                    <a href="#" class="btn btn-primary" role="button" aria-disabled="true">Modificar</a>
                                    <a href="#" class="btn btn-danger" role="button" aria-disabled="true">Despedir</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
            <%
                }
                else
                {
            %>
                    <h2>No se encuentra ningun empleado</h2> 
            <%
                }
            %>      

            </div>
            
        </div>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>