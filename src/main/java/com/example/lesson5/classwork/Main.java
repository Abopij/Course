package com.example.lesson5.classwork;

import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>(8);
        map.put("Russia", "Moscow");
        map.put("USA", "New-York");
        map.put("Ukraine", "Kiev");

         for (Map.Entry<String, String> o : map.entrySet()) {
             System.out.println(o.getKey() + " " + o.getValue());
         }

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(); // сохраняет порядок добавления (не сортирует)
        TreeMap<String, String> treeMap = new TreeMap<>(); // упорядочен по ключу

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("B");
        set.add("A");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Hashtable<String, String> hashtable = new Hashtable<>();
        Vector<String> vector = new Vector<>();

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "D", "E"));
        /*
        for (String o : list) {
            if (o.equals("C")) {
                list.remove(o); // ConcurrentModificationException
            }
        }
        */

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("C")) {
                list.remove(i); // ошибки уже нет, но не удалит все C, так как коллекция съезжает на одну
                // i--;
            }
        }

        System.out.println(list);

        ListIterator<String> lis = list.listIterator(); // больше возможностей (добавить, удалить) по сравнению с Iterator

        

    }
}