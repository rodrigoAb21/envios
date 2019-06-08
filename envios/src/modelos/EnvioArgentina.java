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
public class EnvioArgentina extends Envio{

    @Override
    protected float operacion(float volumen, float peso) {
        return volumen * 0.003f + peso * 0.2f + 75;
    }
    
}
