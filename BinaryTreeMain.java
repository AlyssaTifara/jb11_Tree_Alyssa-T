import java.util.Scanner;
public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);
        bt.addRecursive(11); //rekursif

        bt.traversePre0rder(bt.root);
        System.out.println("");
        bt.traverseIn0rder(bt.root);
        System.out.println("");
        bt.traversePost0rder(bt.root);
        System.out.println("");
        System.out.println("Find "+bt.find(5));
        bt.delete(8);
        bt.traversePre0rder(bt.root);
        System.out.println("");

        int minValue = bt.findMin(); //nilai terkecil
        int maxValue = bt.findMax(); //nilai terbesar
        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);
    }
}