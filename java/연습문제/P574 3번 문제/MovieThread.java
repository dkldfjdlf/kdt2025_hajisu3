package hajisu;

public class MovieThread extends Thread {
    @Override 
    public void run() {
        while (true) {
            System.out.println("동영상을 재생합니다.");

            try {
                Thread.sleep(500);  // 잠깐 대기
            } catch (InterruptedException e) {
                // interrupt 중에 sleep 깨졌을 때 안전하게 종료
                System.out.println("인터럽트 감지됨. 스레드 종료.");
                break;
            }

            // (5) interrupt 신호 받았는지 확인
            if (Thread.interrupted()) break;
        }
    }
}
