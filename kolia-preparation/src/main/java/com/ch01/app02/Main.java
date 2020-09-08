package com.ch01.app02;

import com.ch01.app01.Parent;

public class Main {

    /*public static void main(String[] args) {
        Parent2 parent2 = new Parent2();
        Child2 child2 = new Child2();

        // IS-A --> CHILD IS-A parent
        Object obj = new Parent2();
        Object obj2 = new Child2();

        Parent2 parent = new Child2();

    }*/

    public static void main(String[] args) {
        /*Parent2 parent2 = findParent(2);
        parent2.doAction();*/

        Parent2 p2 = new Child2B();
        p2.doAction();

        Child2B child2B = (Child2B) p2;
        child2B.doAction("Denis");
    }


    private static Parent2 findParent(int type){
        switch(type){
            case 0:
                return new Parent2();
            case 1:
                return new Child2();
            default:
                return new ChildB();
        }
    }

}
