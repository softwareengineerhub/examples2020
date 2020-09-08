package com.app.ch11;

public class Main2 {

    public static void main(String[] args) {
        try {
            int a = 10;
            int t = 0;
            int res = a/t;

        }catch (NullPointerException ex){
            System.out.println("nullopinter");
        }catch (Exception ex){
            System.out.println("exception");
            ex.printStackTrace();
        }catch(Throwable ex){
            System.out.println("throwable");
        }
    }

}
