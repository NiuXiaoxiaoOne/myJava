package enumdemo;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author xiaolei
 * 研究EnumMap
 */
public class EnumMapDemo {
    public static void main(String[] args) {
        Map<Color3,String> desc = null;
        desc = new EnumMap<Color3, String>(Color3.class);
        desc.put(Color3.RED, "red");
        desc.put(Color3.GREEN, "green");
        desc.put(Color3.BLUE, "blue");
        System.out.println("===== Start Content for Color3 =====");
        for (Color3 c : Color3.values()) {
            System.out.println(c.name() + " --> " + desc.get(c));
        }
        System.out.println("===== Start KeyValues for Color3 =====");
        for (Color3 c : desc.keySet()) {
            System.out.print(c.name() + " ");
        }
        System.out.println();
        System.out.println("===== Start Content for desc =====");
        for (String s : desc.values()) {
            System.out.println(s + " ");
        }
    }
}
