from time import sleep
from jnius import autoclass

Hardware = autoclass('Hardware')

for i in xrange(20):

    lastEvent = Hardware.lastEvent

    if not lastEvent:
        continue

    print lastEvent.values

    sleep(.1)
