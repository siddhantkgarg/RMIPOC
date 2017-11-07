package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Interface.ICourseCRUD;
import Servants.CourseServant;
import Util.Constants;
/*
 * Server class; 
 * Takes input for course offered.
 * Students opt in for any offered course.
 */
public class Server {

		@SuppressWarnings("deprecation")
		public static void main(String s[]) {
			
				System.out.println("Siddhant123");
 			 try {
		            CourseServant courseServant = new CourseServant();
		            ICourseCRUD courseStub = (ICourseCRUD) UnicastRemoteObject.exportObject(courseServant, 0);

		            // Bind the remote object's stub in the registry
		            Registry registryCS = LocateRegistry.createRegistry(Constants.HOST);
		            System.out.println(registryCS.toString());
		            registryCS.rebind("myCourse", courseStub);
		            System.out.println("Server ready");
		        } catch (Exception e) {
		            System.err.println("Server exception: " + e.toString());
		            e.printStackTrace();
		        }
			
		}
}
