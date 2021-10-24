package com.itmo.commands;


import com.itmo.app.Application;
import com.itmo.data.City;

import java.io.Serializable;
import java.util.*;
/*

if ("exit".equals(commandName))
if ("help".equals(commandName)) {
} else if("show".equals(commandName)){
} else if("info".equals(commandName)) {
}else if("insert".equals(commandName)) {
}else if("updateid".equals(commandName)) {
}else if("removekey".equals(commandName)) {
}else if("clear".equals(commandName)) {
}else if("save".equals(commandName)) {
}else if("execute_script".equals(commandName)) {
}else if("remove_greater".equals(commandName)) {
}else if("remove_greater_key".equals(commandName)) {
}else if("remove_lower_key".equals(commandName)) {
}else if("remove_all_by_governor".equals(commandName)) {
}else if("print_ascending".equals(commandName)) {
}else if("print_field_descending_agglomeration".equals(commandName)) {
}
 */

/**
 * абстрактный класс команды, описывает общее для всех команд поведение
 * также каждая новая команда должна переопределять toString - возвращать
 * представление команды без аргументов, нужно для истории и обработчика
 */
public abstract class Command implements Serializable {
    /**
     * метод исполнения команды
     * @param application - текущее работающее приложение
     */
    public abstract String execute(Application application);

    public abstract Map<Long, City> getCollection();

    public abstract HashSet<Long> getIdList();

    /**
     * @return информация о команде, которая потом выводится с командой help
     */
    abstract String getCommandInfo();

    /**
     * метод, нужный для того, чтобы из ссылки на абстрактную команды, мы знали требуется ли этой команде аргумент
     */
    public abstract boolean withArgument();
}
