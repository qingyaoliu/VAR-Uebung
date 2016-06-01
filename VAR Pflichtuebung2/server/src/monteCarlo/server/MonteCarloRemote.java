package monteCarlo.server;
import java.math.*;
import java.rmi.*;

public interface MonteCarloRemote extends Remote{
	BigDecimal zufallszahlen(long tropfen) throws RemoteException;
}
