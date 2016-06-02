package monteCarlo.server;

import java.rmi.registry.*;


public class MonteCarloServerStartup {
	
	public static void main(String[] args){
		
		try {
				Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
				registry.rebind("MonteCarloServer", new MonteCarloServer());
				System.out.println("MonteCarloServer on port: " + Registry.REGISTRY_PORT);
		}
		catch(Exception e) {
			System.err.println("MonteCarloServer exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
