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
public class NodoUsuario {
    private String nombre;
    private NodoUsuario izq;
    private NodoUsuario der;
    int fe;
    private ListaIMGU imgs;

    public NodoUsuario(String nombre) {
        this.nombre = nombre;
        this.izq = null;
        this.der = null;
        this.fe = 0;
        imgs = new ListaIMGU();
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
     * @return the izq
     */
    public NodoUsuario getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoUsuario izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoUsuario getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoUsuario der) {
        this.der = der;
    }

    /**
     * @return the imgs
     */
    public ListaIMGU getImgs() {
        return imgs;
    }

    /**
     * @param imgs the imgs to set
     */
    public void setImgs(ListaIMGU imgs) {
        this.imgs = imgs;
    }
    
    
}
