/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unternehmensclient;

import javax.xml.ws.WebServiceRef;
import unternehmensClient.Distance_Service;

/**
 *
 * @author Nasir2
 */
public class UnternehmensClient {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/192.168.1.94_8080/UnternehmensServer/Distance.wsdl")
    private static Distance_Service service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }

    private static String distance(java.lang.String destination) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        unternehmensClient.Distance port = service.getDistancePort();
        return port.distance(destination);
    }
    
}
