/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

/**
 *
 * @author Leo
 */
public class main {

    public static void main(String[] args) {
        SerialRxTx serial = new SerialRxTx();
  Protocolo pt = new Protocolo();
       
        if (serial.iniciaSerial()) {
          
            while (true) {
            

            }

        }
    }

}
