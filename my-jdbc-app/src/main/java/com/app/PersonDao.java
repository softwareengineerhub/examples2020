package com.app;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.*;

public class PersonDao {

    /*static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


    public void create(Person person) {
        Connection c = null;
        try {
            c = getConnection();
            Statement statement = c.createStatement();
            String sql = String.format("INSERT INTO person(name, age) VALUES('%s',%s)", person.getName(), person.getAge());
            statement.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void create2(Person person) {
        try (Connection c = getConnection();) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO person(name, age) VALUES(?,?)");
            //ps.setString(1, person.getName());
            //ps.setInt(2, person.getAge());
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Person> readAll() {
        try (Connection c = getConnection()) {
            List<Person> persons = new ArrayList();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                //int age = rs.getInt(1);
                //String name = rs.getString(2);

                Person person = new Person(name, age);
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long count() {
        try (Connection c = getConnection()) {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT count(*) FROM person");
            rs.next();
            return rs.getLong(1);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Person readById(int id) {
        try (Connection c = getConnection()) {
            String sql = "SELECT * FROM person WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int age = rs.getInt("age");
            String name = rs.getString("name");
            Person person = new Person(name, age);
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(int id, Person candidate) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("UPDATE person SET name=?, age=? WHERE id=?");
            ps.setObject(3, id);
            ps.setObject(1, candidate.getName());
            ps.setObject(2, candidate.getAge());
            ps.execute();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public void deleteById(int id) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM person WHERE id=?");
            ps.setObject(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteAll() {
        try (Connection c = getConnection()) {
            c.prepareStatement("DELETE FROM person").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createBulk(List<Person> persons) {
        for (Person p : persons) {
            create2(p);
        }
    }


    public void createBulk2(Person personA, Person personB) {
        try (Connection c = getConnection()) {
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("INSERT INTO person(name, age) VALUES(?,?)");
            ps.setObject(1, personA.getName());
            ps.setObject(2, personA.getAge());
            ps.execute();
            ps = c.prepareStatement("INSERT INTO person(name, age) VALUES(?,?)");
            ps.setObject(1, personB.getName());
            ps.setObject(2, personB.getAge());
            String s = null;
            s.toString();
            ps.execute();
            c.commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public List<Map<String, Object>> metaData() {
        try (Connection c = getConnection()) {
            ResultSet rs = c.prepareStatement("SELECT * FROM person").executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int n = resultSetMetaData.getColumnCount();
            Set<String> columnNames = new HashSet();
            for (int i = 0; i < n; i++) {
                String columnName = resultSetMetaData.getColumnName(i + 1);
                columnNames.add(columnName);
            }

            List<Map<String, Object>> result = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> columnData = new HashMap<>();
                for (String columnName : columnNames) {
                    Object value = rs.getObject(columnName);
                    columnData.put(columnName, value);
                }
                result.add(columnData);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample-app?useSSL=false", "root", "11111111");
    }

}

