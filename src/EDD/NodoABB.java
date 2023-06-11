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
public class NodoABB {
    private Matriz m;
    private NodoABB izq;
    private NodoABB der;

    public NodoABB(Matriz m) {
        this.m = m;
        this.izq = null;
        this.der = null;
    }

    /**
     * @return the m
     */
    public Matriz getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Matriz m) {
        this.m = m;
    }

    /**
     * @return the izq
     */
    public NodoABB getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoABB izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoABB getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoABB der) {
        this.der = der;
    }
    
    
    
}
