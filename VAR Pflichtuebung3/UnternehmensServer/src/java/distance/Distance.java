/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.google.gson.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Daud
 */
@WebService(serviceName = "Distance")
public class Distance {
    /**
     * Web service operation
     * @param start
     * @param ziel
     * @return 
     */
    @WebMethod(operationName = "distance")
    public String distance(@WebParam(name = "start") String start,@WebParam(name = "ziel") String ziel) {
        //TODO write your implementation code here:
       
        String key = "AIzaSyDp2BjEAljUDLLiYowDUoA8ucd61beBMkM";
        String origins = "";
        String destination = "";
        String link = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        String distance = "";
        String duration = "";
        if(start == null || ziel == null){
            return "start = " + start + " ziel = " + ziel;
        } else{
            try{
            
            switch(start){
                case "HQ":
                    origins = "Mannheim";
                    break;
                case "OB":
                    origins = "Berlin";
                    break;
                case "OH":
                    origins = "Hamburg";
                    break;
                case "OM":
                    origins = "Muenchen";
                    break;
                default:
                    break;
            }
            switch(ziel){
                case "HQ":
                    destination = "Mannheim";
                    break;
                case "OB":
                    destination = "Berlin";
                    break;
                case "OH":
                    destination = "Hamburg";
                    break;
                case "OM":
                    destination = "Muenchen";
                    break;
                default:
                    break;
            }
            link = link + "origins=" + origins + "&destinations=" + destination + "&mode=driving&key=" + key;
            
            URL url = new URL(link);
            HttpURLConnection request = (HttpURLConnection)url.openConnection();
            request.connect();
            
            JsonParser irg = new JsonParser();
            
            JsonElement elem = irg.parse(new InputStreamReader((InputStream)request.getContent()));
            
            JsonObject obj = elem.getAsJsonObject()
                    .get("rows").getAsJsonArray().get(0).getAsJsonObject()
                    .get("elements").getAsJsonArray().get(0).getAsJsonObject();
            
            JsonObject getDistance = obj.get("distance").getAsJsonObject();
            distance = getDistance.get("text").getAsString();
            
            JsonObject getDuration = obj.get("duration").getAsJsonObject();
            duration = getDuration.get("text").getAsString();
            
            return "Entfernung: " + distance + "\n Fahrzeit: " + duration;
            } catch(Exception e) {
            System.err.println(e);
            return "Fehler";
            }
        }
        
            
        
    }
}
