package ru.netology;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private int num = 1;
    private static Logger instance;

    private Logger() {
    }

    // Вывод сообщений в консоль с текущей датой и временем с порядковым номером
    void log(String msg) {
        // Формат даты и времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        // Текущая дата и время с учетом форматирования
        String formatDateTime = LocalDateTime.now().format(formatter);
        System.out.println("[" + formatDateTime + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
