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
    motora.stop()
    motorb.stop()