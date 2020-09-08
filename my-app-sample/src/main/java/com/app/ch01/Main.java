package com.app.ch01;

import com.sun.scenario.effect.impl.state.GaussianRenderState;

public class Main {

    public static void main(String[] args) {
        /*Child child = new Child();
        Parent parent = new Parent();
        GrantParent gp = new GrantParent();

        GrantParent grantParent = new Child();
        //Child child1 = new Parent();*/


        GrantParent gp =getGrantParent(2);
        System.out.println("------------------");
        new Child();

    }


    private static GrantParent getGrantParent(int type){
        switch(type){
            case 0:
                return new GrantParent();
            case 1:
                return new Parent();
            default:
                return new Child();
        }
    }
}
