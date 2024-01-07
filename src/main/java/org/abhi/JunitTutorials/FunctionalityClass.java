package org.abhi.JunitTutorials;

public class FunctionalityClass {
    public String truncateAInFirst2Positions(String str){

        if (str.length()<=2)return str.replaceAll("A","");
        String first2Chars = str.substring(0,2);
        String stringMinusFirst2Chars = str.substring(2);
        return first2Chars.replaceAll("A","") + stringMinusFirst2Chars;
    }

    public boolean evenOrOdd(int number){
        if ((number&1)==0)return true;
        else return false;
    }

    public int[] reverseArray(int[] arr){
        int temp=0;
        System.out.println("Before Reverse");
        for (int x : arr){
            System.out.print(x + " ");
        }
        for (int i=0;i<arr.length/2;i++){
            temp=arr[i];
            arr[i]=arr.length-i;
            arr[arr.length-i-1]=temp;
        }
        System.out.println("\nAfter Reverse");
        for (int x : arr){
            System.out.print(x + " ");
        }
        return arr;
    }
}
