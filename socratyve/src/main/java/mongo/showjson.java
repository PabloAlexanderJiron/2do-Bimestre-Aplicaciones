package mongo;

import com.mongodb.*;
import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Projections.excludeId;

public class showjson {
    public String getjson(String quiz) {
        //IP y puerto de la DB, puerto por defecto de MongoDB 27017
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        //Nombre de la BD
        MongoDatabase database = mongoClient.getDatabase("cuestionario");
        //Nombre de la colección
        MongoCollection<Document> coll = database.getCollection("quiz");
        //Contamos el número de elementos (documentos)
        FindIterable<Document> iterable = coll.find().projection(excludeId());
        ArrayList<Document> documento=new ArrayList<Document>();
        String JSON="[";
        iterable.into(documento);
        for (Document p:documento){
            JSON = JSON + p.toJson()+",";
            //System.out.println(JSON);
        }
        JSON = JSON.substring(0,JSON.length()-1);
        JSON = JSON + "]";
        System.out.println(JSON);

        return JSON;
    }
}
