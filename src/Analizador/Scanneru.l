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
%cupsym symu
%class Scanneru
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
identificador = {letra}({letra}|{entero})*
espacio = \t|\f|" "|\r|\n
%%

// Acciones
/* Espacios en blanco */
{espacio}
{/*Ignorar*/}
{entero} {return new Symbol(symu.entero,yycolumn,yyline,yytext());}
{identificador} {return new Symbol(symu.id,yycolumn,yyline,yytext());}
";" {return new Symbol(symu.pc,yycolumn,yyline,yytext());}
":" {return new Symbol(symu.dp,yycolumn,yyline,yytext());}
"," {return new Symbol(symu.c,yycolumn,yyline,yytext());}

/*Recolección de errores*/
.
{
System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+"Columna:"+(yycolumn+1));
}