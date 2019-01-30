import socket
import time
from threading import Thread
def f(cs,i):
	print ("Procesez client"+str(i))
	time.sleep(2)
	print(addr)
	cs.send(b"Un client")
	print(cs.recv(10))
	cs.close()
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(("0.0.0.0",7777))
s.listen(5)
i=0
while 1==1:
	i=i+1
	cs,addr = s.accept()
	t = Thread(target=f,args=(cs,i))
	t.start()
