/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.JOptionPane;

/**
 *
 * @author KAKU
 */
public class EnProceso extends EstadoEnvio{

    public EnProceso(String nombre) {
        super(nombre);
    }

    @Override
    public void pagar(Envio envio, float costo) {
        // EJECUTAR ESTRATEGIA
        if (envio.getMetodoPago().pagar(costo)) {
            JOptionPane.showMessageDialog(null, "Pago exitoso.");
            envio.setEstadoEnvio(new Pagado("Pagado"));
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo realizar el pago.");
        }
    }

    @Override
    public void enviar(Envio envio) {
        // NO SE PUEDE ENVIAR DESDE ESTE ESTADO
    }

    @Override
    public void agregarPaquete(Envio envio, Paquete paquete) {
        envio.getPaquetes().add(paquete);
        envio.setCosto(envio.calcular());
    }

    @Override
    public void quitarPaquete(Envio envio, int codigo) {
     
        for (Paquete paquete : envio.getPaquetes()) {
            if(paquete.getCodigo() == codigo){
                envio.getPaquetes().remove(paquete);
                break;
            }
        }
        
        envio.setCosto(envio.calcular());
    }

    @Override
    public void vaciar(Envio envio) {
        envio.getPaquetes().clear();
        envio.setCosto(0.0f);
    }

    @Override
    public void cambiarRemitente(Envio envio, String remitente) {
        envio.setRemitente(remitente);
    }

    @Override
    public void cambiarDestinatario(Envio envio, String destinatario) {
        envio.setDestinatario(destinatario);
    }
    
}
