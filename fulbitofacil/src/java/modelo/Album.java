/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cdiaz
 */
public class Album extends Bean{
    
    private Integer id;
    private String nombre;
    private String comentario;
    private String rutaFotos;
    private EventoDeportivo eventoDeportivo;

    public Album() {
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
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the rutaFotos
     */
    public String getRutaFotos() {
        return rutaFotos;
    }

    /**
     * @param rutaFotos the rutaFotos to set
     */
    public void setRutaFotos(String rutaFotos) {
        this.rutaFotos = rutaFotos;
    }

    /**
     * @return the eventoDeportivo
     */
    public EventoDeportivo getEventoDeportivo() {
        return eventoDeportivo;
    }

    /**
     * @param eventoDeportivo the eventoDeportivo to set
     */
    public void setEventoDeportivo(EventoDeportivo eventoDeportivo) {
        this.eventoDeportivo = eventoDeportivo;
    }

    private int idEventoDeportivo;

    /**
     * @return the idEventoDeportivo
     */
    public int getIdEventoDeportivo() {
        return idEventoDeportivo;
    }

    /**
     * @param idEventoDeportivo the idEventoDeportivo to set
     */
    public void setIdEventoDeportivo(int idEventoDeportivo) {
        this.idEventoDeportivo = idEventoDeportivo;
    }
}
