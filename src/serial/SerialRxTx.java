/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JOptionPane;

import testes.SimuladorProblema;
import testes.SimuladorProblemaDAO;

/**
 *
 * @author Leo
 */
public class SerialRxTx implements SerialPortEventListener {

    SerialPort serialPort = null;
    private Protocolo protocolo = new Protocolo();
    private String appName; //nome da aplicacao

    private BufferedReader input; //objeto para leitura da serial
    private OutputStream output; //objeto para escrever na serial
    

    private static final int TIME_OUT = 1000; //tempo de espera para comunicação
    private static final int DATA_RATE = 9600; //baud rate velocidade da comunicação

    private String serialPortName = "COM5";

    public boolean iniciaSerial() {
        try {
            //pega todas portas seriais do sistema
            CommPortIdentifier portid = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            while (portid == null && portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

                if (currPortId.getName().equals(serialPortName) || currPortId.getName().startsWith(serialPortName)) {
                    serialPort = (SerialPort) currPortId.open(appName, TIME_OUT);
                    portid = currPortId;
                    System.out.println("Conectado com sucesso a porta: " + currPortId.getName());
                    break;
                }
            }

            if (portid == null || serialPort == null) {
                return false;
            }

            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return true;

        } catch (Exception e) {
        }

        return false;
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }

    }
    
   

    @Override
    public void serialEvent(SerialPortEvent spe) {
        //Metodo tratar chegada do Arduino

        try {
            switch (spe.getEventType()) {
                case SerialPortEvent.DATA_AVAILABLE:
                    if (input == null) {
                        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

                        protocolo.setLeituraComando(input.readLine());
                        protocolo.getLeituraComando();
                        
                   

                        SimuladorProblema spb = new SimuladorProblema();

                        spb.setLatitude(protocolo.getLatitude());
                        spb.setLongitude(protocolo.getLongitude());

                        SimuladorProblemaDAO dao = new SimuladorProblemaDAO();
                        dao.insereSimuladorProblema(spb);
                        
                        close();
                        
                        System.exit(0);
                        break;


                    }

                default:
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
