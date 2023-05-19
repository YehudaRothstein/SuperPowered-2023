def PID(Error, KP, KI, KD):
    global perror
    global I
    P = Error
    I = Error + I
    D = Error - perror
    perror = P
    PID = P * KP + I * KI + D * KD
    return (PID)
    print("hello")
