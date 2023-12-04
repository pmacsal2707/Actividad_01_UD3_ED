/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author pablo
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream bufferEntrada = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreArchivo);
        bufferEntrada = new BufferedInputStream(flujoEntrada);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nLeidos = 0;
        while((nLeidos = flujoEntrada.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nLeidos;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( bufferEntrada != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    bufferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
