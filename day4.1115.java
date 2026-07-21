import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();          // Wait until foo is allowed
            printFoo.run();         // Print "foo"
            bar.release();          // Allow bar thread
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();          // Wait until bar is allowed
            printBar.run();         // Print "bar"
            foo.release();          // Allow foo thread
        }
    }
}
