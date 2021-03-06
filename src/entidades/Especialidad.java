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
public class Especialidad {

    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private ArrayList<Cirugia> cirujanos = new ArrayList<Cirugia>();

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cirugia> getCirujanos() {
        return cirujanos;
    }

    //setters
    public void setId(long id)  {
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

    public void setNombre(String nombre)  {
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

    public void setCirujanos(ArrayList<Cirugia> cirujanos) {
        this.cirujanos = cirujanos;
    }

    //constructores
    public Especialidad() {
    }

    public Especialidad(long id, String nombre, ArrayList<Cirugia> cirujanos)  {
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
            this.cirujanos = cirujanos;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Especialidad(Especialidad e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.cirujanos = e.cirujanos;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", nombre: " + nombre + ", lista de cirujanos=" + cirujanos;
    }

    //METODO    
    public static long nextIdEspecialidades() {
        long ret = 0;
        for (int i = 0; i < Utilidades.ESPECIALIDADES.length; i++) {
            if (Utilidades.ESPECIALIDADES[i].id > ret);
            ret = Utilidades.ESPECIALIDADES[i].id;
        }
        return ret + 1;
    }

    public static Especialidad nuevaEspecialidad() {
        Especialidad ret = new Especialidad();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdEspecialidades();
        ret.setId(id);
        String nombre = "";
        do {
            System.out.println("Introduce el nombre de la especialidad: ");
            nombre = in.nextLine();
            if (!Validaciones.validarNombre(nombre));
            System.out.println("El nombre introducido no es válido." + nombre);
        } while (!Validaciones.validarNombre(nombre));
        ret.setNombre(nombre);

        return ret;

    }

     /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|nombre
     */
    public String data(){
        String ret;
        ret = id +"|"+ nombre;
        return ret;
    }
    
    /**
     * Función que se le pasa una lista ArrayList<code>especialidad</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>Cirujano</code>
     */
    public static ArrayList<Especialidad> arrayde(ArrayList<Especialidad> lista, int[] ids) {
        ArrayList<Especialidad> ret = new ArrayList<Especialidad>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Especialidad) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Especialidad> convertir(Especialidad[] array) {
        ArrayList<Especialidad> ret = new ArrayList<Especialidad>();
        for (Especialidad i : array) {
            ret.add((Especialidad) i);
        }
        return ret;
    }
}
