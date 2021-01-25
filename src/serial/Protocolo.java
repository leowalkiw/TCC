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
public class Protocolo {
    private String latitude;
    private String longitude;
    private String leituraComando;
    
    public void interpretaComando(){
    String aux[] = leituraComando.split(",");
    if(aux.length == 2){
   latitude = aux[0];
   longitude = aux[1];
    }
    }
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLeituraComando() {
        return leituraComando;
    }

    public void setLeituraComando(String leituraComando) {
        this.leituraComando = leituraComando;
        this.interpretaComando();
    }
    
    
}
