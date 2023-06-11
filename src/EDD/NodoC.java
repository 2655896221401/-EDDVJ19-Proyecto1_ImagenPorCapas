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
public class NodoC {
    private NodoC l;
    private NodoC r;
    private int x;
    private ListaVertical v;

    public NodoC(int x) {
        this.l = null;
        this.r = null;
        this.x = x;
        this.v = new ListaVertical();
    }

    /**
     * @return the l
     */
    public NodoC getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(NodoC l) {
        this.l = l;
    }

    /**
     * @return the r
     */
    public NodoC getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoC r) {
        this.r = r;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the v
     */
    public ListaVertical getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(ListaVertical v) {
        this.v = v;
    }
    
    
    
    
}
