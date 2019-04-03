/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;

/**
 *
 * @author gloria
 */
public class Fichero 
{
    private File f;
    
    public Fichero()
    {
        
    }
    
    public Fichero(String nomFich)
    {
        f = new File(nomFich);
    }
    
    public long getTamanio()
    {
        return f.length();
    }
    
    public String getNombre()
    {
        return f.getName();
    }
    
    public File getFichero()
    {
        return f;
    }
    
    public boolean existe()
    {
        return f.exists();
    }
}
