/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author KAKU
 */
public class PagoTarjeta implements MetodoPago{

    @Override
    public boolean pagar(float total) {
        JLabel jNombre = new JLabel("Nombre");
        JTextField txt_nombre = new JTextField();
        JLabel jNumero = new JLabel("Nro");
        JTextField txt_numero = new JTextField();
        JLabel jCod = new JLabel("CVV");
        JTextField txt_cod = new JTextField();
        JLabel jVenc = new JLabel("Venc");
        JTextField txt_venc = new JTextField();
        Object[] ob = {jNombre, txt_nombre, jNumero, txt_numero, jCod, txt_cod, jVenc, txt_venc};
        int result = JOptionPane.showConfirmDialog(null, ob, "Digite los datos de su tarjeta VISA", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nombre = txt_nombre.getText();
            String numero = txt_numero.getText();
            String codVerf = txt_cod.getText();
            String vencimiento = txt_venc.getText();
            
            return (nombre.length() > 3) && (numero.length() == 16) && 
                    (codVerf.length() == 3) && (vencimiento.length() > 0);
        }
        
        return false;
        
    }
    
    
}
