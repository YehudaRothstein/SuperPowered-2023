def update_odometry(x, y, theta, linear_velocity, angular_velocity, dt):
    delta_x = linear_velocity * math.cos(theta) * dt
    delta_y = linear_velocity * math.sin(theta) * dt
    delta_theta = angular_velocity * dt
    x += delta_x
    y += delta_y
    theta += delta_theta
    return x, y, theta