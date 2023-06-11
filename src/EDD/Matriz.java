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
public class Matriz {
    private int id;
    private Cabecera c;
    private Lateral l;

    public Matriz(int id) {
        this.c = new Cabecera();
        this.l = new Lateral();
        this.id = id;
    }
    
    public void insertar(int x, int y, String color){
        Ortogonal n = new Ortogonal(x, y, color);
        boolean actualizar = false;
        if(!c.existe(x) && !l.existe(y)){
            getC().insertar(new NodoC(x));
            getL().insertar(new NodoL(y));
        }else if(!c.existe(x) && getL().existe(y)){
            getC().insertar(new NodoC(x));
        }else if(getC().existe(x) && !l.existe(y)){
            getL().insertar(new NodoL(y));
        }else{
            //Caso "actualizar"
            if(getC().getNodo(x).getV().existe(y)){
                getC().getNodo(x).getV().getNodo(y).setColor(color);
                actualizar = true;
            }
        }
        
        if(!actualizar){
            getC().getNodo(x).getV().insertar(n);
            getL().getNodo(y).getH().insertar(n);
        }
    }
    
    public boolean existe(int x, int y){
        if(getC().existe(x)){
            return getC().getNodo(x).getV().existe(y);
        }
        return false;
    }
    
    public Ortogonal getNodo(int x, int y){
        if(getC().existe(x)){
            return getC().getNodo(x).getV().getNodo(y);
        }
        return null;
    }
    
    public String getStringGraphviz(){
        String cadena ="digraph{\nnode[shape=box];";
        cadena += "{\nrank=min;\n";
        cadena += "matriz;";
        NodoC caux = c.getFirst();
        while(caux!=null){
            cadena += "n"+caux.hashCode()+"[label=\""+caux.getX()+"\"];\n";
            caux = caux.getR();
        }
        cadena += "}";
        
        NodoL laux = l.getFirst();
        Ortogonal oaux;
        while(laux!=null){
            cadena += "{\nrank=same;\n";
            cadena += "n"+laux.hashCode()+"[label=\""+laux.getY()+"\"];\n";
            oaux = laux.getH().getFirst();
            while(oaux!=null){
                cadena += "n"+oaux.hashCode()+"[label=\""+oaux.getColor()+"\"];\n";
                oaux = oaux.getR();
            }
            cadena += "}";
            laux = laux.getD();
        }
        
        //CONEXIONES
        caux = c.getFirst();
        if(c.getFirst()!=null) cadena += "matriz->n"+caux.hashCode()+";\n";
        while(caux!=null){
            if(caux.getR()!=null){
                cadena += "n"+caux.hashCode()+"->n"+caux.getR().hashCode()+";\n";
                cadena += "n"+caux.getR().hashCode()+"->n"+caux.hashCode()+";\n";
            }
            /*if(caux.getV().getFirst()!=null){
                cadena += "n"+caux.hashCode()+"->n"+caux.getV().getFirst().hashCode()+"[rankdir=UD];\n";
                cadena += "n"+caux.getV().getFirst().hashCode()+"->n"+caux.getV().getFirst().hashCode()+";\n";
            }*/
            caux = caux.getR();
        }
        
        
        laux = l.getFirst();
        if(l.getFirst()!=null) cadena += "matriz->n"+laux.hashCode()+"[rankdir=UD];\n";
        while(laux!=null){
            if(laux.getD()!=null){
                cadena += "n"+laux.hashCode()+"->n"+laux.getD().hashCode()+"[rankdir=UD];\n";
                cadena += "n"+laux.getD().hashCode()+"->n"+laux.hashCode()+";\n";
            }
            
            laux = laux.getD();
        }
        
        
        
        
        laux = l.getFirst();
        if(l.getFirst()!=null) cadena += "matriz->n"+laux.hashCode()+"[rankdir=UD];\n";
        while(laux!=null){
            oaux = laux.getH().getFirst();
            if(oaux!=null) {
                cadena += "n"+laux.hashCode()+"->n"+oaux.hashCode()+";\n";
                cadena += "n"+oaux.hashCode()+"->n"+laux.hashCode()+";\n";
            }
            while(oaux!=null){
                if(oaux.getR()!=null){
                    cadena += "n"+oaux.hashCode()+"->n"+oaux.getR().hashCode()+";\n";
                    cadena += "n"+oaux.getR().hashCode()+"->n"+oaux.hashCode()+";\n";
                }
                if(oaux.getD()!=null){
                    cadena += "n"+oaux.hashCode()+"->n"+oaux.getD().hashCode()+"[rankdir=UD];\n";
                    cadena += "n"+oaux.getD().hashCode()+"->n"+oaux.hashCode()+";\n";
                }
                oaux = oaux.getR();
            }
            
            laux = laux.getD();
        }
        
        
        caux = c.getFirst();
        //if(c.getFirst()!=null) cadena += "matriz->n"+caux.hashCode()+";\n";
        while(caux!=null){
            /*if(caux.getR()!=null){
                cadena += "n"+caux.hashCode()+"->n"+caux.getR().hashCode()+";\n";
                cadena += "n"+caux.getR().hashCode()+"->n"+caux.hashCode()+";\n";
            }*/
            if(caux.getV().getFirst()!=null){
                cadena += "n"+caux.hashCode()+"->n"+caux.getV().getFirst().hashCode()+"[rankdir=UD];\n";
                cadena += "n"+caux.getV().getFirst().hashCode()+"->n"+caux.getV().getFirst().hashCode()+";\n";
            }
            caux = caux.getR();
        }
        
        
        
        
        cadena += "}";
        
        
        
        
        
        
        
        
        return cadena;
        
        
    }
    
