import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(8080);
        try {
            while (true) {
                Socket socket = serversocket.accept();
                startHandler(socket);
            }
        } finally {
            serversocket.close();
        }
    }

    public String updateDB(String key, String input) throws RemoteException {
        DatabaseImpl newData = new DatabaseImpl();
        newData.addRecord(Integer.parseInt(key), input);
        System.out.println("Updated Record:" + " " + key + "," + input);
        return "Database updated";
    }

    public String checkDB(String key) throws RemoteException {
        DatabaseImpl newData = new DatabaseImpl();
        return newData.getRecord(Integer.parseInt(key));
    }

    public int dbSize() throws RemoteException {
        DatabaseImpl newData = new DatabaseImpl();
        return newData.getSize();
    }

    private static void startHandler(final Socket socket) throws IOException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Fail to close..");
                }
            }
        };
        thread.start();
    }
}