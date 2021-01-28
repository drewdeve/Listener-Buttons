from time import sleep
from jnius import autoclass

Hardware = autoclass('путь к вашему приложению, где лежит Hardware')


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
