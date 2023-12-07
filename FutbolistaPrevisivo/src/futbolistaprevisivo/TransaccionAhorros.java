
package futbolistaprevisivo;

import java.time.LocalDate;

public class TransaccionAhorros {
    
    private String descripcionAhorro;
    private double montoAhorro;
    private LocalDate fechaAhorro;
    private double porcentaje;
    
    //Construyendo el metodo 
    
    public TransaccionAhorros(String descripcionAhorro, double montoAhorro, LocalDate fechaAhorro, double porcentaje) {
    
        this.descripcionAhorro = descripcionAhorro;
        this.montoAhorro = montoAhorro;
        this.fechaAhorro = fechaAhorro;
        this.porcentaje = porcentaje;
  
    }
    
    // Metodo de getters y setters
    
    public String getDescripcionAhorro(){
       return descripcionAhorro;
       
    }
    
      public void setDescripcionAhorro(String descripcionAhorro){
        this.descripcionAhorro = descripcionAhorro;
    }
      
      
    public double getMontoAhorro(){
        return montoAhorro;
    
    } 
    
    public void setMontoAhorro(double montoAhorro){
        this.montoAhorro = montoAhorro;
        
    }
    
    public LocalDate getFechaAhorro() {
    
       return fechaAhorro; 
    
    }
    
    public void setFechaAhorro(){
        this.fechaAhorro = fechaAhorro;
    }
    
    public double getPorcentaje() {
    
       return porcentaje; 
    
    }
    
    public void setPorcentaje(){
        this.porcentaje = porcentaje;
    }
     

}
    

