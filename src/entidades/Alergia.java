/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Alergia {

    //Atributos
    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private ArrayList<Historial> historiales = new ArrayList<Historial>();
    private Medicamento medicamento;
    private long idMed;

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Historial> getHistoriales() {
        return historiales;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    //setters
    public void setId(long id) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long getIdMed() {
        return idMed;
    }

    public void setIdMed(long idMed) {
      try {
            if (Validaciones.validarId(idMed)) {
                this.idMed = idMed;
            } else {
                throw new Exception("Id Inválido: " + idMed);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    public void setNombre(String nombre) {
        try {
            if (Validaciones.validarNombre(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setHistoriales(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    //constructores
    public Alergia() {
    }

    public Alergia(long id, String nombre, ArrayList<Historial> historiales, Medicamento medicamento, long idMed) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            if (Validaciones.validarNombre(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }
            
            if (Validaciones.validarId(idMed)) {
                this.idMed = idMed;
            } else {
                throw new Exception("Id Inválido: " + idMed);
            }
            this.historiales = historiales;
            this.medicamento = medicamento;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
 public Alergia(long id, String nombre, ArrayList<Historial> historiales, Medicamento medicamento) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            if (Validaciones.validarNombre(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }          
                        
            this.historiales = historiales;
            this.medicamento = medicamento;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public Alergia(Alergia a) {
        this.id = a.id;
        this.nombre = a.nombre;
        this.historiales = a.historiales;
    }

    @Override
    public String toString() {
        return "Id alergia: " + id + ", nombre: " + nombre + ", historiales: " + historiales;
    }

    //MÉTODOS
    /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|nombre|idMed
     */
    public String data(){
        String ret;
        ret = id + "|" + nombre + "|" + idMed;
        return ret;
    }
            
    
    
    
    /**
     * Función que se le pasa una lista ArrayList<code>Alergia</code> y un array
     * de identificadores, y devuelve una sublista con los Cirujanos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de alergias en las que buscar
     * @param ids array de ids de Alergias
     * @return ArrayList<code>Alergia</code>
     */
    
      public static Alergia nuevoAlergia(){
        Alergia ret = new Alergia();
        Scanner in = new Scanner(System.in, "ISO-8859-1");      
        ret.setId(nextIdAlergia());    
        String nombre = null;
       do{
        System.out.println("Introduce el nombre del medicamento: ");
        nombre = in.nextLine();
        if(!Validaciones.validarNombMedicamento(nombre)){
            System.out.println("Nombre inválido: ");}        
       } while(!Validaciones.validarNombMedicamento(nombre));    
         ret.setNombre(nombre);
                  
        return ret;
    }
      
      
     
    
    public static ArrayList<Alergia> arrayde(ArrayList<Alergia> lista, int[] ids) {
        ArrayList<Alergia> ret = new ArrayList<Alergia>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Alergia) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Alergia> convertir(Alergia[] array) {
        ArrayList<Alergia> ret = new ArrayList<Alergia>();
        for (Alergia i : array) {
            ret.add((Alergia) i);
        }
        return ret;
    }

    //METODO QUE DEVUELVE AUTOMATICAMENTE EL SIGUIENTE ID
    public static long nextIdAlergia() {
        long ret = 0;
        for (int i = 0; i < Utilidades.ALERGIAS.length; i++) {
            if (Utilidades.ALERGIAS[i].id > ret);
            ret = Utilidades.ALERGIAS[i].id;
        }
        return ret + 1;
    }


};
