import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Router {

    semaphore se;
    public int i =1;

    public Router(int n) {
        se = new semaphore(n);

    }

    public void print(){

    }
    public void occupy(String name , String type) throws IOException {

        File file = new File("out.txt");
        FileWriter fr = new FileWriter(file , true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write("(" + name + ")" + "(" + type + ")" + "arrived");

        System.out.println("(" + name + ")" + "(" + type + ")" + "arrived");
        se.P(name , type);
        br.write("(" + name + ")" + "(" + type + ")" + "  Occupied");
        System.out.println("(" + name + ")" + "(" + type + ")" + "  Occupied");
        br.close();
        fr.close();


    }
    public void release(String name , String type) throws IOException {
        File file = new File("out.txt");
        FileWriter fr = new FileWriter(file , true);
        BufferedWriter br = new BufferedWriter(fr);
        se.V(name);
        System.out.println("(" + name + ")" + "(" + type + ")" + "  logged");
        br.write("(" + name + ")" + "(" + type + ")"+ "  logged");
        br.close();
        fr.close();
    }


}




 /*
package com.mycompany.ass2os;

        import java.util.ArrayList;
        import java.util.concurrent.Semaphore;


public class Router extends Thread {

    ArrayList<Device> listOfConnection = new ArrayList();
    int limit;
    semaphore sem  ;




    Router() {
        sem = new semaphore(Network.limit);
    }





    public void OccupyConnection(String nameDevice){
        System.out.println(nameDevice + "arrived");
        sem.P(nameDevice);
        System.out.println(nameDevice + "Occupied");


    }

    public void relaseConnection(){
        sem.V();
    }

}
*/
