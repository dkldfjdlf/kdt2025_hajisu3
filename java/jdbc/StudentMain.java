package hajisu;

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            System.out.println("1. 전체 학생 목록 출력");
            for (Student s : dao.getAllStudents()) {
                System.out.println(s);
            }

            System.out.println("\n2. 오짱구 전화번호 010-6666-7878로 변경");
            dao.updatePhone("오짱구", "010-6666-7878");

            System.out.println("\n3. 학생 추가 (유재석, 나검사)");
            dao.insertStudent(new Student(200, "유재석", "010-3626-1111", "rhu@gmail.com"));
            dao.insertStudent(new Student(300, "나검사", "010-8888-9999", "naking@naver.com"));

            System.out.println("\n4. 이순신 학생 삭제");
            dao.deleteStudent("이순신");

            System.out.println("\n5. 전화번호 010-3626-1111 학생 정보 출력");
            Student s = dao.findByPhone("010-3626-1111");
            if (s != null) {
                System.out.println(s);
            } else {
                System.out.println("해당 전화번호 학생이 없습니다.");
            }

            System.out.println("\n최종 학생 목록:");
            for (Student st : dao.getAllStudents()) {
                System.out.println(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
