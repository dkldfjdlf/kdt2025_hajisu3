package hajisu;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("100", "홍길동", 90, 77, 88));
        list.add(new Student("101", "이순신", 88, 94, 90));
        list.add(new Student("102", "타이거", 78, 88, 99));
        list.add(new Student("103", "라이온", 85, 90, 100));

        Collections.sort(list); // compareTo 기준으로 정렬

        for (Student s : list) {
            System.out.println(s);
        }
    }
}