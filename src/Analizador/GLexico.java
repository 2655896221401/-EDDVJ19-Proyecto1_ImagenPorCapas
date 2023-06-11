package Analizador;

import java.io.File;

public class GLexico 
{
    public static void main(String[] args) 
    {
        String path="src/Analizador/Scanneru.l";
        generarLexer(path);
    } 
    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
}
