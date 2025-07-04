package hajisu;

import java.util.*;

public class SumPositives {
    private Vector<Integer> v= new Vector<Integer>();
    public void read() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("정수입력(0이면 입력 끝) >> ");
       while (true) {
        int num = scanner.nextInt();
        if (num == 0) break;
        v.add(num);
       }
    }

    public void changeToZero() {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) < 0) {
                v.set(i, 0); // 음수는 0으로 변경
            }
        }
    }

    public void showAll() {
        for (int i = 0; i <v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }

    public int add() {
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) > 0) {
                sum += v.get(i);
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        SumPositives sp = new SumPositives();
        sp.read();
        sp.changeToZero();
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll();
        System.out.println("양수들의 합은 " + sp.add());
    }
    
}
