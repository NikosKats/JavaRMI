//Katsilidis Nikolaos 321/2014081


import java.rmi.Remote;
import java.rmi.RemoteException;

//Dhmiourgia Interface gia ton server kai orismos sunarthshs returnSub kai returnUnsub gia thn eggrafh kai apeggrafh tou xrhsth


public interface ServerInt extends Remote{

    

    public void returnSub(ClientInt client) throws RemoteException;

    public void returnUnsub(ClientInt client) throws RemoteException;
}
