package Analizador; // Paquete donde estará nuestro scanner
import java_cup.runtime.Symbol;

%%
%{
/*Area de declaración de codigo java.
*Funciones y variables necesarias
*
*/

%}
// Area de directivas
%cupsym symi
%class Scanneri
%cup
%public
%unicode
%line
%column
%char
%ignorecase
// Area de definición de expresiones regulares. Tokens.
entero =[0-9]+
letra = [a-zA-Z]+
identificador = {letra}({letra}|{entero})*
espacio = \t|\f|" "|\r|\n
%%

// Acciones
/* Espacios en blanco */
{espacio}
{/*Ignorar*/}
{entero} {return new Symbol(symi.entero,yycolumn,yyline,yytext());}
{identificador} {return new Symbol(symi.id,yycolumn,yyline,yytext());}
"{" {return new Symbol(symi.lla,yycolumn,yyline,yytext());}
"}" {return new Symbol(symi.llc,yycolumn,yyline,yytext());}
"," {return new Symbol(symi.c,yycolumn,yyline,yytext());}

/*Recolección de errores*/
.
{
System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+"Columna:"+(yycolumn+1));
}
