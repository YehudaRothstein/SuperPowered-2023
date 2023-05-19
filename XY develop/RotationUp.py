def RotationUp(rotations):
    rotations = rotations * -1
    motorc.run_for_rotations(rotations,100)