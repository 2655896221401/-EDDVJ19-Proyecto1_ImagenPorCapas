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
public class ListaHorizontal {
    private Ortogonal first;
    private Ortogonal last;
    int size;
    
    public ListaHorizontal() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void insertar(Ortogonal n){
      if(vacia()){
            setFirst(last = n);
        }else{
            if(n.getX() < getFirst().getX()){
                n.setR(getFirst());
                getFirst().setL(n);
                setFirst(n);
            }else if(n.getX()> getLast().getX()){
                n.setL(getLast());
                getLast().setR(n);
                setLast(n);
            }else{
                Ortogonal aux = getFirst();
                while(aux!=null){
                    if(n.getX() < aux.getX()){
                        n.setR(aux);
                        n.setL(aux.getL());
                        aux.getL().setR(n);
                        aux.setL(n);
                        break;
                    }
                    aux = aux.getR();
                }
            }
        }
        size++;
    }
    
    public boolean existe(int x){
        Ortogonal aux = getFirst();
        while(aux!=null){
            if(aux.getX()==x) return true;
            aux = aux.getR();
        }
        return false;
    }
    public Ortogonal getNodo(int x){
        Ortogonal aux = getFirst();
        while(aux!=null){
            if(aux.getX()==x) return aux;
            aux = aux.getR();
        }
        return null;
    }
    
    public boolean vacia() {return getFirst() == null;}

    /**
     * @return the first
     */
    public Ortogonal getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Ortogonal first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public Ortogonal getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Ortogonal last) {
        this.last = last;
    }
    
    
    
}

