package timus;

import java.util.Scanner;

public class task_2100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = 2;

        for (int i = 0; i < n; i++) {
            String response = in.next();
            if (response.endsWith("+one")) {
                q += 2;
            } else {
                q++;
            }
        }

        int cost = (q == 13) ? (q + 1) * 100 : q * 100;

        System.out.println(cost);
    }
}
