package lr3;

import java.util.Scanner;

public class task8 {

    public static Node createHead() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        Node head = null;
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент: ");
            int value = scanner.nextInt();
            head = new Node(value, head);
        }
        return head;
    }

    public static Node createTail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        Node head = null;
        Node tail = null;
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент: ");
            int value = scanner.nextInt();
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    public static String toString(Node head) {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.value).append(" ");
            current = current.next;
        }
        return result.toString().trim();
    }

    public static Node AddFirst(Node head, int value) {
        return new Node(value, head);
    }

    public static Node AddLast(Node head, int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node Insert(Node head, int index, int value) {
        if (index == 0) {
            return AddFirst(head, value);
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return head;
        }
        Node newNode = new Node(value, current.next);
        current.next = newNode;
        return head;
    }

    public static Node RemoveFirst(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static Node RemoveLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }

    public static Node Remove(Node head, int index) {
        if (index == 0) {
            return RemoveFirst(head);
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            return head;
        }
        current.next = current.next.next;
        return head;
    }

    public static Node createHeadRec() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        return createHeadRecHelper(size, scanner);
    }

    private static Node createHeadRecHelper(int size, Scanner scanner) {
        if (size == 0) {
            return null;
        }
        System.out.print("Введите элемент: ");
        int value = scanner.nextInt();
        return new Node(value, createHeadRecHelper(size - 1, scanner));
    }

    public static Node createTailRec() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        return createTailRecHelper(size, scanner);
    }

    private static Node createTailRecHelper(int size, Scanner scanner) {
        if (size == 0) {
            return null;
        }
        System.out.print("Введите элемент: ");
        int value = scanner.nextInt();
        Node head = createTailRecHelper(size - 1, scanner);
        return AddLast(head, value);
    }

    public static String toStringRec(Node head) {
        if (head == null) {
            return "";
        }
        return head.value + " " + toStringRec(head.next).trim();
    }
}
