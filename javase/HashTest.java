import java.io.*;
import java.util.*;

public class HashTest {
//    Map<Integer, String> ha = new HashMap<>();
public static void main(String[] args) throws IOException, ClassNotFoundException {
    HashSet<String> se = new HashSet<>();
    se.add("1");
    se.add("2");
    Iterator<String> it = se.iterator();
    while (it.hasNext()){
        System.out.println(it.next());
    }
    for (String s:
         se) {
        System.out.println(s);
    }

    TreeSet<Integer> tr = new TreeSet<>();
    tr.add(100);
    tr.add(1);
    tr.add(10);
    Iterator<Integer> it_tr = tr.iterator();
    while (it_tr.hasNext()){
//        Integer i = it.next();
        System.out.println(it_tr.next());
    }
    for(Integer x : tr){
        System.out.println(x);
    }

    Map<Integer,String> map = new HashMap<>();
    map.put(1,"a");
    map.put(2,"b");
    map.put(3,"c");

    System.out.println(map.size());
    // 获取全部的key并进行遍历
    Set<Integer> keys = map.keySet();
    for(Integer key : keys){
        System.out.println(map.get(key));
    }
    // 将map集合转换成set集合，set集合中的每个元素都是Node
    Set<Map.Entry<Integer,String>> nodes = map.entrySet();
    for(Map.Entry<Integer, String> node : nodes){
        System.out.println(node.getValue());
    }

    // 序列化操作
    Hotel ho = new Hotel();
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hotel1"));
    //序列化 对象
    oos.writeObject(ho);
    //刷新
    oos.flush();
    //关闭
    oos.close();

    //反序列化操作
    InputStream fileInputStream = new FileInputStream("hotel1");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Hotel hotel = (Hotel) objectInputStream.readObject();
    hotel.getRoom(1,1);
}
}
