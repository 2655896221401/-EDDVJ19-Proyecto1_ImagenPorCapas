/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author jlrt
 */
public class NodoIMG {
    private String nombre;
    private NodoIMG l;
    private NodoIMG r;
    private ListaCapas capas;

    public NodoIMG(String nombre) {
        this.nombre = nombre;
        this.l = null;
        this.r = null;
        this.capas = new ListaCapas();
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
     * @return the l
     */
    public NodoIMG getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(NodoIMG l) {
        this.l = l;
    }

    /**
     * @return the r
     */
    public NodoIMG getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoIMG r) {
        this.r = r;
    }

    /**
     * @return the capas
     */
    public ListaCapas getCapas() {
        return capas;
    }

    /**
     * @param capas the capas to set
     */
    public void setCapas(ListaCapas capas) {
        this.capas = capas;
    }
    
            
    
}
