package com.app.ch11;

public class Main {

    public static void main(String[] args) {
        try {
            String s = null;
            s.toString();
            int t = 0;

        }catch (NullPointerException ex){
            System.out.println("nullopinter");
        }catch (Exception ex){
            System.out.println("exception");
        }catch(Throwable ex){
            System.out.println("throwable");
        }
    }

}
