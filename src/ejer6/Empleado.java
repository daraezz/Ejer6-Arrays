package ejer6;
import fecha.Fecha;

/**
 *
 * @author Daniel Miranda Pérez
 */
public class Empleado {
    private String nombre;
    private Fecha fechaAlta;
    private int grupoCotizacion;
    
    public Empleado(String nombre, Fecha fechaAlta, int grupoCotizacion){
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.grupoCotizacion = grupoCotizacion;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Fecha getFechaAlta(){
        return this.fechaAlta;
    }
    
    public int grupoCotizacion(){
        return grupoCotizacion;
    }
    
}
