//Katsilidis Nikolaos 321/2014081

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Client extends UnicastRemoteObject implements ClientInt {

    Client() throws RemoteException {
        super();
    }

    static JLabel image;
    static JTextArea textArea;

    public static void main(String[] args) {
        try {

            //Sundesh me RMI mesw tou akolou8ou url
            String url = "//localhost/zoo";

            //Dhmiourgia RMI interface
            ServerInt si = (ServerInt) Naming.lookup(url);

            //Dhmiourgia antikeimenou client
            Client c1 = new Client();

            //eggrafh you pelath
            si.returnSub(c1);

        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        //Dhmiourgia grafikou kai ulopoihsh twn katallhlwn components
        JButton btn;

        JFrame fr = new JFrame();

        fr.setVisible(true);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //fr.setLocationRelativeTo(null);

        Container pane = fr.getContentPane();

        GridLayout grid = new GridLayout(3, 1);

        pane.setLayout(grid);

        fr.setLayout(grid);
        textArea = new JTextArea();
        image = new JLabel();
        btn = new JButton("Exit");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    //apeggrafh you pelath
                    si.returnUnsub(c1);
                    System.exit(0);
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });

        fr.add(textArea);
        fr.add(image);
        fr.add(btn);

        fr.setContentPane(pane);
        fr.setSize(1000, 700);

    }

    //Ylopoihsh ths sunarthshs sendEvent pou vrisketai sto Client Interface
    @Override
    public void sendEvent(String imerominia, byte[] eikona) throws RemoteException {
        try {

            textArea.append("A new event captured at " + imerominia + "\n");   //Eisagwgh ths hmeromhnias tou upologisth

            //Dhmiourgia stream gia thn metafora ths eikonas apo ton server ston client
            InputStream in = new ByteArrayInputStream(eikona);
            BufferedImage bImageFromConvert = ImageIO.read(in);

            image.setIcon(new ImageIcon(bImageFromConvert));    //Eisagwgh ths eikonas sto grafiko

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
