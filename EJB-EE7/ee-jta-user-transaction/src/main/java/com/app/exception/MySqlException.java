package com.app.exception;


import javax.ejb.ApplicationException;
import java.sql.SQLException;

@ApplicationException(rollback = true, inherited = true)
public class MySqlException extends SQLException {


    public MySqlException(Throwable cause) {
        super(cause);
    }

    public MySqlException(String message) {
        super(message);
    }
}
