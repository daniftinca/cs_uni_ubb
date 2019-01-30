import socket

s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(("192.168.1.8",7777))

print(s.recv(10))
s.send(b"Am trimis")

s.close()
