/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import alumno.Alumno;


/**
 *
 * @author Josué Vásquez
 */
public class Metodos
{
    Vector vPrincipal = new Vector();
    
    //PROCEDIMIENTO PARA GUARDAR DATOS EN 1 VECTOR
        public void guardar(Alumno unaPersona)
    {
        vPrincipal.addElement(unaPersona);
    }
    
    //PROCEDIMIENTO PARA GUARDAR EN UN ARCHIVO TXT
    
    public void guardarArchivo(Alumno personas)
    {    
        try
        {
            FileWriter fw = new FileWriter("Persona.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(personas.getNombre());
            pw.print("|" + personas.getApellido());
            pw.println("|" + personas.getEdad());
            pw.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    //MOSTRAR DATOS
    public DefaultTableModel listaPersonas()
    {
        Vector cabeceras = new Vector();
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Apellido");
        cabeceras.addElement("Edad");
        //CREAMOS UN VECTOR QUE CONTENGA NOMBRE APELLIDO Y EDAD
        //CREAMOS UN MODELO DE TABLA PARA AGREGAR EL VECTOR, EN LA UBICACION 0
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras,0);
        try
        {
            FileReader fr = new FileReader ("Persona.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d=br.readLine())!=null)
            {
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens())
                {
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                
        return mdlTabla;
        
    }
}
