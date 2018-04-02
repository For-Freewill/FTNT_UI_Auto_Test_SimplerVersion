@echo off 现在开始清理浏览器进程
wmic process where name='chrome.exe' call terminate
wmic process where name='iexplore.exe' call terminate
wmic process where name='firefox.exe' call terminate

exit