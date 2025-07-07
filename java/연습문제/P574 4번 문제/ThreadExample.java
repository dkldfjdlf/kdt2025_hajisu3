package hajisu;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();

        // (3) 메인 스레드 종료 시 함께 종료되도록 설정
        thread.setDaemon(true);

        thread.start();

        try {
            Thread.sleep(3000);  // 메인 스레드가 3초 동안 실행됨
        } catch (InterruptedException e) {}
        
        System.out.println("메인 스레드 종료");
    }
}
