package Week1;

import java.util.ArrayList;

/*
 * Week 3 - General Question 4
 * Practice core ArrayList operations: adding, retrieving, updating,
 * removing, and verifying elements.
 */
public class ArrayListOperations {

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        // 1. ADDING elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");
        System.out.println("After adding elements: " + fruits);

        // Adding at a specific index
        fruits.add(1, "Orange");
        System.out.println("After adding \"Orange\" at index 1: " + fruits);

        // 2. RETRIEVING elements
        String firstFruit = fruits.get(0);
        System.out.println("\nElement at index 0: " + firstFruit);
        System.out.println("Current size of list: " + fruits.size());

        // 3. UPDATING elements
        fruits.set(2, "Blueberry"); // replaces element at index 2
        System.out.println("\nAfter updating index 2 to \"Blueberry\": " + fruits);

        // 4. REMOVING elements
        fruits.remove("Grapes");     // remove by value
        System.out.println("\nAfter removing \"Grapes\": " + fruits);

        fruits.remove(0);            // remove by index
        System.out.println("After removing element at index 0: " + fruits);

        // 5. VERIFYING elements
        boolean hasMango = fruits.contains("Blueberry");
        System.out.println("\nDoes the list contain \"Blueberry\"? " + hasMango);

        int index = fruits.indexOf("Banana");
        System.out.println("Index of \"Banana\": " + index);

        boolean isEmpty = fruits.isEmpty();
        System.out.println("Is the list empty? " + isEmpty);

        // Iterating through the list
        System.out.print("\nFinal list contents: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}
