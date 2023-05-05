package hw_12;

public class Main {
    public static void main(String[] args) {
        HashTableChaining<String, Integer> hashTableChaining = new HashTableChaining<>();
        hashTableChaining.put("key1", 10);
        System.out.println(hashTableChaining.get("key1"));
        System.out.println(hashTableChaining.containsKey("key1"));

    }
}
