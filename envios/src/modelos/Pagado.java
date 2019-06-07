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
public class Pagado extends EstadoEnvio {

    public Pagado(String nombre) {
        super(nombre);
    }

    @Override
    public void pagar(Envio envio, float costo) {
        // NO SE PUEDE PAGAR DESDE ESTE ESTADO
    }

    @Override
    public void enviar(Envio envio) {
        envio.setEstadoEnvio(new Enviado("Enviado"));
    }

    @Override
    public void agregarPaquete(Envio envio, Paquete paquete) {
        // NO SE PUEDE MODIFICAR EL ENVIO UNA VEZ PAGADO
    }

    @Override
    public void quitarPaquete(Envio envio, int codigo) {
        // NO SE PUEDE MODIFICAR EL ENVIO UNA VEZ PAGADO
    }

    @Override
    public void vaciar(Envio envio) {
        // NO SE PUEDE MODIFICAR EL ENVIO UNA VEZ PAGADO
    }

    @Override
    public void cambiarRemitente(Envio envio, String remitente) {
        // NO SE PUEDE MODIFICAR EL ENVIO UNA VEZ PAGADO
    }

    @Override
    public void cambiarDestinatario(Envio envio, String destinatario) {
        // NO SE PUEDE MODIFICAR EL ENVIO UNA VEZ PAGADO
    }

}
