import socket
import sys
from pynput.keyboard import Key, Controller
import time

TCP_IP = sys.argv[1]
TCP_PORT = 5005
BUFFER_SIZE = 20  # Normally 1024, but we want fast response

keyboard = Controller()

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(1)

print("Server: ", TCP_IP)

while 1:
	try:
		print("Waiting...")

		conn, addr = s.accept()
		print('Connection address: ', addr)
    
		data = conn.recv(BUFFER_SIZE)
		if not data: break
		print("received data:", data,)
		
		if data == b'forward':
			keyboard.press(Key.right)
			keyboard.release(Key.right)
		elif data == b'backward':
			keyboard.press(Key.left)
			keyboard.release(Key.left)
	except KeyboardInterrupt:
		if conn:
			conn.close()
		print("W: interrupt received, stopping…")
		break
	finally:
		# clean up
		conn.close()
#conn.close()