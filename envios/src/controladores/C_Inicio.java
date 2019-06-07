/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.EnvioArgentina;
import modelos.EnvioBrasil;
import modelos.EnvioChile;

import vistas.V_Inicio;

/**
 *
 * @author KAKU
 */
public class C_Inicio implements ActionListener {
    V_Inicio vista_inicio;

    public C_Inicio() {
        vista_inicio = new V_Inicio();
        initComponents();
    }

    private void initComponents() {
        vista_inicio.btn_brasil.addActionListener(this);
        vista_inicio.btn_chile.addActionListener(this);
        vista_inicio.btn_argentina.addActionListener(this);
        
        vista_inicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_inicio.btn_brasil) {
            new C_Envio(new EnvioBrasil(), "Brasil");
        } else if (e.getSource() == vista_inicio.btn_chile) {
            new C_Envio(new EnvioChile(), "Chile");
        } else if (e.getSource() == vista_inicio.btn_argentina) {
            new C_Envio(new EnvioArgentina(), "Argentina");
        }
    }
    
    public static void main(String[] args) {
        new C_Inicio();
    }
}
