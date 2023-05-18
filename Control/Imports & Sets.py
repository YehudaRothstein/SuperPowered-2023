#----------------------------------------------- SoftWare Updates / Imports --------------------------------------------------
from spike import PrimeHub, LightMatrix, Button, StatusLight, ForceSensor, MotionSensor, Speaker, ColorSensor, App, DistanceSensor, Motor, MotorPair
from spike.control import wait_for_seconds, wait_until, Timer
from math import *
import time
#----------------------------------------------- Motor / Variable Declaration--------------------------------------------------
hub = PrimeHub()
motora = Motor('A')
motorb = Motor('B')
motorc = Motor('C')
motord = Motor('D')
pairAB = MotorPair('A','B')
hub.motion_sensor.reset_yaw_angle()
motorc.set_degrees_counted(0)
perror = 0
I = 0
x = hub.motion_sensor.get_yaw_angle()