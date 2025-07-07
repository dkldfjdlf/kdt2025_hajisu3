package hajisu;

public class ThreadExample {
    public static void main(String[] args) {
        // (1) MovieThread는 Thread를 상속한 클래스 → 직접 start 가능
        Thread thread1 = new MovieThread();
        thread1.start();

        // (2) MusicRunnable은 Runnable을 구현한 클래스 → Thread에 넣어서 실행
        Runnable music = new MusicRunnable();
        Thread thread2 = new Thread(music);
        thread2.start();
    }
}
