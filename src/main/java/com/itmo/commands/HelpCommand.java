package com.itmo.commands;

import com.itmo.app.Application;
import com.itmo.data.City;

import java.util.HashSet;
import java.util.Map;

/**
 * команда выводит доступные команды
 */
public class HelpCommand extends Command {
    private Application application;

    @Override
    public String execute(Application application) {
        this.application = application;
        return "Доступные команды: " + "\n" +
                new HelpCommand().getCommandInfo() + "\n" +
                new InfoCommand().getCommandInfo() + "\n" +
                new ShowCommand().getCommandInfo() + "\n" +
                new InsertCommand().getCommandInfo() + "\n" +
                new UpdateIdCommand().getCommandInfo() + "\n" +
                new RemoveKeyCommand().getCommandInfo() + "\n" +
                new ClearCommand().getCommandInfo() + "\n" +
                new ExecuteScriptCommand().getCommandInfo() + "\n" +
                new ExitCommand().getCommandInfo() + "\n" +
                new RemoveGreaterCommand().getCommandInfo() + "\n" +
                new RemoveGreaterKeyCommand().getCommandInfo() + "\n" +
                new RemoveLowerKeyCommand().getCommandInfo() + "\n" +
                new RemoveAllByGovernorCommand().getCommandInfo() + "\n" +
                new PrintAscendingCommand().getCommandInfo() + "\n" +
                new PrintFieldDescendingAgglomeration().getCommandInfo();
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
        return "help : выводит справку по доступным командам";
    }

    @Override
    public String toString() {
        return "help";
    }

    @Override
    public boolean withArgument() {
        return false;
    }
}
