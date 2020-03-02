package eclipscode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;




class SerRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("D:\\code\\demo.data");
        JavaClassSerializable js = new JavaClassSerializable(1, 1d, "Java", "Transient");  //static double = 1d
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        oos.writeObject(js);		//serialization s
        System.out.println(js);

        JavaClassSerializable.d = 5d;	//changing the value of static variable d = 5d

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        JavaClassSerializable recover = (JavaClassSerializable) ois.readObject();	//deserialization

        System.out.println(recover);	//static double d = 5d

        oos.close();
        ois.close();
    }
}
