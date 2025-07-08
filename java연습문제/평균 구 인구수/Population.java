package hajisu;

public class Population {
    String guName;                 // 자치구 이름
    int guCode;                    // 자치구 코드
    String yearMonth;             // 년월
    int totalPopulation;          // 총인구수
    int householdCount;           // 세대 수
    double populationPerHousehold; // 세대당 인구
    int malePopulation;           // 남자인구수
    int femalePopulation;         // 여자인구수

    public Population(String guName, int guCode, String yearMonth,
                      int totalPopulation, int householdCount,
                      double populationPerHousehold,
                      int malePopulation, int femalePopulation) {
        this.guName = guName;
        this.guCode = guCode;
        this.yearMonth = yearMonth;
        this.totalPopulation = totalPopulation;
        this.householdCount = householdCount;
        this.populationPerHousehold = populationPerHousehold;
        this.malePopulation = malePopulation;
        this.femalePopulation = femalePopulation;
    }
}
