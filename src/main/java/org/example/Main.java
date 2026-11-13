package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        List<Employee> duplicates = new LinkedList<>();
        Set<Integer> added = new HashSet<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            counts.put(emp.getId(), counts.getOrDefault(emp.getId(), 0) + 1);
            if (counts.get(emp.getId()) > 1 && added.add(emp.getId())) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : list) {
            if (emp != null) {
                map.putIfAbsent(emp.getId(), emp);
            }
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Employee emp : list) {
            if (emp != null) {
                counts.put(emp.getId(), counts.getOrDefault(emp.getId(), 0) + 1);
            }
        }
        List<Employee> uniques = new LinkedList<>();
        for (Employee emp : list) {
            if (emp != null && counts.get(emp.getId()) == 1) {
                uniques.add(emp);
            }
        }
        return uniques;
    }
}
