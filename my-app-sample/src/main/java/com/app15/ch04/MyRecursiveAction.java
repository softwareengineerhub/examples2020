package com.app15.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private int taskSize;
    private String name;

    public MyRecursiveAction(int taskSize, String name) {
        this.taskSize = taskSize;
        this.name=name;
    }

    @Override
    protected void compute() {
        if (taskSize <= 2) {
         //   System.out.println("\t"+name+"Completed!!!");
        } else {
            System.out.println(name+"tasks size=" + taskSize);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<MyRecursiveAction> subTasks = initSubTasks();
            for (MyRecursiveAction action : subTasks) {
                action.fork();
            }
            for (MyRecursiveAction action : subTasks) {
                action.join();
            }

        }
    }


    private List<MyRecursiveAction> initSubTasks() {
        List<MyRecursiveAction> list = new ArrayList<>();
        list.add(new MyRecursiveAction(taskSize / 2, "\t"+name));
        list.add(new MyRecursiveAction(taskSize - taskSize / 2, "\t"+name));
        return list;
    }


}
