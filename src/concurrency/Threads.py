import threading

"""
The first way to create a thread is to specify a function and a target
the args tuple is the list of arguments for the function
"""
def fun1(a):
      print(a)
# If you want to pass only one argument to the function, then you have to put that comma at the end
thread1 = threading.Thread(target = fun1, args = (12,))
thread1.start()

"""
The second way to create a thread is to inherit the threading.Thread class and ]
override run method
"""
class MyThread(threading.Thread):
    # You can add extra args to run method
    def run(self, message):
        print("hello {}".format(message))

# The outpyt will be hello 0 - 999
t = MyThread()
for i in range(1000):
    t.run(i)

"""
Basic lock. Will throw exception if try to release() when you don't have the lock.
Will block if you try to acquire() and someone else has the lock
"""

#Implementation with try, finally block. Remember to release lock in the finally block
class mythread(threading.Thread):
    def __init__(self):
        self.lock = threading.Lock()
    def run(self):
        try:
            self.lock.acquire()
            print(threading.current_thread)
            time.sleep(2)
        finally:
            self.lock.release()

"""
Using locks without try catch finally block. Same thing as line 26
"""
lock = threading.Lock()
with lock:
    print("This is locked")

"""
Condition Variables
wait() will sleep the thread until it is woken up by anther thread with notify
notify() will wake up a sleeping thread
"""



