package Serveur;

import Service.CalculatriceWS;
import jakarta.xml.ws.Endpoint;

public class ServeurJWS {
    public static void main(String[] args) {
        String url = "http://localhost:9090/";
        Endpoint.publish(url, new CalculatriceWS());
        System.out.println("Service SOAP publié à : " + url);
    }
}