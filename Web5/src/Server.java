import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> str = new ArrayList<>();
        try{
            FileInputStream fstream = new FileInputStream("input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                str.add(strLine);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

        try (ServerSocket server= new ServerSocket(3345)){
            Socket client = server.accept();

            System.out.print("Connection accepted.");

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream  created");

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");

            while(!client.isClosed()){

                System.out.println("Server reading from channel");

                String entry = in.readUTF();

                System.out.println("READ from client message - "+entry);

                System.out.println("Server try writing to channel");

                if(entry.equalsIgnoreCase("quit")){
                   System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - "+str.get(2) + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }

                out.writeUTF("Server reply - "+str.get(3) + " - OK");
                System.out.println("Server Wrote message to client.");

                out.flush();
                Thread.sleep(1000);
            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            in.close();
            out.close();

            client.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}