package task3.t3;

public class Main {

    public void run(){
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Green", "Smooth");

        Tree tree1 = new Tree(10, 20, oakType);
        Tree tree2 = new Tree(15, 25, oakType);
        Tree tree3 = new Tree(30, 40, pineType);

        tree1.draw();
        tree2.draw();
        tree3.draw();

    }
    public static void main(String[] args) {
        new Main().run();
    }
}