package hajisu.hajisu2;

public class AnonymouExample {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();

        anony.field.start(); // 디자인을 합니다.
        anony.method1(); // 개발을 합니다.

        anony.method2(new Worker(){
            @Override
            public void start() {
                System.out.println("테스트를 합니다");
            }
        });
    }
}
