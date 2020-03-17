
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static int N;
    public int TC;
    public String TCLines;
    static Router router;
    ArrayList<Device> devices = new ArrayList<Device>();



    public Network() {
    }

    public void addConnection() throws IOException {
        Device device;
        String[] arr;

        Scanner in = new Scanner(System.in);
        Scanner y = new Scanner(System.in);

        router = new Router(N);

        System.out.println("What is number of WI-FI Connections?");
        N  = in.nextInt();
        System.out.println("What is number of devices Clients want to connect?");
        TC = in.nextInt();

        for(int i=0; i<TC; i++){
           TCLines =  y.nextLine();
           arr = TCLines.split(" ");
           device = new Device();
           device.name = arr[0];
           device.type = arr[1];
           devices.add(device);
        }


        for (int i = 0; i < devices.size(); i++) {
            devices.get(i).start();

        }

    }
}
