package com.company;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-15 13:20
 **/
public class MultiplyStrings43M {
    public static String multiply(String num1, String num2) {
        String longS = "";
        String shortS = "";
        String output="";
        int res=0;
        int [] a=new int[num1.length()+num2.length()];
        if (num1.length() >= num2.length()) {
            longS = num1;
            shortS = num2;
        } else {
            longS = num2;
            shortS = num1;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        for (int i = shortS.length() - 1,k=0; i >= 0; i--,k++) {
            for (int j = longS.length() - 1,k1=0; j >= 0; j--,k1++) {
                res=(shortS.charAt(i)-'0')*(longS.charAt(j)-'0');
                a[k1+k]=a[k1+k]+res;
            }
        }
        for(int i=0;i<shortS.length()+longS.length();i++){
            if(a[i]>=10){
                a[i+1]+=a[i]/10;
                a[i]=a[i]%10;
            }
            output=String.valueOf(a[i])+output;
        }
        return output.replaceFirst("^0+", "");
    }
        public static String multiply0(String num1, String num2) {
            int add=0;
            int add2=0;
            int res=0;
            int cur=0;
            String output="0";
            String resString="";
            String longS="";
            String shortS="";
            if(num1.length()>=num2.length()){
                longS=num1;
                shortS=num2;
            }else{
                longS=num2;
                shortS=num1;
            }
            if(num1.equals("0")||num2.equals("0")){
                return "0";
            }

            for(int i=shortS.length()-1,k=0;i>=0;i--,k++){
                for(int j=longS.length()-1;j>=0;j--){
                    res=(shortS.charAt(i)-'0')*(longS.charAt(j)-'0');
                    cur=res%10;
                    resString=String.valueOf((cur+add)%10+add2)+resString;
                    if(cur+add>=10){
                        add2=(cur+add)/10;
                    }else{
                        add2=0;
                    }
                    add=res/10;
                }
                if(add!=0||add2!=0){
//                    if(resString.charAt(0)=='0'){
//                        resString=resString.substring(1);
//                    }
                    resString=String.valueOf(add+add2)+resString;
                }
//                if(add2!=0){
//                    resString=String.valueOf(add2)+resString;
//                }

                //add 0
                for(int l=0;l<k;l++){
                    resString=resString+"0";
                }

                output=add(output,resString);
                System.out.println(resString);
                System.out.println("output="+output);
                add=0;
                add2=0;
                resString="";
            }
            return output;
        }

        public static String add(String a,String b){
            String longS="";
            String shortS="";
            String output="";
            int res=0;
            int add=0;
            int sum=0;
            int num1=0;
            int num2=0;
            if(a.length()>=b.length()){
                longS=a;
                shortS=b;
            }else{
                longS=b;
                shortS=a;
            }
            for(int i=longS.length()-1, j=shortS.length()-1;i>=0;i--,j--){
                if(j<0){
                    num2=0;
                }else{
                    num2=shortS.charAt(j)-'0';
                }
                num1=longS.charAt(i)-'0';
                sum=add+num1+num2;
                add=sum/10;
                res=sum%10;
                output=String.valueOf(res)+output;
            }

            if(add==1){
                output="1"+output;
            }

            return output;
        }

    public static void main(String[] args) {
            //408
        String a="123";
//        String b="987654321";
        String b="456";
        System.out.println(multiply(a,b));

//        System.out.println(add("76500","19890"));
//        for(int i=1;i<=9;i++){
//            System.out.println(i*123456789);
//        }
    }

    /**
     Multiply the current digits from shortS and longS, and add the result to the corresponding index in the array a.
     This step simulates the multiplication process performed manually.

     After completing the multiplication, iterate over the array a from left to right to handle any carries and build the final result string output.

     Finally, return the result string, removing any leading zeros using output.replaceFirst("^0+", "").


     */

}
