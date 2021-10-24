package com.itmo.commands;


import com.itmo.app.Application;
import com.itmo.data.City;

import java.util.*;

/**
 * команда очищает коллекцию
 */
public class ClearCommand extends Command {
    @Override
    public String execute(Application application) {
        application.setInitializationDate();
        return "Коллекция очищена";
    }

    public HashSet<Long> getIdList() {
        return new HashSet<>();
    }

    public Map<Long, City> getCollection() {
        return new HashMap<>();
    }

    @Override
    String getCommandInfo() {
        return "clear : очистит коллекцию";
    }

    @Override
    public String toString() {
        return "clear";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}
