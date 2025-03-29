package lr3.task1;

public class Example5 {
    public static void main(String[] args) {
        System.out.println("\nЧисло Фибоначчи для 5 = " + fib(5, 0));
    }

    public static int fib(int n, int m) {
        String indent = "  ".repeat(m);
        System.out.println(indent + "Вызов fibonacci(" + n + ")");

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 2, m + 1) + fib(n - 1, m + 1);
        }
    }
}
