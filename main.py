import subprocess
from time import sleep

import psutil


def find_bot():
    for proc in psutil.process_iter(['pid', 'name', 'cmdline']):
        try:
            if 'java' in proc.info['name'] and "Bot-N-all.jar" in ' '.join(proc.info['cmdline']):
                return True
        except (psutil.NoSuchProcess, psutil.AccessDenied):
            continue
    return False


while True:
    if not find_bot():
        print("")
        print("")
        ran = subprocess.run(["build.bat"], capture_output=True, text=True)
        print(ran)
        print("")
        print("")
        ran = subprocess.run(["java", "-jar", "D:/Personal/Discord/DiscordBotJavaJJS/build/libs/Bot-N-all.jar"], capture_output=True, text=True)
        print(ran)
    else:
        print("found")
    sleep(10)
