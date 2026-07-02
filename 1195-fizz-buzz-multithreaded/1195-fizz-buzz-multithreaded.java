class FizzBuzz {
    private int n;
    int i ;
    Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
    public FizzBuzz(int n) {
        i = 1;
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try{
            while(i <= n){
                while(i <= n &&(i % 3 != 0 || i % 5 == 0)){
                    cond.await();
                }
                if(i > n) break;
                printFizz.run();
                i++;
                cond.signalAll();
            }
            
        }
        finally{
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try{
            while(i <= n){
                while(i <= n &&(i % 3 == 0 || i % 5 != 0)){
                    cond.await();
                }
                if(i > n) break;
                printBuzz.run();
                i++;
                cond.signalAll();
            }
            
        }
        finally{
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try{
            while(i <= n){
                while(i <= n &&(i % 3 != 0 || i % 5 != 0)){
                    cond.await();
                }
                if(i > n) break;
                printFizzBuzz.run();
                i++;
                cond.signalAll();
            }
            
        }
        finally{
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try{
            while(i <= n){
                while(i <= n &&(i % 3 == 0 || i % 5 == 0)){
                    cond.await();
                }
                if(i > n) break;
                printNumber.accept(i);
                i++;
                cond.signalAll();
            }

        }
        finally{
            lock.unlock();
        }
    }
}