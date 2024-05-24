package task3.t3;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
        }
        return result;
    }
}