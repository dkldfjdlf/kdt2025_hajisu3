package hajisu;

public class Student implements Comparable<Student> {
    private String hakbun;
    private String name;
    private int korean, eng, math;

    public Student(String hakbun, String name, int korean, int eng, int math) {
        this.hakbun = hakbun;  // 오타 수정: jakbun → hakbun
        this.name = name;
        this.korean = korean;
        this.eng = eng;
        this.math = math;
    }

    public int getTotal() {
        return korean + eng + math;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", hakbun, name, getTotal());
    }

    @Override
    public int compareTo(Student o) {
        // 총점 기준 내림차순 정렬
        return Integer.compare(o.getTotal(), this.getTotal());
    }
}

