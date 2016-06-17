/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance;

import java.net.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daud
 */
@WebService(serviceName = "Distance")
public class Distance {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "distance")
    public String distance(@WebParam(name = "start") String start,@WebParam(name = "ziel") String ziel) {
        //TODO write your implementation code here:
        Client client = ClientBuilder.newClient();
        String key = "AIzaSyDp2BjEAljUDLLiYowDUoA8ucd61beBMkM";
        String origins = "";
        String destination = "";
        String link = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        String distance = "";
        String duration = "";
        
        try{
            start = start.toLowerCase();
            ziel = ziel.toLowerCase();
            switch(start){
                case "hq":
                    origins = "Mannheim";
                    break;
                case "ob":
                    origins = "Berlin";
                    break;
                case "oh":
                    origins = "Hamburg";
                    break;
                case "om":
                    origins = "München";
                    break;
                default:
                    break;
            }
            switch(ziel){
                case "hq":
                    destination = "Mannheim";
                    break;
                case "ob":
                    destination = "Berlin";
                    break;
                case "oh":
                    destination = "Hamburg";
                    break;
                case "om":
                    destination = "München";
                    break;
                default:
                    break;
            }
            link = link + "origins=" + origins + "&destinations=" + destination + "&mode=driving&key=" + key;
            WebTarget allSlidesTarget = client.target(link);
            Invocation allSlidesInvocation = allSlidesTarget.request().accept("application/json").buildGet();

            Response response = allSlidesInvocation.invoke();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Fehler: HTTP Fehlernummer: " + response.getStatus());
            }
            
            String output = response.readEntity(String.class);
            String result = output.substring(output.indexOf("text")+9,output.indexOf("text")+15);
         //   return "Entfernung: " + distance + " Fahrzeit: " + duration;
            
            return result;
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
