package com.app.common;

import java.io.Serializable;
import java.util.Date;

public class PersonResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String status;
    private Date date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
