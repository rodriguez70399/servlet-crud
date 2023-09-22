<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                        <a class="nav-link" aria-current="page" href="/servlet-crud">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="create-employee">Contratar Empleado</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="container">

        <div class="row justify-content-center mt-5">
            
            <div class="col-lg-4 col-md-6 col-8 col-sm-10 col-xs-12">
                <div class="card shadow">
                    <h5 class="card-header">Nuevo empleado 👨🏽‍💻👩🏽‍💻</h5>
    
                    <div class="card-body">
    
                        <form action="add-employee" method="post">
                            
                            <div class="mb-3">
                                <label for="name" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            
                            <div class="mb-3">
                                <label for="salary" class="form-label">Salario Base</label>
                                <input type="number" class="form-control" id="salary" name="salary">
                            </div>
                            
                            <div class="mb-3">
                                <label for="positionSelect" class="form-label">Puesto</label>
                                <select class="form-select" id="positionSelect" name="position">
                                    <option value="developer" selected>Desarrollador</option>
                                    <option value="designer">Diseñador</option>
                                    <option value="projectManager">Jefe de Proyecto</option>
                                </select>
                            </div>

                            <div id="extraDataContainer">

                            </div>

                            <button type="submit" class="btn btn-primary">Contratar</button>

                        </form>

                    </div>
            </div>

        </div>

    </main>

    <!-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

    <script>
        let positionSelect = document.getElementById("positionSelect");
        let extraDataContainer = document.getElementById("extraDataContainer");
        let inputType = "";
        let inputText = "";
        let inputName = "";
        let defaultInput = `
            <div class="mb-3">
                <label for="language" class="form-label">Lenguaje de programación</label>
                <input type="text" class="form-control" id="language" name="language">
            </div>`;

        positionSelect.addEventListener("change", function () {
            let selectedOption = positionSelect.value;
            let input;

            extraDataContainer.innerHTML = "";

            switch (selectedOption) {
                case "developer":
                    inputType = "text";
                    inputText = "Lenguaje de programación";
                    inputName = "language";
                    break;
                case "designer":
                    inputType = "text";
                    inputText = "Herramienta de diseño";
                    inputName = "tool";
                    break;
                case "projectManager":
                    inputType = "number";
                    inputText = "Proyectos asignados";
                    inputName = "projects";
                    break;
            }

            input = `
            <div class="mb-3">
                <label for="${inputName}" class="form-label">${inputText}</label>
                <input type="${inputType}" class="form-control" id="${inputName}" name="${inputName}">
            </div>`;

            extraDataContainer.insertAdjacentHTML("beforeend", input);
        })

        extraDataContainer.insertAdjacentHTML("beforeend", defaultInput);

    </script>
</body>
</html>