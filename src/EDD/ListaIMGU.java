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
public class ListaIMGU {
    private NodoIMG first;
    private NodoIMG last;
    private int size;

    public ListaIMGU() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void insertar(NodoIMG n){
        if(vacia()) first = last = n;
        else{
            last.setR(n);
            n.setL(last);
            last = n;
        }
        size++;
    }
    
    
    public boolean vacia(){return first==null;}
    
    public NodoIMG getNodo(String id){
        NodoIMG aux = first;
        while(aux!=null){
            if(aux.getNombre().equals(id)) return aux;
            aux = aux.getR();
        }
        return null;
    }
    
    
    public boolean existe(String id){
        NodoIMG aux = first;
        while(aux!=null){
            if(aux.getNombre().equals(id)) return true;
            aux = aux.getR();
        }
        return false;
    }
    
    public void eliminar(String id){
        NodoIMG aux = first;
        if(existe(id)){
            if(id.equals(first.getNombre())){
                first = first.getR();
                if(first!=null){
                    first.setL(null);
                }
            }else if(id.equals(last.getNombre())){
                last = last.getL();
                if(last!=null){
                    last.setR(null);
                }
            }else{
                while(aux!=null){
                    if(aux.getNombre().equals(id)){
                        aux.getL().setR(aux.getR());
                        aux.getR().setL(aux.getL());
                        aux = null;
                        break;
                    }
                    aux = aux.getR();
                }
            }
            size--;
        }
    }

    /**
     * @return the first
     */
    public NodoIMG getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(NodoIMG first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public NodoIMG getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(NodoIMG last) {
        this.last = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
