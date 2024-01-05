import Model.*;
import Model.AnimalClasses.Animal;
import Model.AnimalClasses.Pack.List.*;
import Model.AnimalClasses.Pets.List.*;

import java.util.*;

public class AnimalRegistry {

    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            List<Animal> animals = new ArrayList<>();
            boolean flag, nFlag, search;
            while (true) {
                System.out.println("Выберите опцию:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Определить класс животного");
                System.out.println("3. Посмотрите список команд, которые может выполнять животное");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("5. Выход");
                int option;
                String data;
                do {
                    System.out.println("Введите число:");
                    data = scanner.next();
                } while (!Helper.isNumber(data));
                option = Integer.parseInt(data);

                switch (option) {
                    case 1:
                        System.out.println("Введите кличку животного: ");
                        String name = scanner.next();
                        String kind;
                        flag = true;
                        while (flag) {
                            System.out.println("Введите тип животного (dog, cat, hamster, horse, camel, donkey): " +
                                    "\n введите \"exit\" чтобы вернуться в основное меню");
                            kind = scanner.next();
                            flag = false;
                            switch (kind) {
                                case "dog":
                                    animals.add(new Dog(name));
                                    counter.add();
                                    break;
                                case "cat":
                                    animals.add(new Cat(name));
                                    counter.add();
                                    break;
                                case "hamster":
                                    animals.add(new Hamster(name));
                                    counter.add();
                                    break;
                                case "horse":
                                    animals.add(new Horse(name));
                                    counter.add();
                                    break;
                                case "camel":
                                    animals.add(new Camel(name));
                                    counter.add();
                                    break;
                                case "donkey":
                                    animals.add(new Donkey(name));
                                    counter.add();
                                    break;
                                case "exit":
                                    break;
                                default:
                                    System.out.println("Питомник не может принять данный вид животного, попробуйте снова.");
                                    flag = true;
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Введите кличку животного, чтобы переопределить его класс: ");
                        String animalName = scanner.next();
                        search = true;
                        for (Animal animal : animals) {
                            if (animal.getName().equals(animalName)) {
                                search = false;
                                String answer, type;
                                flag = true;
                                while (flag) {
                                    System.out.println(animalName + "принадлежит к классу: " + animal.getType() + ". Хотите изменить его?" +
                                            "\n Введите \"да\" чтобы переопределить класс животного " +
                                            "\n Введите \"нет\", чтобы вернуться в меню:");
                                    answer = scanner.next();
                                    switch (answer) {
                                        case "да":
                                            nFlag = true;
                                            while (nFlag) {
                                                nFlag = false;
                                                System.out.println("Выберите необходимый класс:" +
                                                        "\n \"1\" Вьючное животное" +
                                                        "\n \"2\" Домашнее животное" +
                                                        "\n \"exit\" вернуться в меню!");
                                                type = scanner.next();
                                                switch (type) {
                                                    case ("1"):
                                                        animal.setType("Pack");
                                                        break;
                                                    case ("2"):
                                                        animal.setType("Pet");
                                                        break;
                                                    case ("exit"):
                                                        break;
                                                    default:
                                                        System.out.println("Команда е распознана, пожалуйста повторите ввод.");
                                                        nFlag = true;
                                                        break;
                                                }
                                            }
                                            flag = false;
                                            break;
                                        case "нет":
                                            flag = false;
                                            break;
                                        default:
                                            System.out.println("Команда е распознана, пожалуйста повторите ввод.");
                                    }
                                }
                                break;
                            }
                        }
                        if (search) System.out.println("Питомец с таким именем не найден!");
                        search = false;
                        break;
                    case 3:
                        System.out.println("Введите кличку животного, чтобы увитеть список команд, которым он обучен: ");
                        String inputName = scanner.next();
                        search = true;
                        for (Animal animal : animals) {
                            if (animal.getName().equals(inputName)) {
                                search = false;
                                animal.showCommands();
                                break;
                            }
                        }
                        if (search) System.out.println("Питомец с таким именем не найден!");
                        search = false;
                        break;
                    case 4:
                        System.out.println("Введите имя животного для дрессировки: ");
                        String trainName = scanner.next();
                        search = true;
                        for (Animal animal : animals) {
                            if (animal.getName().equals(trainName)) {
                                search = false;
                                System.out.println("Введите новую команду для обучения " + trainName + ": ");
                                String newCommand = scanner.next();
                                animal.train(newCommand);
                                break;
                            }
                        }
                        if (search) System.out.println("Питомец с таким именем не найден!");
                        search = false;
                        break;
                    case 5:
                        System.out.println("Выход из программы...");
                        return;
                    default:
                        System.out.println("Неверный вариант, попробуйте еще раз.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

