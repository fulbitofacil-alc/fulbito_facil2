/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cdiaz
 */
public class AlquilerCanchaPromocion extends Bean{
    
    private AlquilerCancha alquilerCancha;
    private Promocion promocion;
    private double precio;
    private double precioPromocion;
    private double precioTotal;

    public AlquilerCanchaPromocion() {
    }
    
    /**
     * @return the alquilerCancha
     */
    public AlquilerCancha getAlquilerCancha() {
        return alquilerCancha;
    }

    /**
     * @param alquilerCancha the alquilerCancha to set
     */
    public void setAlquilerCancha(AlquilerCancha alquilerCancha) {
        this.alquilerCancha = alquilerCancha;
    }

    /**
     * @return the promocion
     */
    public Promocion getPromocion() {
        return promocion;
    }

    /**
     * @param promocion the promocion to set
     */
    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the precioPromocion
     */
    public double getPrecioPromocion() {
        return precioPromocion;
    }

    /**
     * @param precioPromocion the precioPromocion to set
     */
    public void setPrecioPromocion(double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
