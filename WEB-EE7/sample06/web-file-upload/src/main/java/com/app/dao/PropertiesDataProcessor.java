package com.app.dao;

import com.app.model.User;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PropertiesDataProcessor extends AbstractDataProcessor {

    @Override
    protected List<User> parse(InputStream in) {
        try {
            List<User> users = new ArrayList<>();
            Properties props = new Properties();
            props.load(in);

            Set<Object> keys =  props.keySet();
            int i=0;
            while(true){
                if(keys.contains("username."+i)){
                    String username = props.getProperty("username."+i);
                    String password = props.getProperty("password."+i);
                    String role = props.getProperty("role."+i);
                    User user = new User(username, password, role);
                    users.add(user);
                    i++;
                }else{
                    break;
                }

            }
            return users;

        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
