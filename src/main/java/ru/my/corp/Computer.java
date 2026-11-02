package ru.my.corp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Computer {
    private String model = "Gaming PC";
    
    class Processor {
        public void showModel() {
            System.out.println("Computer model: " + model);
        }
    }
    
    public static void main(String[] args) {
        Computer comp = new Computer();
        Computer.Processor proc = comp.new Processor();
        proc.showModel();
//        int x = 10;
//        System.out.println(x++);
        int x = 3;
        if (x > 2)
            System.out.print("A");
        else
            System.out.print("B");

        String text = "Java";
        System.out.println(text.charAt(2));
        System.out.println("5" + 2 + 3);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.clear();
        System.out.println(list.size());

        System.out.println(LocalDate.of(2025, 5, 15).plusDays(1));

        Stream.of("a", "b", "c")
                .filter(s -> s.equals("b"))
                .forEach(System.out::print);


    }
}
