package hajisu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Population> populationList = new ArrayList<>();

        String[] data = {
            "금천구,11110,201907,228755,171426,2.44,319062,118352",
            "서대문구,11290,201607,153780,186744,2.12,75614,116393",
            "양천구,11740,201804,594315,61091,2.22,192817,307237",
            "은평구,11200,202004,345156,168865,2.13,229690,204108",
            "마포구,11260,201902,394788,168482,2.52,61714,146951",
            "도봉구,11350,201704,150732,61069,2.39,60735,199831",
            "강북구,11410,202008,404501,174263,2.25,184053,172995",
            "용산구,11620,201407,433658,173943,1.85,252383,198754",
            "관악구,11140,201710,308087,180747,2.01,192923,245902",
            "동대문구,11470,201806,447667,162606,2.49,215440,64221",
            "양천구,11200,201504,559697,109708,2.36,237588,75262",
            "광진구,11260,201704,379339,126579,2.34,110605,174332",
            "관악구,11440,201906,431423,177247,2.65,233214,192414",
            "서초구,11500,201712,234627,144805,2.46,172446,332802",
            "강남구,11380,201712,451253,63851,2.62,320480,177158",
            "강남구,11305,201904,542576,173142,2.54,60139,243251",
            "종로구,11470,201505,442119,248840,2.19,157312,61327",
            "광진구,11350,202001,226161,159500,2.08,232838,158869",
            "구로구,11410,201504,126270,172505,2.26,74025,284150",
            "노원구,11170,201412,233017,243049,2.4,117497,298131",
            "중랑구,11470,201807,421579,133458,1.99,206423,182741",
            "도봉구,11380,201408,483473,167301,2.03,225186,204424",
            "성동구,11545,201805,300410,269220,2.64,74662,197070",
            "구로구,11320,201505,305785,136393,2.62,187960,177515",
            "서초구,11440,201704,405271,135147,2.11,150937,148298",
            "강서구,11410,201712,378199,185610,2.46,157743,78354",
            "금천구,11440,202007,218929,259692,2.34,255912,285095",
            "노원구,11710,201409,373252,138984,2.23,258407,204359",
            "은평구,11170,201404,149524,229712,2.57,167155,162829",
            "노원구,11680,201708,478019,100534,2.18,278171,61187"
        };

        // 데이터 파싱하여 리스트에 저장
        for (String line : data) {
            String[] tokens = line.split(",");
            String guName = tokens[0];
            int guCode = Integer.parseInt(tokens[1]);
            String yearMonth = tokens[2];
            int totalPopulation = Integer.parseInt(tokens[3]);
            int householdCount = Integer.parseInt(tokens[4]);
            double populationPerHousehold = Double.parseDouble(tokens[5]);
            int malePopulation = Integer.parseInt(tokens[6]);
            int femalePopulation = Integer.parseInt(tokens[7]);

            populationList.add(new Population(guName, guCode, yearMonth,
                    totalPopulation, householdCount,
                    populationPerHousehold, malePopulation, femalePopulation));
        }

        // 남자 인구 가장 적은 구 찾기
        Population minMale = null;
        // 여자 인구 가장 적은 구 찾기
        Population minFemale = null;

        for (Population p : populationList) {
            if (minMale == null || p.malePopulation < minMale.malePopulation) {
                minMale = p;
            }
            if (minFemale == null || p.femalePopulation < minFemale.femalePopulation) {
                minFemale = p;
            }
        }

        System.out.println("남자인구가 가장 적은 구: " + minMale.guName + ", 인구수: " + minMale.malePopulation);
        System.out.println("여자인구가 가장 적은 구: " + minFemale.guName + ", 인구수: " + minFemale.femalePopulation);
    }
}