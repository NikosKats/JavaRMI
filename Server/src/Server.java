//Katsilidis Nikolaos 321/2014081
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Server extends UnicastRemoteObject implements ServerInt {

    //Dhmiourgia Array list gia thn eisagwgh twn client
    private static ArrayList<ClientInt> clients;

    public Server() throws RemoteException {
        super();
        clients = new ArrayList<ClientInt>();   
    }

    
    
    //Ylopoihsh ths returnSub pou epistrefei string me thn eggrafh tou client

    @Override
    public void returnSub(ClientInt client) throws RemoteException {

        System.out.println("Client Connected....");
        clients.add(client);
        
    }

     //Ylopoihsh ths returnSub pou epistrefei string me thn apeggrafh tou client
    @Override
    public void returnUnsub(ClientInt client) throws RemoteException {

        System.out.println("Client Disconnected....");
        clients.remove(client);
    }

    public static void main(String[] args) throws RemoteException {

        try {

            //Dhmiourgia antikeimenou server
            Server server = new Server();

            //sundesh sto RMI me thn porta 1099
            java.rmi.registry.LocateRegistry.createRegistry(1099);

            //Dhmiourgia sundeshs me to parakatw url
            Naming.rebind("//localhost/zoo", (Remote) server);

            System.out.println("Zoo Server is running ...");
            
            //Domh epanalhpshs gia sunexh apostolh gegonotwn
            while(true){
                
                Random r = new Random();    //Random antikeimeno gia thn epilogh tuxaias eikonas
                
                //Eisagwgh eikonas sto stream gia diavasma
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("tile00" + r.nextInt(4) + ".png"));
                byte buffer[] = new byte[1024*1024];
                bis.read(buffer);
                
                //domh epanalhpshs pou dhmiourgei gegonota kai ta stelnei ston ka8e client
                for (ClientInt cl : clients){
                    Date d = new Date();
                    cl.sendEvent(d.toString(), buffer);
                }
                
                //ka8usterhsh tou thread
                Thread.sleep(r.nextInt(3000)+2000);
            }
            

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
}
