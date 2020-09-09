package com.app01.ch04;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
       // List list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.get(list.size()-1));

        Object oldValue = list.set(1, "W");
        System.out.println("oldValue="+oldValue);
        System.out.println(list);

        System.out.println("--------------");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("--------------");
        for(Object item: list){
            System.out.println(item);
        }
        System.out.println("--------------");
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            Object item = itr.next();
            System.out.println(item);
            itr.remove();
        }
        System.out.println("--------------");
        System.out.println(list);
        System.out.println("-----------LinkedList-------------");
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("a");
        linkedList.addLast("b");
        Object val = linkedList.removeLast();
        val = linkedList.removeFirst();
        /*System.out.println("-------------------------");
        list.remove(0);
        list.remove(list.size()-1);
        list.add(0, "a");
        list.add( "a");
        list.add( 2, "a");*/

        System.out.println("-----------------------------");
        //list = Arrays.asList("A","B","C");
        list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        /*for(Object obj : list){
            if("B".equals(obj)){
                list.add("W");
            }
        }*/
        System.out.println(list);
        //fail fast iterator// ConcurrentModificationException
        System.out.println("----------------------------------");
        ListIterator listItr = list.listIterator(list.size());
        while(listItr.hasPrevious()){
            Object item = listItr.previous();
            System.out.println(item);
            //listItr.add("Q");
        }

    }

}
