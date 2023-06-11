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
public class Lateral {
    private NodoL first, last;
    int size;

    public Lateral() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void insertar(NodoL n){
        if(vacia()){
            setFirst(last = n);
        }else{
            if(n.getY()<getFirst().getY()){
                n.setD(getFirst());
                getFirst().setU(n);
                setFirst(n);
            }else if(n.getY()>getLast().getY()){
                n.setU(getLast());
                getLast().setD(n);
                setLast(n);
            }else{
                NodoL aux = getFirst();
                while(aux!=null){
                    if(n.getY()<aux.getY()){
                        n.setD(aux);
                        n.setU(aux.getU());
                        aux.getU().setD(n);
                        aux.setU(n);
                        break;
                    }
                    aux = aux.getD();
                }
            }
        }
        size++;
    }
    
    public boolean existe(int y){
        if(!vacia()){
            NodoL aux = getFirst();
            while(aux!=null){
                if(aux.getY() == y) return true;
                aux  = aux.getD();
            }
        }
        return false;
    }
    
    public NodoL getNodo(int y){
        NodoL aux = getFirst();
        while(aux!=null){
            if(aux.getY() == y) return aux;
            aux = aux.getD();
        }
        return null;
    }
    
    public boolean vacia(){return getFirst() == null;}

    /**
     * @return the first
     */
    public NodoL getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoL first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoL getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoL last) {
        this.last = last;
    }
    
    
}
