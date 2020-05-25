import threading
import time

"""
Using locks without try catch finally block. Same thing as above
"""

lock = threading.Lock()
with lock:
    print("This is locked")

