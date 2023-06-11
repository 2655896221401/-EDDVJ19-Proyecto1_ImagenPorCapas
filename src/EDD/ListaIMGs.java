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
public class ListaIMGs {
    private NodoIMG first;
    private NodoIMG last;
    public int size;

    public ListaIMGs() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    
    public void insertar(NodoIMG n){
        if(vacia()){
            first = last = n;
            first.setL(last);
            first.setR(first);
        }else{
            if(comparar(n.getNombre(), first.getNombre())<0 || comparar(n.getNombre(), first.getNombre()) == 0){
                n.setR(first);
                n.setL(first.getL());
                first.setL(n);
                last.setR(n);
                first = n;
            }else if(comparar(n.getNombre(), last.getNombre())>0 || comparar(n.getNombre(), last.getNombre()) == 0){
                n.setL(last);
                n.setR(last.getR());
                last.setR(n);
                first.setL(n);
                last = n;
            }else{
                NodoIMG aux = first;
                do{
                    if(comparar(n.getNombre(), aux.getNombre())<0 || comparar(n.getNombre(), aux.getNombre()) == 0){
                        n.setR(aux);
                        n.setL(aux.getL());
                        aux.getL().setR(n);
                        aux.setL(n);
                        break;
                    }
                    aux = aux.getR();
                }while(aux!=first);
            }
        }
        size++;
    }
    
    public void eliminar(String id){
        if(existe(id)){
            if(id.equals(first.getNombre())){
                if(first.getR()==first){
                    first = null;
                }else{
                    NodoIMG aux = first;
                    first = first.getR();
                    first.setL(last);
                    last.setR(first);
                    aux = null;
                }
            }else if(id.equals(last.getNombre())){
                if(last.getL()==last){
                    last = null;
                }else{
                    NodoIMG aux = last;
                    last = last.getL();
                    first.setL(last);
                    last.setR(first);
                    aux = null;
                }
            }else{
                NodoIMG aux = first;
                do {
                    if(aux.getNombre().equals(id)){
                        aux.getL().setR(aux.getR());
                        aux.getR().setL(aux.getL());
                        aux = null;
                        break;
                    }
                    aux = aux.getR();
                } while (aux!=first);
            }
            size--;
        }
    }
    
    private int comparar(String a, String b){
        boolean bola, bolb;
        int aa, bb;
        aa = bb = 0;
        try {
            aa = Integer.parseInt(a);
            bola = true;
        } catch (Exception e) {
            bola = false;
        }
        
        try {
            bb = Integer.parseInt(b);
            bolb = true;
        } catch (Exception e) {
            bolb = false;
        }
        
        if(bola && bolb){
            if(aa<bb) return -1;
            else if (aa>bb) return 1;
            else return 0;
        }else{
            return a.compareTo(b);
        }
    }
    
    public NodoIMG getNodo(String nombre){
        if(!vacia()){
            NodoIMG aux = first;
            do{
                if(nombre.equals(aux.getNombre())) return aux;
                aux = aux.getR();
            }while(aux!=first);
        }
        return null;
    }
    
    public boolean vacia(){
        return first == null;
    }
    
    public String getStringGraphvizEDD(){
        String cadena="digraph{\nnode[shape=box];\nlabel=\"Lista de Imagenes\";\n";
        NodoIMG aux = first;
        NodoCapa auxc;
        if(aux!=null){
            do{
                cadena += "n"+aux.hashCode()+"[label=\""+"imagen: "+aux.getNombre()+"\"];\n";
                auxc = aux.getCapas().getFirst();
                while(auxc!=null){
                    cadena += "n"+auxc.hashCode()+"[label=\""+"capa: "+auxc.getCapa().getId()+"\", style=rounded];\n";
                    auxc = auxc.getR();
                }
                aux = aux.getR();
            }while(aux!=first);
        }
        
        aux = first;
        if(aux!=null){
            do{
                if(aux.getR()!=null){
                cadena += "n"+aux.hashCode()+"->n"+aux.getR().hashCode()+"[constraint=false];\n";
                cadena += "n"+aux.getR().hashCode()+"->n"+aux.hashCode()+"[constraint=false];\n";
                }
                auxc = aux.getCapas().getFirst();
                if(auxc!=null) cadena += "n"+aux.hashCode()+"->n"+auxc.hashCode()+";\n";
                while(auxc!=null){
                    if(auxc.getR()!=null){
                        cadena += "n"+auxc.hashCode()+"->n"+auxc.getR().hashCode()+";\n";
                    }
                    auxc = auxc.getR();
                }
                aux = aux.getR();
            }while(aux!=first);
        }
        cadena += "}";
        return cadena;
    }
    
    public String generateEDDWithOutPane(String id){
        String cadena="subgraph cluster_lista{\nlabel=\"Imagen\";\n";
        NodoIMG aux = first;
        NodoCapa auxc;
        if(aux!=null){
            do{
                if(aux.getNombre().equals(id)){
                    cadena += "n"+aux.hashCode()+"[label=\""+"imagen: "+aux.getNombre()+"\"];\n";
                    auxc = aux.getCapas().getFirst();
                    while(auxc!=null){
                        cadena += "n"+auxc.hashCode()+"[label=\""+"capa: "+auxc.getCapa().getId()+"\", style=rounded, color=red];\n";
                        auxc = auxc.getR();
                    }
                }
                aux = aux.getR();
            }while(aux!=first);
        }
        
        aux = first;
        if(aux!=null){
            do{
                if(aux.getNombre().equals(id)){
                    auxc = aux.getCapas().getFirst();
                    if(auxc!=null) cadena += "n"+aux.hashCode()+"->n"+auxc.hashCode()+";\n";
                    while(auxc!=null){
                        if(auxc.getR()!=null){
                            cadena += "n"+auxc.hashCode()+"->n"+auxc.getR().hashCode()+";\n";
                        }
                        cadena += "n"+auxc.hashCode()+"->n"+auxc.getCapa().hashCode()+";\n";
                        auxc = auxc.getR();
                    }
                }
                aux = aux.getR();
            }while(aux!=first);
        }
        cadena += "}";
        return cadena;
    }
    
    public boolean existe(String id){
        if(!vacia()){
            NodoIMG aux = first;
            do{
                if(id.equals(aux.getNombre())) return true;
                aux = aux.getR();
            }while(aux!=first);
        }
        return false;
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
    
    
    
    
}
