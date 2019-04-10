package com.example.fragmentswithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public  static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people= new ArrayList<Person>();

        people.add(new Person("Ahmet","554656545"));
        people.add(new Person("Mehmet","554656545"));
        people.add(new Person("Ali","554656545"));
        people.add(new Person("Ayşe","554656545"));
        people.add(new Person("Anıl","554656545"));
        people.add(new Person("Orkun","554656545"));
        people.add(new Person("Devo","554656545"));
        people.add(new Person("Emir","554656545"));
        people.add(new Person("Ciino","554656545"));
        people.add(new Person("Kalkar","554656545"));


    }
}
