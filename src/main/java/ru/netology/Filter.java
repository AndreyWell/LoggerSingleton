package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        int count = 0;
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        // Отбор значений из переданного List, которые не меньше значения поля threshold
        for (Integer i : source) {
            if (i < this.threshold) {
                logger.log("Элемент \"" + i + "\" не проходит");
            } else {
                logger.log("Элемент \"" + i + "\" проходит");
                result.add(i);
                count++;
            }
        }
        logger.log("Прошло фильтр " + count + " элементов (-а) из " + source.size());

        return result;
    }
}
