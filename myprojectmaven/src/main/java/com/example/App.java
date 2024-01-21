package com.example;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        String path = "persons.json";
        ArrayList<Person> persons = new ArrayList<>();
        Person a = new Person("John", "Dow", 34);
        Person b = new Person("Jane", "Dow", 29);
        System.out.println(a.toString());
        System.out.println(ToStringBuilder.reflectionToString(b));

        JSONHandler handler = new JSONHandler();
        handler.JSONWriter(handler.JSONSerialize(a), path);
        handler.JSONWriter(handler.JSONSerialize(b), path);
        persons = handler.JSONReader(path);
        System.out.println(persons.get(0));
        System.out.println(persons.get(1));

    }
}
