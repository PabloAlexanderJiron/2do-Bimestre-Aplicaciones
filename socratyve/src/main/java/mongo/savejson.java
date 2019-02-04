package mongo;

import com.mongodb.*;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class savejson {
    public void save(String json){
        Mongo socrativeMongo = new Mongo("127.0.0.1", 27017);
        DB db = socrativeMongo.getDB("cuestionario");
        DBCollection collection = db.getCollection("quiz");

        json = json.replace("[", "");
        json = json.replace("]", "");
        //System.out.println("--------------------");
        //System.out.println(json);
        DBObject obj = (DBObject) JSON.parse(json);
        //System.out.println(obj);
        collection.insert(obj);
    }
}
