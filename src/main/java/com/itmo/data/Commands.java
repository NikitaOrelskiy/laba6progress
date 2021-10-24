package com.itmo.data;


import java.io.Serializable;

public class Commands implements Serializable {
    String commandName;
    City payload;
    Long key;
    Human governor;
    Object o;

    public Commands(String commandName, Object o) {
        this.commandName = commandName;
        this.o = o;
    }


    public Commands() {

    }
}
