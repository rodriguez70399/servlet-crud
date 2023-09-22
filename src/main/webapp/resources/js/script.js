let positionSelect = document.getElementById("positionSelect");
let extraDataContainer = document.getElementById("extraDataContainer");
let inputType = "";
let inputText = "";
let inputName = "";

positionSelect.addEventListener("change", function()
{
    let selectedOption = positionSelect.value;
    let input;

    console.log("Entro");

    extraDataContainer.innerHTML = "";

    switch (selectedOption) 
    {
        case "developer":
            inputType = "text";
            inputText = "Lenguaje de programación";
            inputName = "languaje";
            console.log("Entro");
            break;
        case "designer":
            inputType = "text";
            inputText = "Herramienta de diseño";
            inputName = "tool";
            console.log("Entro");
            break;
        case "projectManager":
            inputType = "number";
            inputText = "Proyectos asignados";
            inputName = "projects";
            console.log("Entro");
            break;
    }

    input = `
        <div class="mb-3">
            <label for="${inputName}" class="form-label">${inputText}</label>
            <input type="${inputType}" class="form-control" id="${inputName}" name="${inputName}">
        </div>`;

    extraDataContainer.insertAdjacentHTML("beforeend", input);
})