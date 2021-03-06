package com.itmo.commands;

import com.itmo.app.Application;
import com.itmo.data.City;
import com.itmo.exceptions.IdNotFoundException;
import com.itmo.exceptions.InputFormatException;
import com.itmo.utils.FieldsValidator;

import java.util.*;

public class RemoveKeyCommand extends Command implements CommandWithInit{
    private Map<Long, City> collection;
    private HashSet<Long> idList;
    private Long id;

    public RemoveKeyCommand() { }

    public void init(String argument, Scanner scanner) {
        if (!FieldsValidator.checkStringParseToLong(argument, "id - это целое число!!!"))
            throw new InputFormatException();
        id = Long.parseLong(argument);
    }

    /**
     * удаление элемента
     *
     */
    @Override
    public String execute(Application application) {
        collection = application.getCollection();
        idList = application.getIdList();
        try {
            if (!idList.remove(id))
                throw new IdNotFoundException("Элемент не удален, т.к. элемента с таким id нет в коллекции!!!");
            collection.remove(id);
        } catch (IdNotFoundException e) {
            return e.getMessage();
        }
        return "Элемент с id "+id+" удалён из коллекции";
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
        return "remove_key key : удалит элемент из коллекции по его ключу";
    }

    @Override
    public String toString() {
        return "remove_key";
    }

    @Override
    public boolean withArgument() {
        return true;
    }
}
