package ejer6;

/**
 *
 * @author danielmiranda
 */
public class Cotizacion {
    private String denominacion;
    private float sueldo;
    
    public Cotizacion(String denominacion, float sueldo){
        this.denominacion = denominacion;
        this.sueldo = sueldo;
    }
    
    public String getDenominacion(){
        return this.denominacion;
    }
    
    public float getSueldo(){
        return this.sueldo;
    }
}
