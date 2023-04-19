package Connect;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

public class TransferDataToDatabase {
	
	public static void main(String [] args) {
    	
	    MongoClient mongoClient = null;
	    try {
	    	
	    	mongoClient = new MongoClient( "127.0.0.1" , 27017 );
	    	
	    	System.out.println("Connected to MongoDB!");
	    	
	    	MongoDatabase database = mongoClient.getDatabase("Jarvis");
	    	
	    	Document document = new Document();
	        document.append("name", "Rajkumar");
	        document.append("LastName", "Patil");
	        document.append("age", 23);
	        document.append("city", "Chennai");
	        //Inserting the document into the collection
	        database.getCollection("TonyStark").insertOne(document);
	        System.out.println("Document inserted successfully");
	    }
	    catch(MongoException e)
	    {
	    	System.out.println(e);
	    }
    }
}

