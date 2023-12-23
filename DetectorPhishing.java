package yaritzaTriviño;

import java.io.*;
import java.util.*;

public class DetectorPhishing {
    // Este mapa almacena los términos de phishing y su correspondiente puntuación.
    private static final Map<String, Integer> terminosPhishing = new HashMap<>();

    // Este bloque estático inicializa el mapa con los términos de phishing y sus puntuaciones.
    static {
        terminosPhishing.put("banco", 3);
        terminosPhishing.put("email", 3);
        terminosPhishing.put("clave", 3);
        terminosPhishing.put("actualización de seguridad", 2);
        terminosPhishing.put("oferta especial", 2);
        terminosPhishing.put("ganador de premio", 2);
        terminosPhishing.put("urgente", 3);
        terminosPhishing.put("problema de facturación", 2);
        terminosPhishing.put("restablecimiento de contraseña", 2);
        terminosPhishing.put("soporte técnico", 2);
        terminosPhishing.put("seguridad de la cuenta", 2);
        terminosPhishing.put("procesamiento de pago", 2);
        terminosPhishing.put("confirmación de pedido", 2);
        terminosPhishing.put("promoción", 2);
        terminosPhishing.put("descuento", 2);
        terminosPhishing.put("banca en línea", 3);
        terminosPhishing.put("compra sospechosa", 2);
        terminosPhishing.put("verificación de identidad", 2);
        terminosPhishing.put("recuperación de cuenta", 2);
        terminosPhishing.put("paypal", 3);
        terminosPhishing.put("phishing", 3);
        terminosPhishing.put("fraude", 3);
        terminosPhishing.put("spam", 2);
        terminosPhishing.put("tarjeta de crédito", 2);
        terminosPhishing.put("cuenta suspendida", 2);
        terminosPhishing.put("microsoft", 3);
        terminosPhishing.put("google", 3);
        terminosPhishing.put("netflix", 3);
        terminosPhishing.put("facebook", 3);
        terminosPhishing.put("apple", 3);
        terminosPhishing.put("información personal", 3);
    }
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\Downloads\\anime.txt"; 

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int puntuacionTotal = 0;
            Map<String, Integer> ocurrenciasTerminos = new HashMap<>();

            while ((linea = lector.readLine()) != null) {
                for (String termino : terminosPhishing.keySet()) {
                    if (linea.toLowerCase().contains(termino.toLowerCase())) {
                        puntuacionTotal += terminosPhishing.get(termino);
                        ocurrenciasTerminos.put(termino, ocurrenciasTerminos.getOrDefault(termino, 0) + 1);
                    }
                }
            } 
            for (String termino : ocurrenciasTerminos.keySet()) {
                System.out.println("Término: " + termino + ", Ocurrencias: " + ocurrenciasTerminos.get(termino) + ", Puntos: " + ocurrenciasTerminos.get(termino) * terminosPhishing.get(termino));
            }
