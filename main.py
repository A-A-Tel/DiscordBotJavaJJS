from time import sleep

import psutil

while True:
    for process in psutil.process_iter():
        if process.name == "Bot-1.0-all.jar":
            print(process.name)
    sleep(5)
