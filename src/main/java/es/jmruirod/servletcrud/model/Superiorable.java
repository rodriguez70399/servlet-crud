package es.jmruirod.servletcrud.model;

/**
 * Interfaz Superiorable que representa acciones que solo pueden realizar un superiores.
 * 
 * <p>Las clases que implementen esta interfaz deben proporcionar una implementación de los métodos</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see ProjectManager
 */
public interface Superiorable 
{
    /**
     * Realiza una llamada de atencion a empleados con un rango inferior en la empresa.
     */
    public void reprimand();
}
