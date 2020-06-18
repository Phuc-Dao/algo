"""
Implementation of the producer consumer problem
in python
"""

import threading

cv = threading.Condition()
global n = 0

class Producer(threading.Thread):
    def run(self):
        with cv:
            while n <= 5:
                print("producing the resource")
                n += 1
                timer.sleep(1)
            cv.signal()            
            
class Consumer(threading.Thread):
    def run(self):
        with cv:
            while n >= 5:
                timer.sleep(2)
                cv.sleep()                
            print("consuming") 
            n -= 1
            
p = Producer()
c = Consumer()           
p.run()
c.run()
