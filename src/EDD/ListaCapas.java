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
public class ListaCapas {
    private NodoCapa first;
    private NodoCapa last;
    int size;

    public ListaCapas() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void insertar(NodoCapa n){
        if(vacia()) first = last = n;
        else{
            last.setR(n);
            last = n;
        }
        size++;
    }
    
    public NodoCapa getNodo(int id){
        if(!vacia()){
            NodoCapa aux = first;
            while(aux!=null){
                if(aux.getCapa().getId() == id) return aux;
                aux = aux.getR();
            }
        }
        return null;
    }
    
    public boolean vacia(){return first == null;}
    

    /**
     * @return the first
     */
    public NodoCapa getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoCapa first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoCapa getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoCapa last) {
        this.last = last;
    }
    
    
}
