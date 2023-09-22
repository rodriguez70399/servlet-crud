package es.jmruirod.servletcrud.model;

/**
 * Clase abstracta Employee que representa a un empleado genérico en la empresa.
 * 
 * <p>Las clases concretas deben extender Employee y proporcionar una implementación concreta
 * del método calculateSalary().</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see Employee#calculateSalary()
 * @see Developer
 * @see Designer
 * @see ProjectManager
 */
public abstract class Employee 
{
    private int employeeId;
    private String name;
    private String position;
    private double baseSalary;

    /** Salario mínimo base para todos los empleados. */
    public final static double MINIMUM_SALARY = 17000;

    /**
     * Constructor de la clase Employee.
     *
     * @param employeeId El ID único del empleado.
     * @param name       El nombre del empleado.
     * @param position   El puesto del empleado.
     * @param baseSalary El salario base del empleado.
     */
    public Employee(int employeeId, String name, String position, double baseSalary) 
    {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() 
    {
        return employeeId;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getPosition()
    {
        return this.position;
    }

    public double getBaseSalary() 
    {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) 
    {
        this.baseSalary = baseSalary;            
    }

    public abstract double calculateSalary();

    @Override
    public String toString() 
    {
        return "Empleado [id=" + employeeId + ", nombre=" + name + ", puesto=" + position + "]";
    }

    
}
