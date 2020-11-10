package com.app.bean;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface Summator {

    public int add(int a, int b);
}
