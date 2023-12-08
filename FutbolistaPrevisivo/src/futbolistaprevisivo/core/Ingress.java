/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private double porcentaje;
    private double montoAInvertir;

    public Ingress(){
        
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
}
