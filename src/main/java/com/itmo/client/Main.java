package com.itmo.client;


import com.itmo.app.Handler;
import com.itmo.commands.*;
import com.itmo.exceptions.WithoutArgumentException;

import java.io.IOException;
import java.util.*;

/**
 * маршаллизация входных данных, создание обработчика команд и установка команд для него, создание приложения и его запуск
 */
public class Main {
    private static Client activeClient = null;

    public static Client getActiveClient() {
        return activeClient;
    }

    public static void main(String[] args) {
        try {
            if (args.length < 2) throw new WithoutArgumentException();
            String host = args[0];
            int port = Integer.parseInt(args[1]);

            Handler handler = new Handler();
            Client client = new Client();
            activeClient = client;
            client.connect(host, port);
            handler.setClient(client);
            client.setHandler(handler);
            System.out.println("Клиент-серверное приложение для управления коллекцией объектоов");
            System.out.println("Для просмотра доступных команд введите help, для выхода - exit");
            handler.run(new Scanner(System.in));
        } catch (WithoutArgumentException e) {
            System.out.println("Запускайте клиента с двумя аргументами: <host> <port>");
        } catch (NumberFormatException e) {
            System.out.println("Порт - это целое число!!!");
        } catch (IllegalArgumentException e) {
            System.out.println("Введите корректный номер порта...");
        } catch (IOException e) {
            System.out.println("Проблемы с подключением, проверьте корректны ли аргументы программы...");
            e.printStackTrace();
        }
    }
}
