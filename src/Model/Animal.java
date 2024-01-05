package Model;

import java.util.ArrayList;
import java.util.List;


public class Animal {
    private final String name;
    private String type;
    private String kind;
    private final List<String> commands;

    public Animal(String name, String type, String kind) {
        this.name = name;
        this.type = type;
        this.kind = kind;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void showCommands() {
        System.out.println("Что умеет " + name + ": " + commands);
    }

    public void train(String command) {
        commands.add(command);
        System.out.println(name + " выучил команду: " + command);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setType(String type) {
        this.type = type;
    }
}

