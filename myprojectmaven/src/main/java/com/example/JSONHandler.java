package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class JSONHandler {
    public String JSONSerialize(Person person) {
        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);
        return jsonString;
    }
    public void JSONWriter (String str, String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(str);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Person JSONDeserialize(String str) {
        Gson gson = new GsonBuilder().create();
        Type type = new Type() {}.getClass();
        Person person = gson.fromJson(str, Person.class);
        return person;
    }
    public ArrayList<Person> JSONReader(String path) {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                persons.add(JSONDeserialize(scanner.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
