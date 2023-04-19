package Connect;

import java.util.Scanner;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class ListOfCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		
		MongoClient mongoClient = null;
	    try {
	    	
	    	mongoClient = new MongoClient( "127.0.0.1" , 27017 );
	    	
	    	System.out.println("Connected to MongoDB!");
	    	
	    	System.out.print("Enter Database Name:");
	    	String db=sc.next();
	    	MongoDatabase database = mongoClient.getDatabase(db);
	    	
	    	 MongoIterable<String> list = database.listCollectionNames();
		     for (String name : list) {
		        	
		    	 System.out.println(name);
		     }
	    }
	    catch(MongoException e)
	    {
	    	System.out.println(e);
	    }

	}

}
