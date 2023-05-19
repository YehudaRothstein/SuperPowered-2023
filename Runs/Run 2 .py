#----------------------------------------------- SoftWare Updates / Imports --------------------------------------------------
from spike import PrimeHub, LightMatrix, Button, StatusLight, ForceSensor, MotionSensor, Speaker, ColorSensor, App, DistanceSensor, Motor, MotorPair
from spike.control import wait_for_seconds, wait_until, Timer
from math import *
import time
#----------------------------------------------- Motor / Variable Declaration--------------------------------------------------
time.sleep(1)
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
    kp = 1.5
    ki = 0
    kd = 1.35
    tp = 0.5
    ti = 0
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
#Drive(Velocity,Angle, Distance)
#    Drive To Objective [02]
Drive(60,0,32.5)
#    Do Objective [02]
BoardMoveUp(400)
BoardMoveUp(-1)
BoardMoveUp(400)
BoardMoveUp(-1)
BoardMoveUp(400)
BoardMoveUp(-1)
#    Do Objective [03]
RotationSide(1.1)
Drive(60,0,7)
time.sleep(0.25)
hub.motion_sensor.reset_yaw_angle()
BoardMoveUp(250)
Drive(45,0,3)
BoardMoveUp(-1)
Drive(50,0,-5)
BoardMoveUp(300)
#   Run To Objective [05]
Turn(62)
RotationSide(-0.6)
Drive(60,62,30)
RotationUp(1)
##    Do Objective [04]
Turn(25)
Drive(60,64,-4)
RotationUp(-1.2)
Turn(20)
Drive(60,20,4)
RotationUp(0.3)
Drive(60,0,5)
time.sleep(0.25)
hub.motion_sensor.reset_yaw_angle()
Turn(-100)
RotationUp(1)
Drive(80,-100, 15)
Turn(0)
BoardMoveUp(350)
Drive(45,0,3.5)
BoardMoveUp(-1)
Drive(60,0,-3)
Turn(80)
Drive(80,80,12)
Turn(145)
Drive(80,145,9.5)
BoardMoveUp(300)
Turn(0)
Drive(60,0,8)
Turn(-85)
RotationSide(1)
Drive(60,-88,19)
RotationUp(-0.7)
hub.motion_sensor.reset_yaw_angle()
Turn(-60)
Drive(60,-60,39)
