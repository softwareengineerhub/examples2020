package com.app.dao;

import com.app.model.User;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonDataProcessor extends AbstractDataProcessor {

    @Override
    protected List<User> parse(InputStream in) {
        List<User> user = new ArrayList<>();
        user.add(new User("json", "jsonp", "jsonrole"));
        return user;
    }
}
