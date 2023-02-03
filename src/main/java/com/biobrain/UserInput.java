package com.biobrain;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;


public class UserInput {
    private List<String> commands;
    private List<String> objects;

    public static void WordCommands(List<String> wordList) throws IOException {
        String noun;
        String verb;

        try (Reader reader = new InputStreamReader(UserInput.class.getClassLoader().getResourceAsStream("jsonFiles/userInput.json"))) {
            Gson gson = new Gson();
            UserInput input = gson.fromJson(reader, UserInput.class);

            while (true) {
                System.out.println("Choose a command: ");
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine().trim();
                String[] words = userInput.split(" ");

                verb = words[0];
                noun = words[1];

                if (words.length != 2) {
                    System.out.println("Please enter a valid command of two words\n");
                } else if (!input.commands.contains(verb)) {
                    System.out.printf("%s not on list of valid commands\n", verb);
                }
                if (!input.objects.contains(noun)) {
                    System.out.printf("%s not on list of valid commands\n", noun);
                } else
                    break;
            }
        }

    }
}









