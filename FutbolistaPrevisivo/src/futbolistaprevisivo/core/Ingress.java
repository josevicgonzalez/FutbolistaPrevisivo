
package futbolistaprevisivo.core;

import java.util.Date;

public class Ingress {

    private Date fecha;
    private String tipoContrato;
    private int cantidadAnios;
    private double valorPorAnio;
    private String descripcion;
    private double subtotal;
    private String contrato;
    private boolean idContrato = false;
    private double porcentaje;
    private double montoAInvertir;

    public Ingress(){
        
    }
    
    public boolean isIdContrato() {
        return idContrato;
    }
    
    public void setIdContrato(boolean idContrato) {
    
        this.idContrato = idContrato;
    
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public double getValorPorAnio() {
        return valorPorAnio;
    }

    public void setValorPorAnio(double valorPorAnio) {
        this.valorPorAnio = valorPorAnio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getMontoAInvertir() {
        return montoAInvertir;
    }

    public void setMontoAInvertir(double montoAInvertir) {
        this.montoAInvertir = montoAInvertir;
    }
    
      @Override
    public String toString() {
        return "Ingreso{" +
                "fecha=" + fecha +
                ", tipoContrato='" + tipoContrato + '\'' +
                ", cantidadAnios=" + cantidadAnios +
                ", valorPorAnio=" + valorPorAnio +
                ", descripcion='" + descripcion + '\'' +
                ", subtotal=" + subtotal +
                ", contrato='" + contrato + '\'' +
                ", porcentaje=" + porcentaje +
                ", montoAInvertir=" + montoAInvertir +
                '}';
    }
    
    
    
    
    
    
}
