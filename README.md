# Bookmanager Application

Разработать небольшой веб-сервис с авторизацией и возможностью управления списком книг.

1. Авторизация по логину и паролю (можно in-memory, без регистрации)
2. Добавлять, редактировать, удалять книги
3. Хранить поля: id, vendorCode, title, year, brand, stock, price. Все данные сохраняются в базу данных.
4. Выводить список книг в виде таблицы (Bootstrap+Thymeleaf)
5. Поддерживать пагинацию и фильтрацию по title, brand, year
6. REST API: GET /api/books, POST /api/books, PUT /api/books/{id}, DELETE /api/books/{id}

<h3>📸 Превью интерфейса</h3>

<p float="left">
  <img src="https://github.com/user-attachments/assets/0dc39b59-cc20-4350-b5ea-aa9c572b023b" width="300"/>
  <img src="https://github.com/user-attachments/assets/26fd7428-5118-4cb1-932f-6762957b63ff" width="300"/>
  <img src="https://github.com/user-attachments/assets/8658dc3b-236f-4762-811f-75f4a69937ce" width="300"/>
</p>

## Установка и запуск проекта

### Шаг 1: Склонировать репозиторий

Клонируйте репозиторий с GitHub:

```bash
git clone https://github.com/ialakey/BookManager
```

### Шаг 2: Собрать проект с помощью Gradle

Сначала соберите проект с помощью Gradle:

```bash
./gradlew bootJar
```

Это создаст исполнимый JAR файл в папке `build/libs`.

### Шаг 3: Создание Docker-образа

Теперь создайте Docker-образ с помощью команды:

```bash
docker build -t bookstore-app .
```

### Шаг 4: Запуск контейнера

Запустите контейнер с приложением, используя Docker:

```bash
docker run -p 8080:8080 bookstore-app
```

Теперь приложение будет доступно на порту 8080 вашего локального сервера.

### Шаг 5: Доступ к Swagger UI

Откройте браузер и перейдите по следующему адресу, чтобы открыть Swagger UI и протестировать ваше API:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
