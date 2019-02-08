
package agendaobjetosfinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;

/**
 *
 * @author MarekLegends
 */
public class Archivo {
    public static ArrayList<Contacto> leer() throws ClassNotFoundException{
      ArrayList<Contacto> vAgenda = new ArrayList();
      ArrayList<Contacto> arrayList2;
      
      File f = new File("agenda.dat");
      FileInputStream fi = null;
      ObjectInputStream oi = null;
        
        if (!f.exists()) {
          try {
              f.createNewFile();
          } catch (IOException ex) {
              System.out.println("Error al crear el archivo");
          }
        }
        
        if (f.exists()) {
             
          try {
              ObjectInputStream leyendoFichero;
              leyendoFichero = new ObjectInputStream( 
                      new FileInputStream(f) );
                 vAgenda =  ( ArrayList <Contacto> )  leyendoFichero.readObject();
            leyendoFichero.close();
          } catch (IOException ex) {
              System.out.println("Error al leer el archivo");
          }
         
        }
         
      return vAgenda;
    }
}
