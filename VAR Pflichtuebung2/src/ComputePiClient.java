import java.math.*;
import java.rmi.*;

public class ComputePiClient {

    public static void main(String[] args) {

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        for (int i = 0; i < 3 ; i++) {

            try {

            	String name = "//" + args[0] + "/ComputePiRemote";
                ComputePiRemote computePiRemote = (ComputePiRemote) Naming.lookup(name);
                int count = Integer.parseInt(args[1]);
                int count_inside = computePiRemote.rechneKreisAnzahl(count);
                System.out.println("Anzahl der Zufallzahlen innerhalb des Kreissegments: " + count_inside);
                System.out.println("Anzahl der Zufallzahlen ausserhalb des Kreissegments " + count);
                
                BigDecimal pi = new BigDecimal(4 * count_inside / count);
                System.out.println("Pi: " + pi);
                
            } catch (Exception e) {
                System.err.println("ComputePiClient exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}