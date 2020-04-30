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

import Lock


