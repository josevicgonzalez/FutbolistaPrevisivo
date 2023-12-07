
package futbolistaprevisivo;

import java.time.LocalDate;

public class Transaccion {
    
    private static String descripcion;
    private static double monto;
    private static LocalDate fechaTrans;
    private static String equipoIngresos;
    private static String tiempoContrato;
    private static int noYears;
    private static int valorYear;

    private static Transaccion instancia = new Transaccion();
    
    private Transaccion(){
    
    }
    
    public static Transaccion getInstancia(){
    
        return instancia;
    }
    
    //Construyendo el metodo 
    
    public Transaccion(String descripcion, double monto, LocalDate fechaTrans, String equipoIngresos, String tiempoContrato, int noYears, int valorYear) {
    
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaTrans = fechaTrans;
        this.equipoIngresos = equipoIngresos;
        this.tiempoContrato = tiempoContrato;
        this.noYears = noYears;
        this.valorYear = valorYear;
        
    
    }
    
    // Metodo de getters y setters
    
    public static String getDescripcion(){
       return descripcion;
       
    }
    
      public static void setDescripcion(String descripcion){
        Transaccion.descripcion = descripcion;
    }
      
      
    public static double getMonto(){
        return monto;
    
    } 
    
    public static void setMonto(double monto){
        Transaccion.monto = monto;
        
    }
    
    public static LocalDate getFechaTrans() {
    
       return fechaTrans; 
    
    }
    
    public static void setFechaTrans(LocalDate fechaTrans){
        Transaccion.fechaTrans = fechaTrans;
    }
    
       public static String getEquipoIngresos(){
       return equipoIngresos;
       
    }
       
       public static void setEquipoIngresos(String equipoIngresos){
        Transaccion.equipoIngresos = equipoIngresos;
    }
       
       public static String getTiempoContrato(){
       return tiempoContrato;
       
    }
       
       public static void setTiempoContrato(String tiempoContrato){
        Transaccion.tiempoContrato = tiempoContrato;
    }
       
       public static int getNoYears(){
       return noYears;
       
    }
       
       public static void setNoYears(int noYears){
        Transaccion.noYears = noYears;
    }
       
       public static int getValorYear(){
       return valorYear;
       
    }
       
       public static void setValorYear(int valorYear){
        Transaccion.valorYear = valorYear;
    }
    
}
