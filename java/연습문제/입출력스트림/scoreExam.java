package exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class scoreExam {
    static ArrayList<Student> students = new ArrayList<>();

    public static void readFromFile() throws Exception {
        Reader reader = new FileReader("student.txt");
        BufferedReader inFile = new BufferedReader(reader);
        while (true) {
            String sLine = null;
            if ((sLine = inFile.readLine()) == null)
                break;
            StringTokenizer st = new StringTokenizer(sLine, ",");
            if (st.countTokens() != 5)
                continue;

            String hakbun = st.nextToken().trim();
            String name = st.nextToken().trim();
            int kor = Integer.parseInt(st.nextToken().trim());
            int eng = Integer.parseInt(st.nextToken().trim());
            int math = Integer.parseInt(st.nextToken().trim());

            students.add(new Student(hakbun, name, kor, eng, math));
        }
        inFile.close();
    }

    public static void main(String[] args) {
        try {
            readFromFile();
        } catch (Exception e) {
            System.out.println("파일 읽기 중 오류 발생!");
            e.printStackTrace();
            return;
        }

        if (students.isEmpty()) {
            System.out.println("학생 데이터가 없습니다.");
            return;
        }

        // 최고 평균 학생 찾기 및 국어 점수 총합 계산
        Student topStudent = null;
        double maxAverage = 0.0;
        int totalKorean = 0;

        for (Student s : students) {
            double avg = s.getAverage();
            if (avg > maxAverage) {
                maxAverage = avg;
                topStudent = s;
            }
            totalKorean += s.getKorean();
        }

        System.out.println("최고 평균을 받은 학생: " + topStudent.getName());
        System.out.printf("국어 점수의 전체 평균: %.2f\n", totalKorean / (double) students.size());
    }
}

