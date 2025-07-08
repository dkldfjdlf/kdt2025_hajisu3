package hajisu;

public class Population {
    String guName;
    int guCode;
    String yearMonth;
    int totalPopulation;
    int householdCount;
    double populationPerHousehold;
    int malePopulation;
    int femalePopulation;

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

    @Override
    public String toString() {
        return guName + " [" + yearMonth + "] 인구: " + totalPopulation + "명 (남: " + malePopulation + ", 여: " + femalePopulation + ")";
    }
}