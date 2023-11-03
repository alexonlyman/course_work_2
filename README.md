## **Описание задачи**

В рамках курсовой вам предстоит написать сервис по управлению задачами по типу ежедневника.
В ежедневник можно заносить задачи, можно удалять их, можно получать список задач на предстоящий день.
Каждая задача обязательно имеет заголовок. У каждой задачи может быть поле для описания.
Также все задачи обязательно нужно делить по типу: личные или рабочие задачи. У каждой задачи есть дата и время, которые
были присвоены при создании.

Также для более гибкого управления задачами рекомендуется завести поле id, которое нужно проставлять через генератор (
как в первой курсовой).

Кроме того, в нашем ежедневнике задачи имеют разную повторяемость, которую можно указать при создании задачи:

- однократная,
- ежедневная,
- еженедельная,
- ежемесячная,
- ежегодная.

У каждой повторяемости есть метод для получения следующей даты и времени выполнения.

**Заголовок, описание, тип и признак повторяемости обязательны к заполнению.**

-Все задачи должны храниться в коллекции, тип которой нужно выбрать самостоятельно как самый оптимальный для работы.

Организацию работы с задачами необходимо сделать в виде отдельного класса-сервиса, который будет хранить коллекцию задач
и методы по работе с этими задачами.

Управление задачами осуществляется через консоль и класс Scanner.

Данный код нужно доработать: дописать обработку команд, вводимых данных,
чтобы можно было выполнить все перечисленные условия задачи (создать задачу, удалить, получить все задачи на дату). 

Базовый уровень выполнения:
- Ввод с консоли осуществляется через класс Scanner.
- Каждой задаче присвоен id.
- Можно выбрать тип задачи: личная или рабочая.
- Реализована функция повторяемости задачи:
    - однократная,
    - ежедневная,
    - еженедельная,
    - ежемесячная,
    - ежегодная.
- Обработаны ошибки при вводе некорректных данных.

В сервисе добавлены методы:

- «Добавить задачу»,
- «Получить задачи на день».
- «Удалить задачу по id».
