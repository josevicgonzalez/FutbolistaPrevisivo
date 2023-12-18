package futbolistaprevisivo.core;


import java.util.Date;

public class Egress {

    private Date fecha;
    private String descripcion;
    private double porcentaje;
    private double subtotal;
    private String contrato;

   
    public Egress(){
        
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }


    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    
       @Override
    public String toString() {
        return "Egreso{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", subtotal=" + subtotal +
                ", contrato='" + contrato + '\'' +
                ", porcentaje=" + porcentaje +
                '}';
    }
    
    
    
    
    
    
    
}
