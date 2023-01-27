package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        logger.log("Запускаем программу");


        logger.log("Введите размер списка N");
        String sizeList = reader.readLine();
        logger.log("Введите верхнюю границу значений элементов в списке M");
        String upperLimitValue = reader.readLine();

        logger.log("Создаем и наполняем список");
        List<Integer> listEnteredData = listEnteredData(sizeList, upperLimitValue);
        StringBuilder sb = new StringBuilder();
        sb.append("Полученный список: ");
        listEnteredData.forEach(value -> sb.append(value + " "));
        logger.log(sb.toString());

        logger.log("Введите порог для фильтра F");
        int limitFilter = Integer.parseInt(reader.readLine());
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(limitFilter);
        List<Integer> result = filter.filterOut(listEnteredData);
        sb.delete(0, sb.length());
        sb.append("Отфильтрованный список: ");
        result.forEach(value -> sb.append(value + " "));
        logger.log(sb.toString());

        logger.log("Завершаем программу");
    }

    public static List<Integer> listEnteredData(String n, String m) {
        List<Integer> allValues = new ArrayList<>();

        int sizeList = Integer.parseInt(n);
        int upperLimitValue = Integer.parseInt(m);

        Random random = new Random();
        for (int i = 0; i < sizeList; i++) {
            allValues.add(random.nextInt(upperLimitValue + 1));
        }
        return allValues;
    }
}