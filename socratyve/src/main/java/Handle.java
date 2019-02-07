import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class Handle {
    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        String username = "User" + Main.userNumber.incrementAndGet();
        Main.userUsernameMap.put(session, username);
        System.out.println(username + " conexion inicializada");
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        String username = Main.userUsernameMap.get(user);
        Main.userUsernameMap.remove(user);
        System.out.println(username + " conexion terminada");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
//        System.out.println(message);
        Main.broadcastMessage(Main.userUsernameMap.get(user), message);
    }
}
