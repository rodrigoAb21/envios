/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAKU
 */
public abstract class Envio {

    private String remitente, destinatario;
    private List<Paquete> paquetes;
    private float costo;
    private MetodoPago metodoPago;
    private EstadoEnvio estadoEnvio;

    public Envio() {
        paquetes = new ArrayList<>();
        costo = 0.0f;
        remitente = ""; 
        destinatario = "";
        estadoEnvio = new EnProceso("En Proceso");
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
    
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

     
    // SET ESTRTATEGIA
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    // *************************** ESTADO **************************************
    
    public void pagar(){
        estadoEnvio.pagar(this, costo);
    }
    
    public void enviar(){
        estadoEnvio.enviar(this);
    }
    
    public void agregarPaquete(Paquete paquete){
        estadoEnvio.agregarPaquete(this, paquete);
    }
    
    public void quitarPaquete(int codigo){
        estadoEnvio.quitarPaquete(this, codigo);
    }
    
    public void vaciar(){
        estadoEnvio.vaciar(this);
    }
    
    public void cambiarRemitente(String remitente){
        estadoEnvio.cambiarRemitente(this, remitente);
    }
    
    public void cambiarDestinatario(String destinatario){
        estadoEnvio.cambiarDestinatario(this, destinatario);
    }
    
    
    // ************************** PLANTILLA ************************************
    
    // METODO PLANTILLA
    public float calcular() {
        float total = 0f;
        float volumen = 0f;
        for (Paquete paquete : paquetes) {
            volumen = paquete.getAlto() * paquete.getAncho() * paquete.getLargo();
            total = total + operacion(volumen, paquete.getPeso());
        }
        return total;
    }

    // OPERACION ABSTRACTA DEL METODO PLANTILLA
    protected abstract float operacion(float volumen, float peso);

}
