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
                PrintWriter pw = new PrintWriter(clientOut, true);

                //Input stream
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                //Bufferedreader
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter your name. Type Bye to exit: ");
                //read data from standard input
                //write it to output
                msg = stdIn.readLine().trim();
                pw.println(msg);

                //read data from input stream
                System.out.println("Message returned from server = " + br.readLine());
                pw.close();
                br.close();
                client.close();
                //Stop operation
                if (msg.equalsIgnoreCase("bye")){
                    break;
                }

            }catch(IOException ie){
                System.out.println("I/O error " + ie);
            }
        }
    }
}
