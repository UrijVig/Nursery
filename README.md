# Nursery

1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

   cat > pets
   cat > pack
   cat pets pack > animal
   cat animal
   mv animal mans_friends
  
2. Создать директорию, переместить файл туда.

   mkdir test_directory
   apt-cache madison mysql-server

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

   sudo apt update
   sudo apt install mysql-server

4. Установить и удалить deb-пакет с помощью dpkg.

   sudo dpkg -i google-chrome-stable_current_amd64.deb
   sudo dpkg -r google-chrome-stable 
 
5. Выложить историю команд в терминале ubuntu

   history > command_history.txt

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).

      https://drive.google.com/file/d/1f55tWu8kaEMXnD0Uqz7WqzDVmbRMbltS/view?usp=sharing
