import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class semaphore {
    protected int value = 0 ;
    int i=1;
    int v;

    protected semaphore() { value = 0 ; }
    protected semaphore(int initial) { value = initial ;

    v = initial;}

    public synchronized void P(String name , String type) {

        value-- ;
        if (value < 0)
            try {
                File file = new File("out.txt");
                FileWriter fr = new FileWriter(file , true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write("(" + name + ")" + "(" + type + ")" + " arrived and waiting !!!");
                System.out.println("(" + name + ")" + "(" + type + ")" + " arrived and waiting !!!");
                br.close();
                fr.close();
                wait();
            } catch (InterruptedException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public synchronized void V(String name) {
                 value++;
                  if (value <= 0) notify();
    }

}
