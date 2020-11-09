
import java.io.*;
import java.net.*;


public class Client {


    public static void main(String[] args) throws IOException { 

        Socket s = new Socket("localhost", 4999);
PrintWriter pr=new PrintWriter(s.getoutputStream());
pr.println("Hello");
pr.flush();
    }

}
