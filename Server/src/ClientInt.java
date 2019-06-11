//Katsilidis Nikolaos 321/2014081
import java.rmi.Remote;
import java.rmi.RemoteException;

//Dhmiourgia Interface gia ton client kai orismos sunarthshs sendEvent


public interface ClientInt extends Remote {

   public void sendEvent(String imerominia, byte[] eikona) throws RemoteException;

   
}
