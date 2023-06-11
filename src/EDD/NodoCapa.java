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
public class NodoCapa {
    private NodoCapa r;
    private Matriz capa;

    public NodoCapa(Matriz capa) {
        this.r = null;
        this.capa = capa;
    }

    /**
     * @return the r
     */
    public NodoCapa getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoCapa r) {
        this.r = r;
    }

    /**
     * @return the capa
     */
    public Matriz getCapa() {
        return capa;
    }

    /**
     * @param capa the capa to set
     */
    public void setCapa(Matriz capa) {
        this.capa = capa;
    }
    
}
