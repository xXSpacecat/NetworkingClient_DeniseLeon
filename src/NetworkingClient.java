import java.io.*;
import java.net.*;

public class NetworkingClient {
    public static void main(String[] args) {
        Socket client = null;
        //default portnumber
        int portNumber = 1234;
        if (args.length >= 1){
            portNumber = Integer.parseInt(args[0]);
        }
        for (int  i = 0; i<10; i++){
            try{
                String msg = " ";

                //Create client soket
                client = new Socket(InetAddress.getLocalHost(), portNumber);
                System.out.println("Client socket is created "+client);

                //Create output stream
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut. true);

                //Input stream
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                //Bufferedreader
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter your name: ");

            }
        }
    }
}
