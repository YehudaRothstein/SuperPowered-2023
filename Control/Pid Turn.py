def Turn(angle):
    yaw = hub.motion_sensor.get_yaw_angle()
    while yaw < angle-1 or yaw > angle + 1:
        pairAB.start_tank(int((angle - yaw) / 3 + 6),int((yaw - angle) / 3 + 6))
        yaw = hub.motion_sensor.get_yaw_angle()
    pairAB.stop()