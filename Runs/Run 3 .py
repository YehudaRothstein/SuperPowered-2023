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
x = hub.motion_sensor.get_yaw_angle()
perror = 0
I = 0
totalDegrees = 0
timeloop = 0
#------------------------------------------------------- PID Calculus ---------------------------------------------------------
def PID(Error, KP, KI, KD):
    global perror
    global I
    P = Error
    I = Error + I
    D = Error - perror
    perror = P
    PID = P * KP + I * KI + D * KD
    return (PID)
    print(PID)
#----------------------------------------------- Drive Function Calculus --------------------------------------------------
def Drive(Velocity, Angle, cm):
    motora.set_degrees_counted(0)
    motorb.set_degrees_counted(0)
    kp = 1.101
    ki = 0.00001
    kd = 0.019
    tp = 0.7
    ti = 0.0002
    td = 0.08
    if cm > 0 :
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ (720) * (3 * pi) < cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, kp, ki, kd))
            motora.start(Velocity + v)
            motorb.start((Velocity - v)*-1)
            global totalDegrees
            global timeloop
            totalDegrees = totalDegrees + int(hub.motion_sensor.get_yaw_angle())
            timeloop = timeloop +1
            print(hub.motion_sensor.get_yaw_angle())
    else:
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ (720) * (3 * pi) > cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, tp, ti, td))
            motora.start((Velocity - v)*-1)
            motorb.start(Velocity + v)
    avgDegrees = (totalDegrees / timeloop)
    print('Amount Of Cycles:', timeloop)
    print('Avrege Error Degrees Per Loop:', avgDegrees)
    pairAB.stop()
#----------------------------------------------- Board Move Function Declaration --------------------------------------------------
def Turn(angle):
    yaw = hub.motion_sensor.get_yaw_angle()
    while yaw < angle-1 or yaw > angle + 1:
        pairAB.start_tank(int((angle - yaw) / 3 + 6),int((yaw - angle) / 3 + 6))
        yaw = hub.motion_sensor.get_yaw_angle()
    pairAB.stop()

def RotationUp(rotations):
    rotations = rotations * -1
    motorc.run_for_rotations(rotations, 100)

def RotationSide(rotations):
    motord.run_for_rotations(rotations, 100)
#----------------------------------------------- Terminal / Console --------------------------------------------------
#Drive(Velocity,Angle,Centimeter)

Drive(60,0,32)
RotationUp(1.1)
RotationSide(1.2)
Turn(17)
RotationSide(-0.5)
Turn(-45)
Drive(60,-40,12)
Turn(90)
Drive(60,90,2)
RotationUp(-1)
Drive(100,90,-2)
Turn(-140)
Drive(60,-140,11)
RotationUp(1)
RotationUp(-1)
Drive(100, -120, -6)
Turn(20)
Drive(100,20,40)
