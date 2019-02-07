package mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;

public class savejson {
    public void save(String json) {
        MongoClient socrativeMongo = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = socrativeMongo.getDatabase("cuestionario");
        MongoCollection<Document> collection = database.getCollection("quiz");
        collection.drop();
        Document doc;

       String aux="";
        ArrayList<String> prts = new ArrayList<>();
        for (int i=1; i<json.length(); i++){
            if (json.charAt(i) == ']') {
                prts.add(aux);
            }else {
                if (json.charAt(i) == '}' && json.charAt(i+1) == ',' && json.charAt(i+2) == '{') {
                    prts.add(aux + json.charAt(i));
                    aux = "";
                    i = (i + 1);
                }else {
                    aux = aux + json.charAt(i);
                }
            }
        }
        for (int i = 0; i < prts.size(); i++) {
            //System.out.println(prts.get(i));
            doc = Document.parse(prts.get(i));
            collection.insertOne(doc);
        }

    }
}
