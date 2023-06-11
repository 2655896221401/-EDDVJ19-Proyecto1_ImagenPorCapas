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
public class Ortogonal {
    private Ortogonal u;
    private Ortogonal d;
    private Ortogonal l;
    private Ortogonal r;
    private String color;
    private int x;
    private int y;

    public Ortogonal(int x, int y, String color) {
        this.u = null;
        this.d = null;
        this.l = null;
        this.r = null;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the u
     */
    public Ortogonal getU() {
        return u;
    }

    /**
     * @param u the u to set
     */
    public void setU(Ortogonal u) {
        this.u = u;
    }

    /**
     * @return the d
     */
    public Ortogonal getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(Ortogonal d) {
        this.d = d;
    }

    /**
     * @return the l
     */
    public Ortogonal getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(Ortogonal l) {
        this.l = l;
    }

    /**
     * @return the r
     */
    public Ortogonal getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Ortogonal r) {
        this.r = r;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
    
    
    
}
