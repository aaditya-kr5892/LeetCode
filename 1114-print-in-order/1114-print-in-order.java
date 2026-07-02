class Foo {
    private Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    int turn ;
    public Foo() {
        turn = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            printFirst.run();
            turn = 1;
            cond.signalAll();
        }finally{
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(turn != 1){
                cond.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            turn = 2;
            cond.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(turn != 2){
                cond.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }finally{
            lock.unlock();
        }
    }
}