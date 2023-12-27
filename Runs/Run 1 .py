#---------------------------------------------- SoftWare Updates / Imports --------------------------------------------------
from spike import PrimeHub, LightMatrix, Button, StatusLight, ForceSensor, MotionSensor, Speaker, ColorSensor, App, DistanceSensor, Motor, MotorPair
from spike.control import wait_for_seconds, wait_until, Timer
from math import *
import time
#---------------------------------------------- Motor / Variable Declaration--------------------------------------------------
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
#------------------------------------------------------ PID Calculus ---------------------------------------------------------
def PID(Error, KP, KI, KD):
    global perror
    global I
    P = Error
    I = Error + I
    D = Error - perror
    perror = P
    PID = P * KP + I * KI + D * KD
    return PID
#---------------------------------------------- Drive Function Calculus --------------------------------------------------
def Drive(Velocity, Angle, cm):
    motora.set_degrees_counted(0)
    motorb.set_degrees_counted(0)
    kp = 1.101
    ki = 0
    kd = 0.03
    tp = 0.7
    ti = 0.0002
    td = 0.08
    if cm > 0 :
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ 720 * (3 * pi) < cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, kp, ki, kd))
            motora.start(Velocity + v)
            motorb.start((Velocity - v)*-1)
            print(hub.motion_sensor.get_yaw_angle())
    else:
        while (motora.get_degrees_counted()+ motorb.get_degrees_counted()*-1)/ 720 * (3 * pi) > cm:
            v = int(PID(hub.motion_sensor.get_yaw_angle() - Angle, tp, ti, td))
            motora.start((Velocity - v)*-1)
            motorb.start(Velocity + v)
    motora.stop()
    motorb.stop()
#----------------------------------------------- Board Move Function Declaration --------------------------------------------------
def Turn(angle):
    yaw = hub.motion_sensor.get_yaw_angle()
    while yaw < angle-1 or yaw > angle + 1:
        pairAB.start_tank(int((angle - yaw) / 3 + 6),int((yaw - angle) / 3 + 6))
        yaw = hub.motion_sensor.get_yaw_angle()
    pairAB.stop()

def BoardMove(height):
    height = height * -1
    motorc.run_to_degrees_counted(height ,90)
#-----------------------------------------------Terminal--------------------------------------------------#
#Drive(Velocity,Angle,Centimeter)
#BoardMove(Up - 450, Down - -450)
Drive(50,0,28)
Drive(60,0,-4)
Turn(-45)
Drive(60,-45,22)
Turn(42)
Drive(60,42,16)
Drive(40,42,-5)
Drive(60,42,11)
Drive(40,42,-5)
Drive(60,42,11)
Drive(40,42,-5)
Drive(60,42,11)
Drive(60,42,-4)
Turn(-90)
Drive(60,-90,20)
Turn(0)
Drive(60,0,5)
motorc.run_for_rotations(-1.2,100)
motorc.run_for_rotations(1.2,100)
Drive(60,-47,-7)
Turn(-135)
Drive(100,-140,20)
motorc.run_for_rotations(-1.5,100)
Drive(100,-130,70)
