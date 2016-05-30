import java.rmi.*;

public interface ComputePiRemote extends Remote {

    int rechneKreisAnzahl(int count) throws RemoteException;
}