/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author KAKU
 */
public class PagoPaypal implements MetodoPago{

//    @Override
//    public boolean pagar(float total) {
//        String email = JOptionPane.showInputDialog(null, "Ingrese su Email:");
//        
//        Pattern pattern = Pattern
//                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//        
//        if (!pattern.matcher(email).find()) return false;
//
//        String password = JOptionPane.showInputDialog(null, "Ingrese su Password:");
//        
//        return password.length() > 5;
//    }
    
     @Override
    public boolean pagar(float total) {
        
        JLabel jEmail = new JLabel("Email");
        JTextField txt_email = new JTextField();
        JLabel jPassword = new JLabel("Password");
        JPasswordField txt_password = new JPasswordField();
        Object[] ob = {jEmail, txt_email, jPassword, txt_password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Login PayPal", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String email = txt_email.getText();
            String password = String.valueOf(txt_password.getPassword());
            Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            
            return pattern.matcher(email).find() && (password.length() > 5);
        }
        
        return false;
        
    }
    
}
