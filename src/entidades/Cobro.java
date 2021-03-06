/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Cobro {

    private long id; // > 0 
    private double importe; // > 0 
    private Date FechaFin;    
    //VAL: Todos los valores comprendidos entre el 01/01/2000 hasta el 31/12/2100
    //INVAL: Letras y caracteres especiales excepto “/"

    //getters
    public long getId() {
        return id;
    }

    public double getImporte() {
        return importe;
    }

    public Date getFechaFin() {
        return FechaFin;
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

    public void setImporte(double importe) {
        try {
            if (Validaciones.validarImporte(importe)) {
                this.importe = importe;
            } else {
                throw new Exception("Importe inválido: " + importe);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    //Constructores
    public Cobro() {
    }

    public Cobro(long id, double importe, Date FechaFin)  {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }

            if (Validaciones.validarImporte(importe)) {
                this.importe = importe;
            } else {
                throw new Exception("Importe inválido: " + importe);
            }
            this.FechaFin = FechaFin;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Cobro(Cobro c) {

        this.id = c.id;
        this.importe = c.importe;
        this.FechaFin = c.FechaFin;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", importe: " + importe + ", Fecha fin: " + FechaFin;
    }

    //METODO
    public static Cobro nuevoCobro() {

        Cobro ret = new Cobro();

        try {
            Scanner in = new Scanner(System.in);
            long id = nextIdCobro();
            ret.setId(id);
            System.out.println("Introduce la fecha fin del cobro: ");
            Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
            ret.setFechaFin(fecha);
            double importe = -1;
            do {
                System.out.println("Introduce el importe del cobro: ");
                importe = in.nextDouble();
                if (!Validaciones.validarImporte(importe)) {
                    System.out.println("Importe introducido inválido.");
                }
            } while (!Validaciones.validarImporte(importe));
            ret.setImporte(importe);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ret;
    }
    
 /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|importe|fechafin
     */
    public String data(){
        String ret;
        ret = id +"|"+ importe +"|"+ FechaFin;
        return ret;
    }
    
    public static long nextIdCobro() {
        long ret = 0;
        for (int i = 0; i < Utilidades.COBROS.length; i++) {
            if (Utilidades.COBROS[i].id > ret);
            ret = Utilidades.COBROS[i].id;
        }
        return ret + 1;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Cobro</code> y un array
     * de identificadores, y devuelve una sublista con los Cirujanos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Cobros en las que buscar
     * @param ids array de ids de Cobros
     * @return ArrayList<code>Cobro</code>
     */
    public static ArrayList<Cobro> arrayde(ArrayList<Cobro> lista, int[] ids) {
        ArrayList<Cobro> ret = new ArrayList<Cobro>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cobro) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Cobro> convertir(Cobro[] array) {
        ArrayList<Cobro> ret = new ArrayList<Cobro>();
        for (Cobro i : array) {
            ret.add((Cobro) i);
        }
        return ret;
    }

    //Funcion para ver todos los cobros//
    public static void verCobros() {
        System.out.println("Listado de cobros: ");
        for (int i = 0; i < Utilidades.numCobros; i++) {
            System.out.println(Utilidades.COBROS[i]);
        }

    }

    public static Cobro buscarCobroporId(long id, ArrayList<Cobro> cobros) {
        Cobro ret = null;
        for (Cobro c : Cobro.convertir(Utilidades.COBROS)) {
            if (c.getId() == id) {
                ret = c;
                break;
            }
        }
        return ret;
    }
}
