package pl.szczerbiak.demoapp;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class plikTestowy {

    //private static final Logger logger = LoggerFactory.getLoggerFactory();

    @Test
    public void should(){
       // List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> numbers = IntStream
                .rangeClosed(1,10000)
                .boxed()
                .collect(Collectors.toList());
        var value = numbers
                .stream()
                .filter(v -> v % 2 == 0)
                //.filter(x -> x <= 1000)
                .reduce(0,Integer::sum);
        System.out.println("Value: " + value);
    }

    @Test
    public void Str(){
        IntStream
                .range(1,10)
                .boxed()
                .map(value -> gett(value))
                .parallel()
                .forEach(valaue -> System.out.println(valaue));
    }

    private Object gett(Integer value){
        try {
            Thread.sleep(500);
            int result = value * 2;
            System.out.println(Thread.currentThread() + "Callculated value: " + result);
            return result;
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }



}
