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
public class EnvioBrasil extends Envio{

    @Override
    protected float operacion(float volumen, float peso) {
        return volumen * 0.08f + peso * 0.5f;
    }
    
}
