package com.app.dao;

import com.app.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonDataProcessor extends AbstractDataProcessor {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected List<User> parse(InputStream in) {
        try {
            return Arrays.asList(mapper.readValue(in, User[].class));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
