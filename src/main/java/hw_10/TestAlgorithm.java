package hw_10;

public class TestAlgorithm {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("30 найдено? " + bst.search(30)); // true
        System.out.println("10 найдено? " + bst.search(10)); // false

        bst.remove(20);
        bst.remove(40);
        bst.remove(60);

        System.out.println("20 найдено? " + bst.search(20)); // false
        System.out.println("40 найдено? " + bst.search(40)); // false
        System.out.println("60 найдено? " + bst.search(60)); // false
    }
}
