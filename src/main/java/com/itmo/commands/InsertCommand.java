package com.itmo.commands;


import com.itmo.app.Application;
import com.itmo.data.City;
import com.itmo.exceptions.InputFormatException;
import com.itmo.utils.FieldsValidator;

import java.util.*;
import java.util.stream.Collectors;

public class InsertCommand extends Command implements CommandWithInit {
    private HashSet<Long> idList;
    private Map<Long, City> collection;
    protected City city;

    public InsertCommand() {
    }

    public void init(String argument, Scanner scanner) {
        city = executeInitialization(argument, scanner);
    }

    /**
     * исполнение
     *
     * @param application - текущее приложение
     */
    @Override
    public String execute(Application application) {
        collection = application.getCollection();
        idList = application.getIdList();
        city.setId(City.generateId(idList));
        idList.add(city.getId());
        collection.put(city.getId(), city);
        collection = this.collection.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, HashMap::new));
        return "Элемент с именем " + city.getName() + " добавлен в коллекцию";
    }

    public City executeInitialization(String argument, Scanner scanner) {
        City city = new City();
        if (scanner != null) city.setScanner(scanner);
        if (!FieldsValidator.checkNumber((long) argument.length(), 2, 19,
                "Некорректное имя элемента, оно должно быть из 2-19 знаков!!!", false))
            throw new InputFormatException();
        city.setName(argument);
        city.setFields();
        city.setScanner(null);
        return city;
    }

    @Override
    public Map<Long, City> getCollection() {
        return collection;
    }

    @Override
    public HashSet<Long> getIdList() {
        return idList;
    }

    @Override
    String getCommandInfo() {
        return "insert_null {element} : добавит новый элемент в коллекцию";
    }

    @Override
    public String toString() {
        return "insert_null";
    }

    @Override
    public boolean withArgument() {
        return true;
    }
}
