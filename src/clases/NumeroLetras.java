package clases;

public class NumeroLetras {
	String[] nUnidades = {"UN", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE", "VEINTIUN", "VENTIDOS", "VEINTITRES", "VEINTICUATRO", "VEINTICINCO", "VEINTISEIS", "VEINTISIETE", "VEINTIOCHO", "VEINTINUEVE"};
    String[] nDecenas = {"DIEZ", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};
    String[] nCentenas = {"CIENTO", "DOCIENTOS", "TRECIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS","SETECIENTOS","OCHOCIENTOS", "NOVECIENTOS"};
    private char[] nValor;
    String valorLetras="",rta="";
    int bloqueTres=0;
    
    public NumeroLetras() {
    }
    
    public String convertir(int valor){ 
      
       int nBloque=0;
       String mostrar="";
       char []arregloValor=Integer.toString(valor).toCharArray();
       int[]arregloValores=new int[arregloValor.length];
       for(int i=0;i<arregloValores.length;i++)            
           arregloValores[arregloValor.length-i-1]=Character.getNumericValue(arregloValor[i]);
       int recorrer=0;
           while(arregloValor.length-recorrer!=0){
                int bloqueCero=0;
               int primerDigito=0;
               int segundoDigito=0;
               int tercerDigito=0;
               
               for(int i=0;i<3;i++ ){
                   
                   if(arregloValores[recorrer]!=0){
                   switch (i){
                       case 0:
                           valorLetras=" "+nUnidades[arregloValores[recorrer]-1];
                           primerDigito=arregloValores[recorrer];
                           break;
                       case 1:
                           if(arregloValores[recorrer]<=2){
                           valorLetras=" "+nUnidades[arregloValores[recorrer]*10+primerDigito-1];
                           }else{
                               valorLetras=" "+nDecenas[arregloValores[recorrer]-1]+(primerDigito!=0?" Y":"")+valorLetras;
                           }
                           segundoDigito=arregloValores[recorrer];
                           break;
                       case 2:
                          valorLetras=((primerDigito==0 && segundoDigito==0 && arregloValores[recorrer]==1)?" CIEN":nCentenas[arregloValores[recorrer]-1])+valorLetras; 
                           tercerDigito=arregloValores[recorrer];
                           break;
                   }}
                   else{
                      bloqueCero++; 
                   }
                   if((++recorrer)>arregloValores.length-1)
                   break; 
               }
               switch(nBloque){
                   case 0:
                       mostrar=valorLetras;
                       break;
                   case 1:
                       mostrar=valorLetras+(bloqueCero==3?"":" MIL ")+mostrar;
                       break;
                   case 2:
                       mostrar=valorLetras+((primerDigito==1 && segundoDigito==0 && tercerDigito==0)?" MILLON ":" MILLONES ")+(mostrar.trim().compareTo("")==0?" DE ":"")+mostrar;
                       
               }
               nBloque++;
           }
           //return mostrar+(valor>1?" SOLES":" SOL");
           return mostrar+(valor>1? "":"");
   }
}
