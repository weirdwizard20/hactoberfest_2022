import socket
import threading
from time import sleep
import datetime

s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
host=socket.gethostname()
port=4001
s.connect((host,port))
print("----------------------------------------------------------------- ")
print("Connected to chat server ")
print("----------------------------------------------------------------- ")

def send_msg():
    
    try:
    
        while True:        
            curr_time=datetime.datetime.now()
            
            msg=input("Client, at "+str(curr_time.hour)+":"+str(curr_time.minute)+" >> ")
            
            
            message="Client, at "+str(curr_time.hour)+":"+str(curr_time.minute)+" >> "+msg
            
            message=message.encode()
            s.send(message)
            
            if msg=="quit":
                s.close()
                break
            
    except:
        print("")
            
               
def receive_msg():
    
    try:
    
        while True:
        
            incoming_message =s.recv(1024)
            incoming_message=incoming_message.decode()
            print(incoming_message)
            if incoming_message.endswith("quit"):
                print("Server has stopped")
    
            sleep(2)
        
    except:
        print("")

tr=threading.Thread(target=receive_msg)


tr.start()
send_msg()