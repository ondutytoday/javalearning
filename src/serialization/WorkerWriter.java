package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerWriter {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Vasya", 52, new Mama ("Tanya"));
        Worker worker2 = new Worker ("Katya", 30, new Mama ("Lena"));
        List<Worker> workers = new ArrayList<>(Arrays.asList(
                worker1, worker2, new Worker("Misha", 45)));
        Worker.setId(5);
        //если бы worker был бы несериализован, то он как и транзиентный выдавал бы ноль или нулл
        Worker director = new Director("Kozel", 13, new Mama ("Koza"), "poshel ty v gopu director");
        try (FileOutputStream out = new FileOutputStream("worker.bin");
             ObjectOutputStream oos = new ObjectOutputStream(out);) {
            System.out.println(Worker.getId());
            oos.writeObject(workers);
            oos.writeObject(director);

/*            oos.writeInt(workers.size());
            for (Worker w:
                 workers) {
                oos.writeObject(w);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
