package hajisu;

import java.util.Scanner;
import java.util.Vector;

public class MinValueFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();

        System.out.print("정수입력(-1이면 입력 끝) >> ");

        while (true) {
            int input = scanner.nextInt();
            if (input == -1) break;
            if (input > 0) {
                numbers.add(input);
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("입력된 양의 정수가 없습니다.");
        } else {
            int min = numbers.get(0);
            for (int num: numbers) {
                if (num < min) min = num;
            }
            System.out.println("제일 작은수 " + min);
        }

        scanner.close();
    }
    
}
