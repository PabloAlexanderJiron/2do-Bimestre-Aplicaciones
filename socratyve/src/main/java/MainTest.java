import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import mongo.savejson;
import mongo.showjson;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import org.eclipse.jetty.websocket.api.Session;

import static com.mongodb.client.model.Projections.excludeId;
import static spark.Spark.init;
import static spark.Spark.webSocket;

public class MainTest {
    public static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();
    public static AtomicInteger userNumber = new AtomicInteger();

    public static void main(String [] args){
        webSocket("/estudiante", HandleE.class);
        init();
    }
    public static void broadcastMessage(String sender, String message) {
        //cjson.convert(message);
        userUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                String json = new showjson().getjson(message);
                System.out.println(json);
                session.getRemote().sendString(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
