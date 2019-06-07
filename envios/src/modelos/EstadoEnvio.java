/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author KAKU
 */
public abstract class EstadoEnvio {
    private String nombre;

    public EstadoEnvio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void pagar(Envio envio, float costo);
    public abstract void enviar(Envio envio);
    public abstract void agregarPaquete(Envio envio, Paquete paquete);
    public abstract void quitarPaquete(Envio envio, int codigo);
    public abstract void vaciar(Envio envio);
    public abstract void cambiarRemitente(Envio envio, String remitente);
    public abstract void cambiarDestinatario(Envio envio, String destinatario);
}
