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
#----------------------------------------------- Drive Function Calculus --------------------------------------------------
def Drive(Velocity, Angle, cm):
    motora.set_degrees_counted(0)
    motorb.set_degrees_counted(0)
    kp = 1.3
    ki = 0.0001
    kd = 1
    tp = 0.4
    ti = 0.0002
    td = 0.3
    if cm > 0 :
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ (720) * (3 * pi) < cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, kp, ki, kd))
            motora.start(Velocity + v)
            motorb.start((Velocity - v)*-1)
            print(hub.motion_sensor.get_yaw_angle())
    else:
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ (720) * (3 * pi) > cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, tp, ti, td))
            motora.start((Velocity - v)*-1)
            motorb.start(Velocity + v)
            print(hub.motion_sensor.get_yaw_angle())
    motora.stop()
    motorb.stop()
#----------------------------------------------- Board Move Function Declaration --------------------------------------------------
def BoardMoveUp(he):
    he = he * -1
    motorc.run_to_degrees_counted(he, 100)
def BoardMoveSide(le):
    le = le * -1
    motord.run_to_degrees_counted(le, 100)

def Turn(angle):
    yaw = hub.motion_sensor.get_yaw_angle()
    while yaw < angle-1 or yaw > angle + 1:
        pairAB.start_tank(int((angle - yaw) / 3 + 6),int((yaw - angle) / 3 + 6))
        yaw = hub.motion_sensor.get_yaw_angle()
    pairAB.stop()
def RotationUp(rotations):
    rotations = rotations * -1
    motorc.run_for_rotations(rotations,100)

def RotationSide(rotations):
    motord.run_for_rotations(rotations,100)
#----------------------------------------------- Terminal / Console --------------------------------------------------
Drive(60,0,26)
Turn(45)
Drive(60,45,18)
Turn(135)
Drive(60,135,4.5)
RotationUp(-0.3)
Drive(45,135,-7)
Turn(0)
Drive(100,-5,70)