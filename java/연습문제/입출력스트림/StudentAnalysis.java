package hajisu.hjisu;

import java.io.*;
import java.util.*;

public class StudentAnalysis {
    public static void main(String[] args) {
        List<Student5> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 줄 내용 확인
                System.out.println("읽은 줄: " + line);

                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("잘못된 형식입니다: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int korean = Integer.parseInt(parts[2].trim());
                int math = Integer.parseInt(parts[3].trim());
                int english = Integer.parseInt(parts[4].trim());

                Student5 student = new Student5(id, name, korean, math, english);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류 발생!");
            e.printStackTrace();
        }

        if (students.isEmpty()) {
            System.out.println("학생 데이터가 없습니다.");
            return;
        }

        // 최고 평균을 받은 학생 찾기
        Student5 topStudent = null;
        double maxAvg = 0.0;
        int totalKorean = 0;

        for (Student5 s : students) {
            double avg = s.getAverage();
            if (avg > maxAvg) {
                maxAvg = avg;
                topStudent = s;
            }
            totalKorean += s.getKorean();
        }

        System.out.println("최고 평균을 받은 학생: " + topStudent.getName());
        System.out.printf("국어 점수의 전체 평균: %.2f\n", totalKorean / (double) students.size());
    }
}