import random

NUMBER_OF_POINTS = 1000000
numInside = 0

for i in range(NUMBER_OF_POINTS):
    x = random.random()
    y = random.random()
    if(x*x + y*y <= 1):
        numInside += 1

piApprox = 4*(numInside / NUMBER_OF_POINTS)
piApprox = round(piApprox, 2)
print(piApprox)