    public String getStringPrint(){
        String cadena = "digraph dibujo{\nnode [shape=plaintext]\na [label=<<TABLE BORDER=\"1\" CELLBORDER=\"0\" CELLSPACING=\"0\">\n";
        int lx, ly, i, j;
        if(!c.vacia() && !l.vacia()){
            lx = c.getLast().getX();
            ly = l.getLast().getY();
        }else{
            lx = c.size;
            ly = l.size;
        }
        Ortogonal aux;
        for(i=0; i<ly;i++){
            cadena += "<TR>";
            for(j=0;j<lx;j++){
                cadena += "<TD ";
                aux = getNodo(j, i);
                if(aux==null){
                    cadena += "BGCOLOR=\"#FFFFFF\"";
                }else{
                    cadena += "BGCOLOR=\""+aux.getColor()+"\"";
                }
                cadena += "></TD>";
            }
            cadena += "</TR>\n";
        }
        cadena += "</TABLE>>];\n}";  
        return cadena;
    }
    
    public void montar(Matriz m){        
        Ortogonal oaux;
        NodoL laux;
        laux = m.getL().getFirst();
        while(laux!=null){
            oaux = laux.getH().getFirst();
            while(oaux!=null){
                if(existe(oaux.getX(), oaux.getY())){
                    getNodo(oaux.getX(), oaux.getY()).setColor(oaux.getColor());
                }else{
                    insertar(oaux.getX(), oaux.getY(), oaux.getColor());
                }
                oaux = oaux.getR();
            }
            laux = laux.getD();
        }
    }
    
    public void rellenar(){
        int lx, ly, i, j;
        if(!c.vacia() && !l.vacia()){
            lx = c.getLast().getX();
            ly = l.getLast().getY();
        }else{
            lx = c.size;
            ly = l.size;
        }
        
        for(i=0;i<lx; i++){
            for(j=0;j<ly;j++){
                if(!existe(i, j)) insertar(i, j, "#FFFFFF");
            }
        }
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the c
     */
    public Cabecera getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Cabecera c) {
        this.c = c;
    }

    /**
     * @return the l
     */
    public Lateral getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(Lateral l) {
        this.l = l;
    }
}
