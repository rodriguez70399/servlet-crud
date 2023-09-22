package es.jmruirod.servletcrud.model;

/**
 * Clase Designer que representa a un diseñador en la empresa.
 * 
 * <p>Extiende la clase Employee y también implementa la interfaz Taskable
 * para proporcionar una implementación de realizar tareas específica para diseñadores.</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see Employee
 * @see Taskable
 */
public class Designer extends Employee implements Taskable
{
    private String principalDesignTool;

    /**
     * Constructor de la clase Designer.
     *
     * @param employeeId          El ID único del diseñador.
     * @param name                El nombre del diseñador.
     * @param baseSalary          El salario base del diseñador.
     * @param principalDesignTool La herramienta de diseño principal utilizada por el diseñador.
     */
    public Designer(int employeeId, String name, double baseSalary, String principalDesignTool)
    {
        super(employeeId, name, PositionsNames.DESIGNER, baseSalary);
        this.principalDesignTool = principalDesignTool;
    }

    public String getPrincipalDesignTool() 
    {
        return principalDesignTool;
    }

    public void setPrincipalDesignTool(String principalDesignTool) 
    {
        this.principalDesignTool = principalDesignTool;
    }

    /**
     * Metodo abstracto implementado de la clase Employee que calcula el salario del diseñador,
     * aplicando un aumento del 15% al salario base.
     *
     * @return El salario calculado del diseñador.
     */
    @Override
    public double calculateSalary() 
    {
        return this.getBaseSalary() * 1.15;
    }

    /**
     * Metodo implementado de la interfaz Taskable para indicar la tarea que realizan los diseñadores.
     */
    @Override
    public void performTasks() 
    {
        System.out.println("\nEl diseñador " + this.getName() + " esta haciendo un diseño en " + this.getPrincipalDesignTool());
    }
}