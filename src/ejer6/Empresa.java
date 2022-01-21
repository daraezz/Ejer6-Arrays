package ejer6;

import numeros.Numeros;
import fecha.Fecha;
import string.Textos;

/**
 *
 * @author Daniel Miranda Pérez
 */

public class Empresa {

    Empleado[] tablaEmpleados;
    Cotizacion[] tablaCotizacion;

    public Empresa() {
        cotizacion();
    }

    public void cotizacion() {
        tablaCotizacion = new Cotizacion[7];
        
        tablaCotizacion[0] = new Cotizacion("Ingeniero y Licenciado", 1466.40f);
        tablaCotizacion[1] = new Cotizacion("Ingenieros Técnicos, Peritos y Ayudantes", 1215.90f);
        tablaCotizacion[2] = new Cotizacion("Jefes administrativos y de taller", 1057.80f);
        tablaCotizacion[3] = new Cotizacion("Ayudantes no titulados", 1050.00f);
        tablaCotizacion[4] = new Cotizacion("Oficiales administrativos", 1050.00f);
        tablaCotizacion[5] = new Cotizacion("Subalternos", 1050.00f);
        tablaCotizacion[6] = new Cotizacion("Auxiliares Administrativos", 1050.00f);
    }
    
    public void mostrarTabla(){
        System.out.println("\t\tCATEGORIAS");
        for (int i = 0; i<tablaCotizacion.length; i++){
            System.out.println(i +"\t"+ tablaCotizacion[i].getDenominacion() + "\t" + tablaCotizacion[i].getSueldo() + "€");
        }
    }

    public void introducirDatos() {
        int nEmpleados = Numeros.pedirNumero("Introduce el numero de empleados:", 1);
        tablaEmpleados = new Empleado[nEmpleados];
        String nombre;
        Fecha fechaAlta;
        int grupoCotizacion;

        for (int i = 0; i < tablaEmpleados.length; i++) {
            nombre = Textos.pedirString("Introduce el nombre del empleado:");
            fechaAlta = Textos.pedirFecha("Introduce la fecha alta:");
            mostrarTabla();
            grupoCotizacion = Numeros.pedirNumero("\nIntroduce el grupo de cotizacion:", 0, tablaCotizacion.length);
            tablaEmpleados[i] = new Empleado(nombre, fechaAlta, grupoCotizacion);
        }
    }

    public void mostrarInformacion() {
        Fecha fechaHoy = new Fecha();
        double importe = 0; // Base minima segun grupo * 0.5 + Numeros quinquenios * 100
        System.out.println("\t\tINFORME ANUAL");
        System.out.println("Nombre\t\tGrupo Cotizacion\tFecha de Alta\t\tQuinquenios\t\tImporte a percibir");

        for (int i = 0; i < tablaEmpleados.length; i++) {
            if (fechaHoy.calcularSenios(tablaEmpleados[i].getFechaAlta(), 5) > 0) {
                importe = tablaCotizacion[i].getSueldo() * 0.5 + fechaHoy.calcularSenios(tablaEmpleados[i].getFechaAlta(), 5) * 100;
                System.out.println(tablaEmpleados[i].getNombre() + "\t\t     " + tablaEmpleados[i].grupoCotizacion() + "\t\t\t" + tablaEmpleados[i].getFechaAlta().fechaCompletaLetra() + "\t\t    " + fechaHoy.calcularSenios(tablaEmpleados[i].getFechaAlta(), 5) + "\t\t\t" + importe);
            }
        }
    }
}
