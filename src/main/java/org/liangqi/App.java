package org.liangqi;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        OffsetDateTime ab = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");

        String valueString = ((String) "2021-10-06T10:15:32+0900").trim();
        //2021-10-06T10:15:32+0900
        String offsetPart = valueString.substring(valueString.lastIndexOf('+') + 1);
        if (offsetPart.length() == 4) {
            valueString = valueString.substring(0, valueString.length() - 2) + ":" + valueString.substring(valueString.length() - 2);
        }
        OffsetDateTime a = OffsetDateTime.parse(valueString);


        Function<String, Integer> fun = (x) -> x.length();
        Function<Integer, Integer> fun1 = (x) -> x + 1;
        Function<Integer, Integer> fun2 = (x) -> x + 1;
        Integer da = fun.andThen(fun1).andThen(fun2).apply("abc");
        System.out.println(String.format("abc %s cdc", a));

        Map<String, Integer> my = new HashMap<String, Integer>();
        my.merge("test", 1, (count, incre) -> count + incre);
        my.merge("test", 1, Integer::sum);
        my.merge("test", 1, Integer::max);
        my.compute("test", (k, v) -> (v == 2) ? 3 : 1);
        System.out.println(my);

        Map<String, String> my1 = new HashMap<String, String>();
        LinkedHashMap<String,String> dd = new LinkedHashMap<String,String>();

        Stream<String> str = Stream.of("a","b","c");
        List<String> list = str.filter(n -> n.equals("a")).collect(Collectors.toList());
        System.out.println("list:" + list);

//        OptionalInt reduced =
//                IntStream.range(1, 4).reduce(10, (c,b) -> c+b );
//        System.out.println("rrr:" + reduced);

    }
}



