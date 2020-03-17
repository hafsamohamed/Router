import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Device extends Thread  {
    public void connect() throws InterruptedException, IOException {

        Network.router.occupy(name,type);
    }
    public void activity() throws InterruptedException, IOException {
        File file = new File("out.txt");
        FileWriter fr = new FileWriter(file , true);
        BufferedWriter br = new BufferedWriter(fr);

        br.write("(" + name + ")"  + "(" +type +")"+ " : performs online activity...");
        System.out.println("(" + name + ")"  + "(" +type +")"+ " : performs online activity...");
        Thread.sleep(2000);

        br.close();
        fr.close();

    }
    public void logout() throws InterruptedException, IOException {
        Network.router.release(name ,type);
    }

    public void run(){

        try {
            connect();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            activity();
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logout();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String name;
    public String type;
}
