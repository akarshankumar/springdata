package com.spring.springdata.functional;

import com.spring.springdata.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("Peter", 40, Arrays.asList("8", "9")), new User("Sam", 10, Arrays.asList("1", "2")), new User("Greg", 20, Arrays.asList("3","4","5")), new User("Ryan", 30, Arrays.asList("6","7")));

//        names.stream()
//                .filter(Filter::isNotSam)
//                .map(name -> new User(name, 10))
//                .forEach(System.out::println);
//
//        List<User> users = names.stream()
//                .filter(Filter::isNotSam)
//                .map(name -> new User(name, 10))
//                .collect(Collectors.toList());
//
//        OptionalInt sum = users.stream()
//                .mapToInt(user -> user.getAge())
//                .min();
//
//        System.out.println("Sum " + sum.getAsInt());

        Optional<String> phoneNumber = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(phoneStream -> phoneStream.filter(phoneNumer -> phoneNumer.equals("5")))
                .findAny();

        phoneNumber.ifPresent(System.out::println);



    }

    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }

    @Data
    @AllArgsConstructor
    static class User {
        String name;
        Integer age;
        List<String> phoneNumbers;

        @Override
        public String toString(){
            return "name:" + name + " age: " + age;
        }
    }
}

