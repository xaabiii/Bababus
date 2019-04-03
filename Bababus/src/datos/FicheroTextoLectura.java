/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author gloria
 */
public class FicheroTextoLectura extends Fichero
{
    private FileReader fr;
    private BufferedReader br;
    
    public FicheroTextoLectura()
    {
        super();
    }
    
    public FicheroTextoLectura(String nomFich)
    {
        super(nomFich);
        abrirFichero();
    }
    
    private void abrirFichero()
    {
        try {
            fr = new FileReader(getFichero());
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroTextoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cerrarFichero()
    {
        if(br != null)
            try {
                br.close();
        } catch (IOException ex) {
            Logger.getLogger(FicheroTextoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(fr != null)
            try {
                fr.close();
        } catch (IOException ex) {
            Logger.getLogger(FicheroTextoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leerLinea()
    {
        String linea = null;
        try {
            linea = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FicheroTextoLectura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;
    }
    

    public List<String> volcarFicheroArray()  //Leo el código ASCII caracter a caracter y lo transformoen byte
    {
        List<String> lista = new ArrayList<>();
        String linea = leerLinea();
        while(linea != null)
        {
            lista.add(linea);
            linea = leerLinea();
        }
        return lista;
    }
}
