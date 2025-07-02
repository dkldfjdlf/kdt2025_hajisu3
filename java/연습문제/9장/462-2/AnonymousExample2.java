package hajisu.hajisu2;

public class AnonymousExample2 {
    public static void main(String[] args) {
        Anonymous2 anony = new Anonymous2();

        anony.field.run(); // 자전거
        anony.method1(); // 승용차
        anony.method2(new Vehicle() {
            @Override
            public void run() {
                System.out.println("트럭이 달립니다.");
            }
        });
}
}
