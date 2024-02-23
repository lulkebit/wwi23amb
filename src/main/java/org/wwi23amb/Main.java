package org.wwi23amb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wwi23amb.users.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static Map<?, ?> map = new HashMap<>();

    public static void main(String[] args) {
//        createUser();
        loadUsers();
        interaction();
    }

    private static void interaction() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!checkAccount(username, password)) {
            System.out.println("Username and/or password incorrect. Try again!");
            interaction();
        }


    }

    private static boolean checkAccount(String username, String password) {
        boolean exists = false;

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == "username" && entry.getValue() == username) {
                exists = true;
                break;
            }
        }

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == "username" && entry.getValue() == username) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    private static void loadUsers() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("users.json"));

            map = gson.fromJson(reader, Map.class);

            System.out.println(map);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void createUser() {
        User[] users = new User[] {
                new User(1, "Mike", "America"),
                new User(2, "Tom", "Canada")
        };

        try (FileWriter out = new FileWriter("users.json")) {
            gson.toJson(users, out);
            System.out.println("done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}