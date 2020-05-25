class CountdownEvent{
    private int count;
    private Lock lock;
    private ConditionVariable cv;
    CountdownEvent (int count) {
        this.count = count;
        this.lock = new Lock();
        this.cv = new ConditionVariable(this.lock);
    }

    void Increment () {
        lock.acquire();
        this.count++;
        lock.release();
    }

    void Decrement () {
        lock.acquire();
        if (this.count == 0) {
            lock.release();
            return;
        }
        this.count--;
        if (this.count == 0) {
            this.cv.broadcast();
        }
        lock.release();
    }

    void Wait () {
        lock.acquire();
        if (count == 0) {
            return;
        }
        else {
            cv.wait();
        }
        lock.release();
    }

}
