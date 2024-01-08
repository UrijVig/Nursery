# Nursery

1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

```
cat > pets  
cat > pack  
cat pets pack > animal  
cat animal  
mv animal mans_friends
```
  
2. Создать директорию, переместить файл туда.

```
mkdir test_directory  
apt-cache madison mysql-server
```

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

```
sudo apt update  
sudo apt install mysql-server
```

4. Установить и удалить deb-пакет с помощью dpkg.

```
sudo dpkg -i google-chrome-stable_current_amd64.deb  
sudo dpkg -r google-chrome-stable 
```

5. Выложить историю команд в терминале ubuntu

```
history > command_history.txt
```

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

[Диаграмма](https://drive.google.com/file/d/1f55tWu8kaEMXnD0Uqz7WqzDVmbRMbltS/view?usp=sharing)

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”

```sql
CREATE DATABASE Human_friends;
```

8. Создать таблицы с иерархией из диаграммы в БД

```sql
USE mans_friends ;

-- Создание таблицы "Животные"
CREATE TABLE Animals (
  animal_id INT AUTO_INCREMENT PRIMARY KEY,
  type_name VARCHAR(50) NOT NULL
); 
INSERT INTO mans_friends.animals (`animal_id`, `type_name`) 
VALUES ('1', 'pets'),
('2', 'pack');

-- Создание таблицы "Домашние животные" с ссылкой на таблицу Animals
CREATE TABLE Pets (
  pets_id INT AUTO_INCREMENT PRIMARY KEY,
  animal_id INT NOT NULL,
  name_of_category VARCHAR(50) NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES Animals(animal_id)
);
INSERT INTO mans_friends.pets (`pets_id`, animal_id, `name_of_category`) 
VALUES ('1', '1', 'cat'),
('2', '1', 'dog'),
('3', '1', 'hamster');     

-- Создание таблицы "Вьючные животные" с ссылкой на таблицу Animals
CREATE TABLE Pack (
  pack_id INT AUTO_INCREMENT PRIMARY KEY,
  animal_id INT NOT NULL,
  name_of_category VARCHAR(50) NOT NULL,
  FOREIGN KEY (animal_id) REFERENCES Animals(animal_id)
);
INSERT INTO mans_friends.pack (`pack_id`, animal_id, `name_of_category`)
VALUES ('1', '2', 'horse'),
('2', '2', 'camel'),
('3', '2', 'donkey');

-- Создание таблицы "Собаки" с ссылкой на таблицу Pets
CREATE TABLE Dogs (
  dog_id INT AUTO_INCREMENT PRIMARY KEY,
  pets_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
  birthday DATE NOT NULL,
  FOREIGN KEY (pets_id) REFERENCES Pets(pets_id)
);

-- Создание таблицы "Кошки" с ссылкой на таблицу Pets
CREATE TABLE Cats (
  cat_id INT AUTO_INCREMENT PRIMARY KEY,
  pets_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
  birthday DATE NOT NULL,
  FOREIGN KEY (pets_id) REFERENCES Pets(pets_id)
);

-- Создание таблицы "Хомяки" с ссылкой на таблицу Pets
CREATE TABLE Hamsters (
  hamster_id INT AUTO_INCREMENT PRIMARY KEY,
  pets_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
  birthday DATE NOT NULL,
  FOREIGN KEY (pets_id) REFERENCES Pets(pets_id)
);

-- Создание таблицы "Лошади" с ссылкой на таблицу Pack
CREATE TABLE Horses (
  horse_id INT AUTO_INCREMENT PRIMARY KEY,
  pack_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
  birthday DATE NOT NULL,
  FOREIGN KEY (pack_id) REFERENCES Pack(pack_id)
);

-- Создание таблицы "Верблюды" с ссылкой на таблицу Pack
CREATE TABLE Camels (
  camel_id INT AUTO_INCREMENT PRIMARY KEY,
  pack_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
 birthday DATE NOT NULL,
  FOREIGN KEY (pack_id) REFERENCES Pack(pack_id)
);

-- Создание таблицы "Ослы" с ссылкой на таблицу Pack
CREATE TABLE Donkeys (
  donkey_id INT AUTO_INCREMENT PRIMARY KEY,
  pack_id INT NOT NULL,
  moniker VARCHAR(50) NOT NULL,
  command VARCHAR(50) DEFAULT NULL,
  birthday DATE NOT NULL,
  FOREIGN KEY (pack_id) REFERENCES Pack(pack_id)
);
```
      
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

```sql
INSERT INTO mans_friends.horses (`pack_id`, moniker, command, `birthday`)
VALUES ('1', 'Граф', 'Но, прр', '2020-12-01'),
('1', 'Принц', NULL, '2023-12-1'),
('1', 'Кобальт', NULL, '2021-10-1'),
('1', 'Поняшка', 'Рядом, прыг', '2019-2-1');

INSERT INTO mans_friends.camels (`pack_id`, moniker, command, `birthday`) 
VALUES ('2', 'Горбыль', NULL, '2022-5-15'),
('2', 'Гриф', 'Рядом', '2020-1-1');

INSERT INTO mans_friends.donkeys (`pack_id`, moniker, command, `birthday`) 
VALUES ('3', 'Рокета', 'ц', '2021-12-12');

INSERT INTO mans_friends.dogs (`pets_id`, moniker, command, `birthday`) 
VALUES ('2', 'Барбос', NULL, '2023-12-1'),
('2', 'Мухтар', NULL, '2021-10-1'),
('2', 'Джек', 'к ноге, голос', '2019-2-1');

INSERT INTO mans_friends.cats (`pets_id`, moniker, command, `birthday`) 
VALUES ('1', 'Васька', NULL, '2022-5-15'),
('1', 'Барсик', 'кс-кс, нельзя', '2020-1-1');

INSERT INTO mans_friends.hamsters (`pets_id`, moniker, `birthday`) 
VALUES ('3', 'Щекастик', '2021-12-12');
```

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.


```sql
DROP TABLE camels;
CREATE TABLE new_pack AS SELECT * FROM horses UNION ALL SELECT * FROM donkeys;
```

11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице

```sql
CREATE TABLE young_animals AS
SELECT moniker,command, birthday, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age
FROM (
SELECT * FROM cats       
UNION ALL
SELECT * FROM dogs
UNION ALL
SELECT * FROM donkeys
UNION ALL
SELECT * FROM hamsters
UNION ALL
SELECT * FROM horses
) AS animals
WHERE birthday BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) 
AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
```

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.

```sql
CREATE TABLE all_animals AS
SELECT p.name_of_category, h.moniker, h.command, h.birthday, ya.age 
FROM horses h
LEFT JOIN young_animals ya ON ya.moniker = h.moniker
LEFT JOIN pack p ON p.pack_id = h.pack_id
UNION 
SELECT pa.name_of_category, d.moniker, d.command, d.birthday, ya.age 
FROM donkeys d 
LEFT JOIN young_animals ya ON ya.moniker = d.moniker
LEFT JOIN pack pa ON pa.pack_id = d.pack_id
UNION
SELECT p.name_of_category, c.moniker, c.command, c.birthday, ya.age 
FROM cats c
LEFT JOIN young_animals ya ON ya.moniker = c.moniker
LEFT JOIN pets p ON p.pets_id = c.pets_id
UNION
SELECT p.name_of_category, d.moniker, d.command, d.birthday, ya.age 
FROM dogs d
LEFT JOIN young_animals ya ON ya.moniker = d.moniker
LEFT JOIN pets p ON p.pets_id = d.pets_id
UNION
SELECT p.name_of_category, h.moniker, h.command, h.birthday, ya.age 
FROM hamsters h
LEFT JOIN young_animals ya ON ya.moniker = h.moniker
LEFT JOIN pets p ON p.pets_id = h.pets_id
```

13. Создать [класс с Инкапсуляцией методов и наследованием по диаграмме](https://github.com/UrijVig/Nursery/tree/main/src/Model/AnimalClasses).

14. Написать [программу, имитирующую работу реестра домашних животных](https://github.com/UrijVig/Nursery/blob/main/src/AnimalRegistry.java).
    В программе должен быть реализован следующий функционал:
    14.1 Завести новое животное  
    14.2 определять животное в правильный класс  
    14.3 увидеть список команд, которое выполняет животное  
    14.4 обучить животное новым командам  
    14.5 Реализовать навигацию по меню  

15. Создайте класс [Счетчик](https://github.com/UrijVig/Nursery/blob/main/src/Model/Counter.java), у которого есть метод add(), увеличивающий̆
    значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
    животное” Сделайте так, чтобы с объектом такого типа можно было работать в
    блоке try-with-resources. Нужно бросить исключение, если работа с объектом
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
    считать в ресурсе try, если при заведения животного заполнены все поля.

