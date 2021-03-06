/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.Especialidad.nextIdEspecialidades;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Historial {

    private long historial; // >0
    private String descripcion; // Máximo 150 caracteres alfanuméricos
    private ArrayList<Alergia> alergias = new ArrayList<Alergia>();
    

    public long getHistoria() {
        return historial;
    }
    //

    public void setHistorial(long historial) {
        try {
            if (Validaciones.validarId(historial)) {
                this.historial = historial;
            } else {
                throw new Exception("Id Inválido: " + historial);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        try {
            if (Validaciones.validarTexto(descripcion)) {
                this.descripcion = descripcion;
            } else {
                throw new Exception("Id Inválido: " + historial);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }

    //CONSTRUCTORES
    public Historial() {
    }

    public Historial(long historia, String descripcion, ArrayList<Alergia> alergias) {
        this.historial = historia;
        this.descripcion = descripcion;
        this.alergias = alergias;
    }

    public Historial(Historial h) {
        this.alergias = h.alergias;
        this.descripcion = h.descripcion;
        this.historial = h.historial;
    }

    @Override
    public String toString() {
        return "Nº de historia: " + historial + ". Descripcion: " + descripcion + ", Listado de alergias: " + alergias;
    }

    //METODOS

 /**
     * Función que marca el orden de importación/exportación de los campos
     * @return historial(PK)|descripcion
     */
    public String data(){
        String ret;
        ret = historial +"|"+ descripcion;
        return ret;
    }
    
    public static long nextHistorial() {
        long ret = 0;
        for (int i = 0; i < Utilidades.HISTORIALES.length; i++) {
            if (Utilidades.HISTORIALES[i].historial > ret);
            ret = Utilidades.HISTORIALES[i].historial;
        }
        return ret + 1;
    }
    
    public static Historial nuevoHistorial() {
        Historial ret = new Historial();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long historial = nextHistorial();
        ret.setHistorial(historial);
        String descripcion = "";
        do {
            System.out.println("Introduce descripción: ");
            descripcion = in.nextLine();
            if (!Validaciones.validarTexto(descripcion));
            System.out.println("El texto no es válido: " + descripcion);
        } while (!Validaciones.validarTexto(descripcion));
        ret.setDescripcion(descripcion);

        return ret;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>historial</code> y un
     * array de identificadores, y devuelve una sublista con los Historial cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Historial en las que buscar
     * @param ids array de ids de Historial
     * @return ArrayList<code>Historial</code>
     */
    public static ArrayList<Historial> arrayde(ArrayList<Historial> lista, int[] ids) {
        ArrayList<Historial> ret = new ArrayList<Historial>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getHistoria() == ids[i]) {
                    ret.add((Historial) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Historial> convertir(Historial[] array) {
        ArrayList<Historial> ret = new ArrayList<Historial>();
        for (Historial i : array) {
            ret.add((Historial) i);
        }
        return ret;
    }
}
