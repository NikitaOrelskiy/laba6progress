package com.itmo.commands;

import com.itmo.app.Application;
import com.itmo.utils.FileManager;
import com.itmo.data.City;

import java.util.HashSet;
import java.util.Map;

/**
 * команда записывает коллекцию в файл в формате xml
 */
public class SaveCommand extends Command {
    private Application application;

    public SaveCommand() {
    }

    /**
     * запись в файл
     */
    @Override
    public String execute(Application application) {
        this.application = application;
        if (new FileManager().saveCollection(application.getCollection(), "input.json"))
            return "Коллекция сохранена в файл";
        return "Проблемы с файлом по умолчанию на сервере, коллекция не сохранена...";
    }

    @Override
    public Map<Long, City> getCollection() {
        return application.getCollection();
    }

    @Override
    public HashSet<Long> getIdList() {
        return application.getIdList();
    }

    @Override
    String getCommandInfo() {
        return "save : сохранит коллекцию в файл";
    }

    @Override
    public String toString() {
        return "save";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}
