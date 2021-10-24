package com.itmo.commands;

import com.itmo.app.Application;
import com.itmo.data.City;
import com.itmo.exceptions.IdNotFoundException;
import com.itmo.exceptions.InputFormatException;
import com.itmo.utils.FieldsValidator;

import java.util.*;

public class UpdateIdCommand extends Command implements CommandWithInit{

    public UpdateIdCommand(){}

    private Map<Long, City> collection;
    private HashSet<Long> idList;
    private City city;


    public void init(String argument, Scanner scanner) {
        try {
            if (!FieldsValidator.checkStringParseToLong(argument, "id - это целое число!!!"))
                throw new InputFormatException();
            long id = Long.parseLong(argument);
            city = new City();
            city.setId(id);
            if (scanner != null) city.setScanner(scanner);
            city.checkName();
            city.setFields();
            city.setScanner(null);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода, id - число!!!");
        }
    }

    /**
     * обновляет поля
     */
    @Override
    public String execute(Application application) {
        collection = application.getCollection();
        idList = application.getIdList();
        try {
            if (!collection.containsKey(city.getId())) {
                throw new IdNotFoundException("Элемент нельзя обновить, т.к. элемента с таким id нет в коллекции!!!");
            }
            collection.put(city.getId(), city);
            return "Элемент с id "+ city.getId()+" обновлён";
        } catch (IdNotFoundException e) {
            return e.getMessage();
        }
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
        return "update_id : обновит значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String toString() {
        return "update_id";
    }

    @Override
    public boolean withArgument() {
        return true;
    }
}
