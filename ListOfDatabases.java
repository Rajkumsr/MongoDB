package Connect;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoIterable;

public class ListOfDatabases {
	
public static void main(String [] args) {
    	
	    MongoClient mongoClient = null;
	    try {
	    	
	    	mongoClient = new MongoClient( "127.0.0.1" , 27017 );
	    	
	    	System.out.println("Connected to MongoDB!");
	    	
	    	MongoIterable<String> list = mongoClient.listDatabaseNames();
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
