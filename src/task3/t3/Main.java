package task3.t3;

public class Main {

    public void run(){
        TreeType oakType = new TreeType("Oak", "Green", "Rough");
        TreeType pineType = new TreeType("Pine", "Green", "Smooth");
        TreeType pineType111 = new TreeType(null, "", "");

        Tree tree1 = new Tree(10, 20, oakType);
        Tree tree2 = new Tree(15, 25, oakType);
        Tree tree3 = new Tree(30, 40, pineType111);
        new TreeFactory().getTreeType("12", "1", null);
        new TreeFactory().getTreeType("12", null, "233");
        new TreeFactory().getTreeType(null, "1", "23");
        tree1.draw();
        tree2.draw();
        tree3.draw();

    }
    public static void main(String[] args) {
        new Main().run();
    }
}