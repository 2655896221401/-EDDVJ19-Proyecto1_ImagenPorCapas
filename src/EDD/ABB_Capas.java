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
public class ABB_Capas {
    private NodoABB raiz;
    private String cadena;

    public ABB_Capas() {
        this.raiz = null;
        this.cadena ="";
    }
    
    public void insertar(NodoABB n){
        if (esNulo(raiz)) raiz = n;
        else insertar_(n, this.raiz);
    }
    
    private void insertar_(NodoABB n, NodoABB r){
        if(esNulo(r)){
            this.setRaiz(r);
        }else{
            if(n.getM().getId()< r.getM().getId()){
                if(r.getIzq() == null) r.setIzq(n);
                else insertar_(n, r.getIzq());
            }else if(n.getM().getId()> r.getM().getId()){
                if(r.getDer() == null) r.setDer(n);
                else insertar_(n, r.getDer());
            }else{
                r.setM(n.getM());
            }
        }
    }
    
    public NodoABB getNodo(int i){
        NodoABB aux;
        aux = getNodo(i, raiz);
        return aux;
    }
    
    private NodoABB getNodo(int i, NodoABB r){
        NodoABB aux = null;
        if(i<r.getM().getId()) aux = getNodo(i, r.getIzq());
        else if(i>r.getM().getId()) aux = getNodo(i, r.getDer());
        else aux = r;
        return aux;
    }
    
    public boolean existe(int i){
        return existe(i, raiz);
    }
    
    private boolean existe(int i, NodoABB r){
        boolean aux = false;
        if(!esNulo(r)){
            if(i<r.getM().getId()) aux = existe(i, r.getIzq());
            else if(i>r.getM().getId()) aux = existe(i, r.getDer());
            else return true;
        }
        return aux;
    }
    
    public String inOrden(){
        cadena = "";
        inOrden_(raiz);
        return cadena;
    }
    
    private void inOrden_(NodoABB r){
        if(r!=null){
            inOrden_(r.getIzq());
            cadena += r.getM().getId()  + ",";
            inOrden_(r.getDer());
        }
        
    }
    
    public String preOrden(){
        cadena = "";
        preOrden(raiz);
        return cadena;
    } 
    
    private void preOrden(NodoABB r){
        if(r!=null){
            cadena += r.getM().getId()  + ",";
            preOrden(r.getIzq());
            preOrden(r.getDer());
        }
    }
    
    public String postOrden(){
        cadena = "";
        postOrden(raiz);
        return cadena;
    }
    
    private void postOrden(NodoABB r){
        if(r != null){
            postOrden(r.getIzq());
            postOrden(r.getDer());
            cadena += r.getM().getId()  + ",";
        }
    }
    
    private boolean esNulo(NodoABB r){
        return r == null;
    }

    /**
     * @return the raiz
     */
    public NodoABB getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }
    
    
    public String getStringGraphvizEDD(){
        this.cadena ="";
        String cadena2 ="digraph{\n node[shape = box];\n label=\"Arbol de capas\";\n";
        generateNodesEDD(raiz);
        generateGraphvizEDD(raiz);
        cadena2 += this.cadena;
        cadena2 += "}";
        return cadena2;
    }
    
    private void generateNodesEDD(NodoABB raiz){
        if(raiz!=null){
            cadena += "n"+raiz.hashCode()+"[label=\""+"capa: "+raiz.getM().getId()+"\"];\n";
            generateNodesEDD(raiz.getIzq());
            generateNodesEDD(raiz.getDer());
            
        }
    }
    
    private void generateGraphvizEDD(NodoABB raiz){
        if(raiz!=null){
            if(raiz.getIzq()!=null){
                cadena += "n"+raiz.hashCode()+"->n"+raiz.getIzq().hashCode()+";\n";
                generateGraphvizEDD(raiz.getIzq());
            }
            
            if(raiz.getDer()!=null){
                cadena += "n"+raiz.hashCode()+"->n"+raiz.getDer().hashCode()+";\n";
                generateGraphvizEDD(raiz.getDer());
            }
        }
    }
    
    public String generateEDDWithOutPane(){
        this.cadena ="";
        String cadena2 ="subgraph cluster_arbol{\n node[shape = box];\n label=\"Arbol de capas\";\n";
        generateNodesEDD1(raiz);
        generateGraphvizEDD1(raiz);
        cadena2 += this.cadena;
        cadena2 += "}";
        return cadena2;
    }
    
    private void generateNodesEDD1(NodoABB raiz){
        if(raiz!=null){
            cadena += "n"+raiz.getM().hashCode()+"[label=\""+"capa: "+raiz.getM().getId()+"\"];\n";
            generateNodesEDD1(raiz.getIzq());
            generateNodesEDD1(raiz.getDer());
            
        }
    }
    
    private void generateGraphvizEDD1(NodoABB raiz){
        if(raiz!=null){
            if(raiz.getIzq()!=null){
                cadena += "n"+raiz.getM().hashCode()+"->n"+raiz.getIzq().getM().hashCode()+";\n";
                generateGraphvizEDD1(raiz.getIzq());
            }
            
            if(raiz.getDer()!=null){
                cadena += "n"+raiz.getM().hashCode()+"->n"+raiz.getDer().getM().hashCode()+";\n";
                generateGraphvizEDD1(raiz.getDer());
            }
        }
    }
    
    
    
    
    
}
