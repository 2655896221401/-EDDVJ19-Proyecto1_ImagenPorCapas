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
public class NodoL {

    private NodoL u;
    private NodoL d;
    private int y;
    private ListaHorizontal h;
    
    public NodoL(int y) {
        this.u = null;
        this.d = null;
        this.y = y;
        this.h = new ListaHorizontal();
    }

    /**
     * @return the u
     */
    public NodoL getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(NodoL u) {
        this.u = u;
    }

    /**
     * @return the d
     */
    public NodoL getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(NodoL d) {
        this.d = d;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return the h
     */
    public ListaHorizontal getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(ListaHorizontal h) {
        this.h = h;
    }
    
}
