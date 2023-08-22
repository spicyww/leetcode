import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws IOException {

        try {
            //通过反射机制，获取Class,通过Class来实例化对象
            Class<?> c = Class.forName("Room");
            //newInstance方法会调用无参构造方法来完成对象创建
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        FileReader reader = new FileReader("E:\\java project\\leetcode\\javase\\info.properties");
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();
        String name = pro.getProperty("name");
        try {
            Class b = Class.forName(name);
            Object o = b.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
