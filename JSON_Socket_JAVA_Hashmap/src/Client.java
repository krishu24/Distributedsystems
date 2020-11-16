import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, JSONException {
        Socket socket = new Socket("localhost", 8080);
        DatabaseImpl db = new DatabaseImpl();
        JSONObject jsonObject = new JSONObject();
        db.addRecord(4101, "Appen");
        db.addRecord(4102, "Ahrensburg");
        db.addRecord(4103, "Wedel");
        db.addRecord(4104, "Aumuhle");
        db.addRecord(4105, "Seevetal");
        db.addRecord(4106, "Quickborn");

        JSONObject result = jsonObject.put("get data for key-4103", db.getRecord(4103));
        JSONObject result2 = jsonObject.put("Database Size", db.getSize());

        System.out.println("Received from server: " + jsonObject.toString(2));

        socket.close();
    }
}
