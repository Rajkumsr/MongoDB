package Connect;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.bson.Document;
import java.util.Iterator;
import java.util.Scanner;

public class MongoDBConnection {

    public static void main(String [] args) {
    	
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	
    	MongoClient mongoClient = null;
    	try {
    		
	    	mongoClient = new MongoClient( "127.0.0.1" , 27017 );
	
	    	System.out.println("Connected to MongoDB!");
	    	
	    	System.out.println("Enter db:");
	    	String db=sc.next();
	    	
	    	System.out.println("Enter Collection:");
	    	String col=sc.next();
	    	
	    	MongoDatabase database = mongoClient.getDatabase(db);
	   	 	MongoCollection<Document> collection = database.getCollection(col);
	   	 	
	        FindIterable<Document> iterDoc = collection.find();
	        Iterator<Document> it = iterDoc.iterator();
	        while (it.hasNext()) {
	        	
	           System.out.println(it.next());
	        }
    	} 
    	catch (MongoException e) {
    		
    		e.printStackTrace();
    	} 
    	
    	finally {
    		
    	 if(mongoClient!=null)
    		 mongoClient.close();
    	}	
    	
    }
}
