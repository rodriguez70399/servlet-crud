package es.jmruirod.servletcrud.model;

/**
 * Clase ProjectManager que representa a un jefe de proyecto en la empresa.
 * 
 * <p>Extiende la clase Employee e implementa la interfaz Superiorable
 * para proporcionar una implementación de la función de regañar.</p>
 * 
 * @author Jose Manuel Ruiz Rodriguez
 * @see Employee
 * @see Superiorable
 */
public class ProjectManager extends Employee implements Superiorable
{
    private int assignedProjects;
    private boolean isMeeting;
    private long startMeetingTime;

    /**
     * Constructor de la clase ProjectManager.
     *
     * @param employeeId       El ID único del jefe de proyecto.
     * @param name             El nombre del jefe de proyecto.
     * @param baseSalary       El salario base del jefe de proyecto.
     * @param assignedProjects El número de proyectos asignados al jefe de proyecto.
     */
    public ProjectManager(int employeeId, String name, double baseSalary, int assignedProjects) 
    {
        super(employeeId, name, PositionsNames.PROJECT_MANAGER, baseSalary);
        this.assignedProjects = assignedProjects;
        this.isMeeting = false;
        this.startMeetingTime = 0l;
    }

    public int getAssignedProjects() 
    {
        return this.assignedProjects;
    }

    public void setAssignedProjects(int assignedProjects) 
    {
        this.assignedProjects = assignedProjects;
    }

    /**
     * Comprueba si el jefe de proyecto está en una reunión.
     *
     * @return true si el jefe de proyecto está en una reunión, false de lo contrario.
     */
    public boolean isMeeting() 
    {
        return isMeeting;
    }

    /**
     * Inicia una reunión si el jefe de proyecto no está en una reunión actualmente.
     * Registra el tiempo de inicio de la reunión.
     */
    public void startMeeting()
    {
        if(!this.isMeeting)
        {
            this.isMeeting = true;
            this.startMeetingTime = System.currentTimeMillis();
            System.out.println("\nEl jefe de proyecto " + this.getName() + " empezo una reunion.");
        }
        else
        {
            System.out.println("\nEl jefe de proyecto " + this.getName() + " ya esta reunido.");
        }
    }

    /**
     * Detiene una reunión si el jefe de proyecto está en una reunión actualmente.
     */
    public void stopMeeting()
    {
        if (isMeeting) 
        {
            System.out.println("\nEl jefe de proyecto " + this.getName() + " termino la reunion en " + this.getCurrentMeetingTime() + " minutos.");
            this.isMeeting = false;
        }
        else
        {
            System.out.println("\nEl jefe de proyecto " + this.getName() + " no esta reunido.");
        }
    }

    /**
     * Obtiene la duración actual de la reunión en segundos.
     *
     * @return La duración de la reunión en segundos.
     */
    public double getCurrentMeetingTime()
    {
        double meetingTime = 0;

        if (this.isMeeting) 
        {
            meetingTime = (System.currentTimeMillis() - this.startMeetingTime) / 60000.0;
        }
        
        return meetingTime;
    }

    /**
     * Metodo abstracto implementado de la clase Employee que calcula el salario del jefe de proyecto,
     * sumandole al salario base el numero de proyecto a su cargo por 1000.
     *
     * @return El salario calculado del diseñador.
     */
    @Override
    public double calculateSalary() 
    {
        return this.getBaseSalary() + (this.assignedProjects * 1000);
    }

    /**
     * Metodo implementado de la interfaz Superiorable para llamar la atencion a los trabajadores distraidos.
     */
    @Override
    public void reprimand() 
    {
        System.out.println("\nEl jefe de proyecto esta regañando a los distraidos.");
    }
}