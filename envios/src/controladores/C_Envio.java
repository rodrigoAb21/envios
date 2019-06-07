/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import modelos.Envio;
import modelos.PagoPaypal;
import modelos.PagoTarjeta;
import modelos.Paquete;
import vistas.V_Envio;

/**
 *
 * @author KAKU
 */
public class C_Envio implements ActionListener{
    V_Envio vista_envio;
    Envio envio;

    public C_Envio(Envio envio, String destino) {
        vista_envio = new V_Envio();
        this.envio = envio;
        vista_envio.label_titulo.setText("Envio a " + destino);
        vista_envio.setVisible(true);
        
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        df.format(envio.getCosto());

        // Cambiar Remitente
        if (e.getSource() == vista_envio.btn_cambiarRemitente) {
            envio.cambiarRemitente(vista_envio.txt_remitente.getText());
            vista_envio.txt_remitente.setText(envio.getRemitente());
        } 
        
        // Cambiar Destinatario
        else if (e.getSource() == vista_envio.btn_cambiarDestinatario) {
            envio.cambiarDestinatario(vista_envio.txt_destinatario.getText());
            vista_envio.txt_destinatario.setText(envio.getDestinatario());
        }
        
        // Agregar Paquete
        else if (e.getSource() == vista_envio.btn_agregar) {
            envio.agregarPaquete(
                    new Paquete(
                            Integer.parseInt(vista_envio.txt_cod.getText()),
                            vista_envio.txt_desc.getText(),
                            Float.parseFloat(vista_envio.txt_alto.getText()), 
                            Float.parseFloat(vista_envio.txt_ancho.getText()), 
                            Float.parseFloat(vista_envio.txt_largo.getText()), 
                            Float.parseFloat(vista_envio.txt_peso.getText())
                    )
            );
            
            
            vista_envio.actualizarTabla(envio.getPaquetes());
            vista_envio.label_total.setText(df.format(envio.getCosto()));
            vista_envio.limpiarDatosPaquete();
            
        }
        
        // Quitar Paquete
        else if (e.getSource() == vista_envio.btn_quitar) {
            envio.quitarPaquete(Integer.parseInt(vista_envio.txt_cod.getText()));
           
            vista_envio.actualizarTabla(envio.getPaquetes());
            vista_envio.label_total.setText(df.format(envio.getCosto()));
            vista_envio.limpiarDatosPaquete();
        }
        
        // Limpiar (Eliminar todos los paquetes)
        else if (e.getSource() == vista_envio.btn_vaciar) {
            envio.vaciar();
            
            vista_envio.actualizarTabla(envio.getPaquetes());
            vista_envio.label_total.setText(df.format(envio.getCosto()));
            vista_envio.limpiarDatosPaquete();
        }
        
        // DEFAULT
        else if (e.getSource() == vista_envio.btn_pagar) {
            if (vista_envio.rdb_paypal.isSelected() || vista_envio.rdb_visa.isSelected()) {
                envio.pagar();
                vista_envio.label_estado.setText(envio.getEstadoEnvio().getNombre());
            }
        }
        
         // DEFAULT
        else if (e.getSource() == vista_envio.btn_enviar) {
            envio.enviar();
            vista_envio.label_estado.setText(envio.getEstadoEnvio().getNombre());
        }
        
         // DEFAULT
        else if (e.getSource() == vista_envio.rdb_paypal) {
            envio.setMetodoPago(new PagoPaypal());
        }
        
         // DEFAULT
        else if (e.getSource() == vista_envio.rdb_visa) {
            envio.setMetodoPago(new PagoTarjeta());
        }
    }

    private void initComponents() {
        vista_envio.label_estado.setText(envio.getEstadoEnvio().getNombre());
        
        vista_envio.btn_cambiarRemitente.addActionListener(this);
        vista_envio.btn_cambiarDestinatario.addActionListener(this);
        vista_envio.btn_agregar.addActionListener(this);
        vista_envio.btn_quitar.addActionListener(this);
        vista_envio.btn_vaciar.addActionListener(this);
        vista_envio.btn_pagar.addActionListener(this);
        vista_envio.btn_enviar.addActionListener(this);
        
        vista_envio.rdb_paypal.addActionListener(this);
        vista_envio.rdb_visa.addActionListener(this);
        
    }

    
    
    
    
    
}
