package task3.t3;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private Map<String, TreeType> treeTypes = new HashMap<>();

    private void checkStrings(String str1, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        boolean hasNull = ((str1 == null) || (str2 == null) || (str3 == null));
        if (hasNull) {
            throw new NullPointerException("At least one of the strings is null. " + sb.toString());
        } else {
            System.out.println("None of the strings are null. " + sb.toString());
        }
    }

    public TreeType getTreeType(String name, String color, String texture) {

        try {
            checkStrings(name, color, texture);
        } catch (NullPointerException e){
            e.printStackTrace();

            System.out.println(String.format("Name: %s, Color: %s, Texture: %s", name, color, texture) + "\n");
        }
        String key = name + "-" + color + "-" + texture;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
        }
        return result;
    }
}