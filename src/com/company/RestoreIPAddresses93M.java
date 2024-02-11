package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-09 00:37
 **/
public class RestoreIPAddresses93M {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        String ip = "";
        String[] res = new String[4];

        if(s.length()<4){
            return list;
        }

        for (int i = 0; i < 3; i++) {//1
            String sc = new String(s);
            ip = "";
            res[0] = sc.substring(0, i + 1);
            if (!ifAddress(res[0])) {
                break;
            }
            for (int j = 0; j < 3; j++) {//2
                if (sc.length() < 3) {
                    break;
                }
                if (sc.length() - 1 >= i + 1 && sc.length() >= i + 1 + j + 1) {
                    res[1] = sc.substring(i + 1, i + 1 + j + 1);
                } else {
                    break;
                }
                if (!ifAddress(res[1])) {
                    break;
                }
                for (int j1 = 0; j1 < 3; j1++) {//3
                    if (sc.length() < 2) {
                        break;
                    }
                    if (sc.length() - 1 >= i + 1 + j + 1 && sc.length() >= i + 1 + j + 1 + j1 + 1) {
                        res[2] = sc.substring(i + 1 + j + 1, i + 1 + j + 1 + j1 + 1);
                    } else {
                        break;
                    }
                    if (ifAddress(res[2])) {
                        if (sc.length() - 1 >= i + 1 + j + 1 + j1 + 1) {
                            res[3] = sc.substring(i + 1 + j + 1 + j1 + 1);
                        } else {
                            continue;
                        }
                        if (!(res[3].length()>3)&&ifAddress(res[3])) {
                            ip = res[0] + "." + res[1] + "." + res[2] + "." + res[3];
                            list.add(ip);
                        } else {
                            continue;
                        }
                    } else {
                        break;
                    }


                }

            }
        }

        return list;
    }

    public static boolean ifAddress(String res) {
        int resNumber = 0;
        if (res.length() == 0) {
            return false;
        }

        resNumber = Integer.valueOf(res);
        if (resNumber <= 255 && resNumber >= 0 && res.equals(String.valueOf(resNumber))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "0279245587303";
        System.out.println(restoreIpAddresses(s));

    }

}
