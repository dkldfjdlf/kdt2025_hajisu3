package hajisu.hjisu;

public class Student5 {
    private int id;
    private String name;
    private int korean;
    private int math;
    private int english;

    public Student5(int id, String name, int korean, int math, int english) {
        this.id = id;
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }

    public int getId() {
        return id;
    }

    public double getAverage() {
        return (korean + math + english) / 3.0;
    }

    public int getKorean() {
        return korean;
    }

    public String getName() {
        return name;
    }
}
