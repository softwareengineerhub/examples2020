package com.app.dao;

import com.app.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProcessor extends AbstractDataProcessor {

    public static final String SEPARATOR = ",";

    @Override
    protected List<User> parse(InputStream in) {

        List<User> users = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] maybeUser = line.split(SEPARATOR);
                if (maybeUser.length > 2) {
                    User user = new User(maybeUser[0], maybeUser[1], maybeUser[2]);
                    users.add(user);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
