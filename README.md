<h1>Cетевой чат на Java, клиентское приложение.</h1>

<p>Данный репозиторий хранит в себе Клиентскую составляющую моего курсового проекта "Серверный чат"</p>
<p>Клиентское приложение реализовано с помощью 2 отдельный потоков <strong>WriteThread</strong> и <strong>ReadThread</strong> , а также общего Socket-класса клиент, который инициализирует подключение и запускает оба потока </p>
<h2>WriteThread</h2>
<p>Поток, отвечающий за передачу написанного в консоль сообщения на сервер состоит из приватных полей <strong>Socket</strong> и <strong>Client</strong>, отвечающих за подключение, <strong>PrintWriter</strong>, 
  отвечающий за передачу данных и <strong>BufferedReader</strong>, отвечающий за считывание данных из консоли </p>
<p>В конструктор класса предается Сокет и созданный класс <strong>Client</strong>, с помощью которых происходит инициализация <strong>PrintWriter</strong></p>
<p>Когда поток запускается, первое сообщение, которое считывает <strong>BufferedReader</strong> является именем, последующие сообщения передаются в бесконечном цикле в <strong>PrintWriter</strong> для передачи на серверr</p>
<p>Бесконечный цикл заканчивается, когда в консоле вводится сообщение <strong>exit</strong></p>
<h2>ReadThread</h2>
<p>Поток, отвечающий за считывание информации состоит из полей <strong>Socket</strong> и <strong>Client</strong>, аналогично WriteThread, а также <strong>BufferedReader</strong> для считывания данных, 
  для последующего отображения их в консоль
</p>
<p>При инициализации объекта класса <strong>ReadThread</strong> передаются значения параметров <strong>Socket</strong> и <strong>Client</strong> и с помощью первого инициализируется <strong>BufferedReader</strong></p>
<p>В бесконечном цикле происходит считывание сообщений с сервера и демонстрация их на экран</p>
<h2>Client</h2>
<p>В классе клиент происходит инициализация подключения по данным, взятым из текстового файла настроек, методом <strong>getSettings</strong>, после чего запускаются оба потока <strong>ReadThread</strong> и <strong>WriteThread</strong></p>
<h2>Логирование записей</h2>
<p>Клиентское приложение логирует подключение пользователей, сообщения, отправленные от них, а также отключение пользователей</p>
<p>Реализовано логирование с помощью объекта класса <strong>Logger</strong> из билиотеки <strong>org.slf4j</strong> </p>
