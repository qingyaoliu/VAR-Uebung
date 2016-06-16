/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Daud
 */
@WebService(serviceName = "Distance")
public class Distance {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "distance")
    public String distance(@WebParam(name = "Start") String start,@WebParam(name = "Ziel") String ziel) {
        //TODO write your implementation code here:
        String key = "AIzaSyDp2BjEAljUDLLiYowDUoA8ucd61beBMkM";
        String origins = "";
        String destination = "";
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        
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
            url = url + "origins=" + origins + "&destination=" + destination + "&mode=driving";
            
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
}
