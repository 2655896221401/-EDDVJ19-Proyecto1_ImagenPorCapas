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
%cupsym sym
%class Scannerc
%cup
%public
%unicode
%line
%column
%char
%ignorecase
// Area de definición de expresiones regulares. Tokens.
entero =[0-9]+
letra =[a-zA-ZÑñ]+
color = "#"({letra}|{entero})+
espacio = \t|\f|" "|\r|\n
%%

// Acciones
/* Espacios en blanco */
{espacio}
{/*Ignorar*/}
{entero} {return new Symbol(sym.entero,yycolumn,yyline,yytext());}
{color} {return new Symbol(sym.color,yycolumn,yyline,yytext());}
";" {return new Symbol(sym.pc,yycolumn,yyline,yytext());}
"{" {return new Symbol(sym.lla,yycolumn,yyline,yytext());}
"}" {return new Symbol(sym.llc,yycolumn,yyline,yytext());}
"," {return new Symbol(sym.c,yycolumn,yyline,yytext());}

/*Recolección de errores*/
.
{
System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+"Columna:"+(yycolumn+1));
}