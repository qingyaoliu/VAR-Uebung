import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ComputePiServer extends UnicastRemoteObject implements ComputePiRemote {

	protected ComputePiServer() throws RemoteException {
        super();
    }

    @Override
    public int rechneKreisAnzahl(int count) throws RemoteException {
        int count_inside = 0; // oder alternativ TCP/IP-Portnummer des Server-Objekts vorgeben

        for (int i = 0; i < count ; i++){
            double x = Math.random();
            double y = Math.random();
            if(Math.hypot(x, y) < 1){
            	count_inside ++;
            }
        }
        return count_inside;
    }
}