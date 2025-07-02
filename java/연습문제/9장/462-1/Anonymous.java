package hajisu.hajisu2;

public class Anonymous {
    // 필드에 익명 자식 객체 대입
    Worker field = new Worker() {
        @Override
        public void start() {
            System.out.println("디자인을 합니다.");
        }
    };

    void method1() {
        Worker localVar = new Worker() {
            @Override
            public void start() {
                System.out.println("개발을 합니다.");
            }
        };

        localVar.start();
    }

    void method2(Worker worker) {
        worker.start();
    }
}

    

