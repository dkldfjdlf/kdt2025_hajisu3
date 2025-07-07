package exam1;

public class Student {
    private String hakbun;
    private String name;
    private int korean, eng, math;

    public Student(String hakbun, String name, int korean, int eng, int math) {
        this.hakbun = hakbun;
        this.name = name;
        this.korean = korean;
        this.eng = eng;
        this.math = math;
    }

    public String getHakbun() { return hakbun; }
    public String getName() { return name; }
    public int getKorean() { return korean; }
    public int getEng() { return eng; }
    public int getMath() { return math; }

    public double getAverage() {
        return getTotal() / 3.0; // 소수점까지 계산되도록 3.0으로 나눔
    }

    public int getTotal() {
        return korean + eng + math;
    }
}