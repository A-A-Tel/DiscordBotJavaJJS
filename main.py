import subprocess
from time import sleep
import git
repo = git.Repo("./")

import psutil


def find_bot():
    for proc in psutil.process_iter(['pid', 'name', 'cmdline']):
        try:
            if 'java' in proc.info['name'] and "The-Ghost-all.jar" in ' '.join(proc.info['cmdline']):
                return True
        except (psutil.NoSuchProcess, psutil.AccessDenied):
            continue
    return False


while True:
    if not find_bot():
        print("")
        print("")
        o = repo.remotes.origin
        o.pull()
        sleep(3)
        ran = subprocess.run(["gradlew.bat", "shadowJar"], capture_output=True, text=True)
        print(ran)
        print("")
        print("")
        ran = subprocess.run(["java", "-jar", "./build/libs/The-Ghost-all.jar"], capture_output=True, text=True)
        print(ran)
    else:
        print("found")
        sleep(500)
