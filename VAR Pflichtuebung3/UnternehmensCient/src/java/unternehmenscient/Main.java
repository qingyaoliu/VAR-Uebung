/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unternehmenscient;

import java.util.Scanner;
import javax.xml.ws.WebServiceRef;
import unternehmensclient.Distance_Service;

/**
 *
 * @author Daud
 */
public class Main {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/UnternehmensServer/Distance.wsdl")
    private static Distance_Service service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String start = "";
        String ziel = "";
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Start ein. ");
        System.out.println("Folgende Orte sind verfügbar:");
        System.out.println("HQ = Mannheim");
        System.out.println("OB = Berlin");
        System.out.println("OH = Hamburg");
        System.out.println("OM = München");
        
        start = scanner.nextLine();
        
        System.out.println("Bitte geben Sie ihren Ziel ein. ");
        System.out.println("Folgende Orte sind verfügbar:");
        System.out.println("HQ = Mannheim");
        System.out.println("OB = Berlin");
        System.out.println("OH = Hamburg");
        System.out.println("OM = München");
        ziel = scanner.nextLine();
        
        try{
            String result = distance(start, ziel);
            System.out.println("Result: " + result);
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private static String distance(java.lang.String start, java.lang.String ziel) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        unternehmensclient.Distance port = service.getDistancePort();
        return port.distance(start, ziel);
    }
    
}
