package serialization;

import java.io.Serializable;
import java.util.Objects;

public class Worker implements Serializable {
    private static final long serialVersionUID = -2960246283456898362L;
    private String Name;
    private int age;
    private transient static int id = 2;
    private Mama mama;

    public Worker(String name, int age, Mama mama) {
        Name = name;
        this.age = age;
        this.mama = mama;
    }

    public Worker(String name, int age) {
        Name = name;
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Worker.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (age != worker.age) return false;
        if (!Name.equals(worker.Name)) return false;
        return mama != null ? mama.equals(worker.mama) : worker.mama == null;
    }

    @Override
    //не должно быть transient полей
    public int hashCode() {
        int result = Name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (mama != null ? mama.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", mama=" + mama +
                '}';
    }
}
