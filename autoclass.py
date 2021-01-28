from time import sleep
from jnius import autoclass

Hardware = autoclass('org.yourapp.Hardware') //Путь к файлу Hardware


#активировать акселерометр
Hardware.accelerometerEnable(True)

# читаем его
for i in xrange(20):

    # читаем последний ивент
    lastEvent = Hardware.lastEvent

    # проверка на последний ивент
    if not lastEvent:
        continue

    # показать текущее значение
    print lastEvent.values

    sleep(.1)

# не забываем выключить акселерометр
Hardware.accelerometerEnable(False)
