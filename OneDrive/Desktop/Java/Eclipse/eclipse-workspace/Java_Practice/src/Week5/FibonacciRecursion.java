package Week5;

public class FibonacciRecursion {

    // Basic recursive Fibonacci (tree recursion)
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Head recursion - the recursive call happens before the work
    public static void printHeadRecursion(int n) {
        if (n == 0) {
            return;
        }
        printHeadRecursion(n - 1); // recursive call first
        System.out.print(n + " "); // work after the call
    }

    // Tail recursion - the recursive call happens after the work
    public static void printTailRecursion(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " "); // work first
        printTailRecursion(n - 1); // recursive call last
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));

        System.out.print("Head recursion (1..n): ");
        printHeadRecursion(5);
        System.out.println();

        System.out.print("Tail recursion (n..1): ");
        printTailRecursion(5);
        System.out.println();
    }
}
