import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Interface.ICourseCRUD;
import Model.CourseDetails;
import Util.Constants;



public class Client {
	
	
	public static void makeInteractive() {
		Scanner sc = new Scanner(System.in);
		while(!sc.nextLine().equalsIgnoreCase("exit")) {
			
		}
		
	}
	private Client() {}
	 public static void main(String[] args) {
	        try {
	        	
	        	if (System.getSecurityManager() == null) 
	        	{
	        	    System.setSecurityManager(new java.rmi.RMISecurityManager());
	        	    System.out.println("SecurityManager:"+System.getSecurityManager());
	        	}
	        	
	        	
	           // CRUD<CourseDetails> cOfferStub = (CRUD<CourseDetails>) UnicastRemoteObject.exportObject(courseServant, 0);
	        	System.out.println("Client hello");
	        	
	            // Bind the remote object's stub in the registry
	            Registry registryCS = LocateRegistry.getRegistry(Constants.HOST);
	            ICourseCRUD courseServant = (ICourseCRUD) Naming.lookup("myCourse");
	            System.out.println(courseServant.toString());
	            CourseDetails cd2 = new CourseDetails();
	            CourseDetails cd = courseServant.getCourse(1);
	            System.out.println(cd.toString());;
	            System.out.println("Server ready");
	        	
	        } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	        }
	    }

}
