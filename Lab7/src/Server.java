
import java.io.*;
import java.util.*;
import java.net.*;

// Server class
public class Server {

    // Vector to store active clients
    static Vector<ClientHandler> users = new Vector<>();
    static DataInputStream dis;
    static DataOutputStream dos;

    // counter for clients
    static int i = 0;

    public static void main(String[] args) throws IOException
    {
        // server is listening on port 1234
        ServerSocket ss = new ServerSocket(1234);
        Socket s;

        // running infinite loop for getting
        // client request
        while (true)
        {
            // Accept the incoming request
            s = ss.accept();

            System.out.println("New client request received : " + s);

            // obtain input and output streams
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());


            dos.writeUTF("want to login or sign up?");
            String operation = dis.readUTF();
            ClientHandler mtch = null;
            switch (operation){
                case "sign up":
                    mtch = register(s);
                    break;
                case "login":
                    mtch = login(s);
                    break;
            }

            dos.writeUTF("Welcome " + mtch.name);
            // Create a new Thread with this object.
            Thread t = new Thread(mtch);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            users.add(mtch);
            // start the thread.
            t.start();

            // increment i for new client.
            // i is used for naming only, and can be replaced
            // by any naming scheme
            i++;

        }
    }

    private static ClientHandler login(Socket s) throws IOException {
        ClientHandler clientHandler = null;
        while (true) {
            dos.writeUTF("Enter username:");
            String username = dis.readUTF();
            int flag = 0;
            for (ClientHandler user : users) {
                if (user.name.equals(username)) {
                    clientHandler = user;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                dos.writeUTF("No user with that name. try again:");
            } else {
                dos.writeUTF("Enter Password");
                String password = dis.readUTF();
                if(password.equals(clientHandler.getPassword())){
                    return clientHandler;
                }
            }
        }
    }

    private static ClientHandler register(Socket s) throws IOException {
        int flag = 0;
        String username = "";
        String password = "";
        while (flag == 0) {
            int check = 1;
            dos.writeUTF("Enter username:");
            username = dis.readUTF();
            for (ClientHandler user : users) {
                if (user.name.equals(username)) {
                    dos.writeUTF("This username exists. Try another one");
                    check = 0;
                    break;
                }
            }
            if (check == 1) {
                flag = 1;
                dos.writeUTF("Set Your Password:");
                password = dis.readUTF();
            }
        }
        System.out.println("Creating a new handler for this client...");


        // Create a new handler object for handling this request.
        ClientHandler mtch = new ClientHandler(s,username,password, dis, dos);
        return mtch;
    }

}

// ClientHandler class
class ClientHandler implements Runnable {

    Scanner scn = new Scanner(System.in);
    public String name;
    private String password;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    // constructor
    public ClientHandler(Socket s, String name,String password,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.password = password;
        this.s = s;
        this.isloggedin=true;

    }

    public String getPassword() {
        return password;
    }

    @Override
    public void run() {

        String received;
        while (true)
        {
            try
            {
                // receive the string
                received = dis.readUTF();

                System.out.println(received);

                if(received.equals("logout")){
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }

                // break the string into message and recipient part
                StringTokenizer st = new StringTokenizer(received, "#");
                String MsgToSend = st.nextToken();
                String recipient = st.nextToken();

                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users
                int flag = 0;
                for (ClientHandler mc : Server.users)
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.name.equals(recipient) && mc.isloggedin==true)
                    {
                        mc.dos.writeUTF(this.name+" : "+MsgToSend);
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0){
                    dos.writeUTF("no such a user online");
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
