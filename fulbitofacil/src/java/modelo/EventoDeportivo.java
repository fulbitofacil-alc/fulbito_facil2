/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author cdiaz
 */
public class EventoDeportivo extends Bean{
    
    private Integer id;
    private String nombre;
    private String premio;
    private Integer cantidadEquipos;
    private String fechaInscripcion;
    private Dueño dueño;

    public EventoDeportivo() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the premio
     */
    public String getPremio() {
        return premio;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(String premio) {
        this.premio = premio;
    }

    /**
     * @return the cantidadEquipos
     */
    public Integer getCantidadEquipos() {
        return cantidadEquipos;
    }

    /**
     * @param cantidadEquipos the cantidadEquipos to set
     */
    public void setCantidadEquipos(Integer cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    /**
     * @return the fechaInscripcion
     */
    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * @param fechaInscripcion the fechaInscripcion to set
     */
    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * @return the dueño
     */
    public Dueño getDueño() {
        return dueño;
    }

    /**
     * @param dueño the dueño to set
     */
    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    
}