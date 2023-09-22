package es.jmruirod.servletcrud.model;

/**
 * Interfaz Taskable que representa acciones que realizan empleados de rango inferior.
 * 
 * <p>Las clases que implementen esta interfaz deben proporcionar una implementación de los métodos.</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see Developer
 * @see Designer
 * 
 */
public interface Taskable 
{
    /**
     * Realizacion de la tarea principal de un puesto con rango inferior.
     */
    public void performTasks();
}
