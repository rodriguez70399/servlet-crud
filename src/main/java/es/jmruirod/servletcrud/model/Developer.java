package es.jmruirod.servletcrud.model;

/**
 * Clase Developer que representa a un desarrollador en la empresa.
 * 
 * <p>Extiende la clase Employee y también implementa la interfaz Taskable
 * para proporcionar una implementación de realizar tareas específicas para desarrolladores.</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see Employee
 * @see Taskable
 */
public class Developer extends Employee implements Taskable
{
    private String principalLanguage;

    /**
     * Constructor de la clase Developer.
     *
     * @param employeeId       El ID único del desarrollador.
     * @param name             El nombre del desarrollador.
     * @param baseSalary       El salario base del desarrollador.
     * @param principalLanguage El lenguaje de programación principal utilizado por el desarrollador.
     */
    public Developer(int employeeId, String name, double baseSalary, String principalLanguaje) 
    {
        super(employeeId, name, PositionsNames.DEVELOPER, baseSalary);
        this.principalLanguage = principalLanguaje;
    }

    public String getPrincipalLanguage() 
    {
        return principalLanguage;
    }

    public void setPrincipalLanguage(String principalLanguage) 
    {
        this.principalLanguage = principalLanguage;
    }

    /**
     * Metodo abstracto implementado de la clase Employee que calcula el salario del desarrollador,
     * aplicando un aumento del 20% al salario base.
     *
     * @return El salario calculado del diseñador.
     */
    @Override
    public double calculateSalary() 
    {
        return this.getBaseSalary() * 1.2;
    }

    /**
     * Metodo implementado de la interfaz Taskable para indicar la tarea que realizan los desarrolladores.
     */
    @Override
    public void performTasks() 
    {
        System.out.println("\nEl programador " + this.getName() + " esta programando en " + this.principalLanguage);        
    }
}
