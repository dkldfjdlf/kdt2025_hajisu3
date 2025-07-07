package hajisu;

public class MusicRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("음악을 재생합니다.");
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
