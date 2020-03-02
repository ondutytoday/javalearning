package serialization;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerReader {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("worker.bin");
             ObjectInputStream ois = new ObjectInputStream(in);) {

            List<Worker> w = (ArrayList) ois.readObject();
            Worker d = (Director) ois.readObject();
            System.out.println(w.toString());
            System.out.println(d);
            System.out.println(Worker.getId());

/*
            int workersCount = ois.readInt();
            for (int i = 0; i < workersCount; i++) {
                Worker w = (Worker) ois.readObject();
                System.out.println(w);
            }
*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
