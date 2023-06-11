/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author jlrt
 */
class Logical {

    boolean v;

    public Logical(boolean f) {
        v = f;
    }

    public void setLogical(boolean f) {
        v = f;
    }

    public boolean booleanValue() {
        return v;
    }
}

public class AVLUsuarios {

    private NodoUsuario raiz;
    private String cadena;

    public AVLUsuarios() {
        this.raiz = null;
        cadena = "";
    }

    //Libro: Estructura de datos en java 1ED
    //Autor: Luis Joyanes Aguilar
    //Autor: Ignacio Zahonero Martínez
    public void insertar(NodoUsuario n) throws Exception {
        if (raiz == null) {
            raiz = n;
        } else {
            Logical h = new Logical(false);
            raiz = insertarAvl(raiz, n, h);
        }
    }

    private NodoUsuario insertarAvl(NodoUsuario raiz, NodoUsuario n, Logical hc) throws Exception {
        NodoUsuario n1;
        if (raiz == null) {
            raiz = n;
            hc.setLogical(true);
        } else if (n.getNombre().compareTo(raiz.getNombre()) < 0) {
            NodoUsuario iz;
            iz = insertarAvl(raiz.getIzq(), n, hc);
            raiz.setIzq(iz);
            if (hc.booleanValue()) {
                switch (raiz.fe) {
                    case 1:
                        raiz.fe = 0;
                        hc.setLogical(false);
                        break;
                    case 0:
                        raiz.fe = -1;
                        break;
                    case -1:
                        n1 = raiz.getIzq();
                        if (n1.fe == -1) {
                            raiz = rotacionII(raiz, n1);
                        } else {
                            raiz = rotacionID(raiz, n1);
                        }
                        hc.setLogical(false);
                }
            }
        } else if (n.getNombre().compareTo(raiz.getNombre()) > 0) {
            NodoUsuario dr;
            dr = insertarAvl(raiz.getDer(), n, hc);
            raiz.setDer(dr);
            if (hc.booleanValue()) {
                switch (raiz.fe) {
                    case 1:
                        n1 = raiz.getDer();
                        if (n1.fe == +1) {
                            raiz = rotacionDD(raiz, n1);
                        } else {
                            raiz = rotacionDI(raiz, n1);
                        }
                        hc.setLogical(false);
                        break;
                    case 0:
                        raiz.fe = +1;
                        break;
                    case -1:
                        raiz.fe = 0;
                        hc.setLogical(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar usuario", "Usuario existente", JOptionPane.WARNING_MESSAGE);
        }
        return raiz;
    }

    private NodoUsuario rotacionII(NodoUsuario n, NodoUsuario n1) {
        n.setIzq(n1.getDer());
        n1.setDer(n);
        if (n1.fe == -1) {
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }

    private NodoUsuario rotacionDD(NodoUsuario n, NodoUsuario n1) {
        n.setDer(n1.getIzq());
        n1.setIzq(n);
        if (n1.fe == +1) {
            n.fe = 0;
            n1.fe = 0;
        } else {
            n.fe = +1;
            n1.fe = -1;
        }
        return n1;
    }

    private NodoUsuario rotacionDI(NodoUsuario n, NodoUsuario n1) {
        NodoUsuario n2;
        n2 = n1.getIzq();
        n.setDer(n2.getIzq());
        n2.setIzq(n);
        n1.setIzq(n2.getDer());
        n2.setDer(n1);
        if (n2.fe == +1) {
            n.fe = -1;
        } else {
            n.fe = 0;
        }
        if (n2.fe == -1) {
            n1.fe = +1;
        } else {
            n1.fe = 0;
        }
        n2.fe = 0;
        return n2;
    }

    private NodoUsuario rotacionID(NodoUsuario n, NodoUsuario n1) {
        NodoUsuario n2;
        n2 = n1.getDer();
        n.setIzq(n2.getDer());
        n2.setDer(n);
        n1.setDer(n2.getIzq());
        n2.setIzq(n1);
        if (n2.fe == +1) {
            n1.fe = -1;
        } else {
            n1.fe = 0;
        }
        if (n2.fe == -1) {
            n.fe = 1;
        } else {
            n.fe = 0;
        }
        n2.fe = 0;
        return n2;
    }

    public void eliminar(String id) throws Exception {
        NodoUsuario dato;
        dato = getNodo(id);
        Logical flag = new Logical(false);
        raiz = borrarAvl(raiz, dato, flag);
    }
    
    private NodoUsuario borrarAvl(NodoUsuario r, NodoUsuario clave,
            Logical cambiaAltura) throws Exception {
        if (r == null) {
            throw new Exception(" Nodo no encontrado ");
        } else if (comparar(clave.getNombre(), r.getNombre()) < 0) {
            NodoUsuario iz;
            iz = borrarAvl(r.getIzq(), clave, cambiaAltura);
            r.setIzq(iz);
            if (cambiaAltura.booleanValue()) {
                r = equilibrar1(r, cambiaAltura);
            }
        } else if (comparar(clave.getNombre(), r.getNombre()) > 0) {
            NodoUsuario dr;
            dr = borrarAvl(r.getDer(), clave, cambiaAltura);
            r.setDer(dr);
            if (cambiaAltura.booleanValue()) {
                r = equilibrar2(r, cambiaAltura);
            }
        } else {
            NodoUsuario q;

            q = r;
            if (q.getIzq() == null) {
                r = q.getDer();
                cambiaAltura.setLogical(true);
            } else if (q.getDer() == null) {
                r = q.getIzq();
                cambiaAltura.setLogical(true);
            } else {
                NodoUsuario iz;
                iz = reemplazar(r, r.getIzq(), cambiaAltura);
                r.setIzq(iz);
                if (cambiaAltura.booleanValue()) {
                    r = equilibrar1(r, cambiaAltura);
                }
            }
            q = null;
        }
        return r;
    }

    private NodoUsuario reemplazar(NodoUsuario n, NodoUsuario act, Logical cambiaAltura) {
        if (act.getDer() != null) {
            NodoUsuario d;
            d = reemplazar(n, act.getDer(), cambiaAltura);
            act.setDer(d);
            if (cambiaAltura.booleanValue()) {
                act = equilibrar2(act, cambiaAltura);
            }
        } else {
            n.setNombre(act.getNombre());
            n = act;
            act = act.getIzq();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }

    private NodoUsuario equilibrar1(NodoUsuario n, Logical cambiaAltura) {
        NodoUsuario n1;
        switch (n.fe) {
            case -1:
                n.fe = 0;
                break;
            case 0:
                n.fe = 1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n1 = n.getDer();
                if (n1.fe >= 0) {
                    if (n1.fe == 0) {
                        cambiaAltura.setLogical(false);
                    }
                    n = rotacionDD(n, n1);
                } else {
                    n = rotacionDI(n, n1);
                }
                break;
        }
        return n;
    }

    private NodoUsuario equilibrar2(NodoUsuario n, Logical cambiaAltura) {

        NodoUsuario n1;
        switch (n.fe) {
            case -1:
                n1 = n.getIzq();
                if (n1.fe <= 0) {
                    if (n1.fe == 0) {
                        cambiaAltura.setLogical(false);
                    }
                    n = rotacionII(n, n1);
                } else {
                    n = rotacionID(n, n1);
                }
                break;
            case 0:
                n.fe = -1;
                cambiaAltura.setLogical(false);
                break;
            case +1:
                n.fe = 0;
                break;
        }
        return n;
    }
    
    public void eliminarImagenes(String id){
        eliminarimagenes(id, raiz);
    }
    
    private void eliminarimagenes(String id, NodoUsuario r){
        if(r!=null){
            eliminarimagenes(id, r.getIzq());
            r.getImgs().eliminar(id);
            eliminarimagenes(id, r.getDer());
        }
    }

    public NodoUsuario getNodo(String id) {
        NodoUsuario aux;
        aux = getNodo(id, raiz);
        return aux;
    }

    private NodoUsuario getNodo(String i, NodoUsuario r) {
        NodoUsuario aux = null;
        if (!esNulo(r)) {
            if (comparar(i, r.getNombre()) < 0) {
                aux = getNodo(i, r.getIzq());
            } else if (comparar(i, r.getNombre()) > 0) {
                aux = getNodo(i, r.getDer());
            } else {
                aux = r;
            }
        }
        return aux;
    }

    public boolean existe(String id) {
        return existe(id, raiz);
    }

    private boolean existe(String i, NodoUsuario r) {
        boolean aux = false;
        if (!esNulo(r)) {
            if (comparar(i, r.getNombre()) < 0) {
                aux = existe(i, r.getIzq());
            } else if (comparar(i, r.getNombre()) > 0) {
                aux = existe(i, r.getDer());
            } else {
                return true;
            }
        }
        return aux;
    }

    public String getStringGraphvizEDD() {
        this.cadena = "";
        String cadena2 = "digraph{\n node[shape = box];\n label=\"Arbol de capas\";\n";
        generateNodesEDD(raiz);
        generateGraphvizEDD(raiz);
        cadena2 += this.cadena;
        cadena2 += "}";
        return cadena2;
    }

    private void generateNodesEDD(NodoUsuario raiz) {
        if (raiz != null) {
            cadena += "n" + raiz.hashCode() + "[label=\"" + raiz.getNombre() + "\"];\n";
            generateNodesEDD(raiz.getIzq());
            generateNodesEDD(raiz.getDer());

        }
    }

    private void generateGraphvizEDD(NodoUsuario raiz) {
        if (raiz != null) {
            if (raiz.getIzq() != null) {
                cadena += "n" + raiz.hashCode() + "->n" + raiz.getIzq().hashCode() + ";\n";
                generateGraphvizEDD(raiz.getIzq());
            }

            if (raiz.getDer() != null) {
                cadena += "n" + raiz.hashCode() + "->n" + raiz.getDer().hashCode() + ";\n";
                generateGraphvizEDD(raiz.getDer());
            }
        }
    }

    private boolean esNulo(NodoUsuario r) {
        return r == null;
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoUsuario raiz) {
        if (raiz == null) {
            return;
        }
        inOrden(raiz.getIzq());
        System.out.println(raiz.getNombre());
        inOrden(raiz.getDer());
    }

    private int comparar(String a, String b) {
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

        if (bola && bolb) {
            if (aa < bb) {
                return -1;
            } else if (aa > bb) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return a.compareTo(b);
        }
    }

    /**
     * @return the raiz
     */
    public NodoUsuario getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoUsuario raiz) {
        this.raiz = raiz;
    }

}
