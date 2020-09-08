package com.app.ch14;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        //arr = new int[4];
        //arr[0]=10;
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1,2,3,4};
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr==arr2);
        System.out.println(arr.equals(arr2));
        System.out.println(Arrays.equals(arr, arr2));
        System.out.println("-----------------------");
        /*Object[] data = new Object[4];
        data[0] = new Child14();
        data[1] = new Parent14();
        for(Object obj: data){
            obj.toString();
        }*/


        /*Object[] data = new Parent14[4];
        //Object[] data = new Child14[4];
        //data[0] = "";
        data[0] = new Child14();
        data[1] = new Parent14();
        data[2] = new Child14();
        for(Object obj: data){
            System.out.println(obj);
        }*/


        Parent14[] data = new Child14[3];
        //Object[] data = new Child14[4];
        //data[0] = "";
        data[0] = new Child14();
        data[1] = new Parent14();
        data[2] = new Child14();
        for(Object obj: data){
            System.out.println(obj);
        }







    }

}
