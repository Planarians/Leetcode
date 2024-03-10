package com.company;

/**
 * @program: Leetcode
 * @description: 90min
 * @author: Mr.Wang
 * @create: 2024-03-10 17:32
 **/
public class ValidateIPAddress468M {
    static class Solution {
        public static String validIPAddress(String queryIP) {
            String[] xs = queryIP.split("\\.");
            String[] xs6 = queryIP.split(":");
            boolean isIpv4 = true;
            boolean isIpv6 = true;
            boolean isNither = false;
            char c = ' ';
            // for(String x: xs6){
            // System.out.println(x);
            // }

            if (queryIP.contains(".")) {
                isIpv6 = false;
                if (queryIP.charAt(queryIP.length() - 1) == '.') {//"12.33.33.4:"
                    return "Neither";
                }
                if(queryIP.contains("..")){//"12..33.4"
                    return "Neither";
                }
            } else if (queryIP.contains(":")) {
                isIpv4 = false;
                if (queryIP.charAt(queryIP.length() - 1) == ':') {//"2001:0db8:85a3:0:0:8A2E:0370:7334:"
                    return "Neither";
                }
                if(queryIP.contains("::")){//"2001:0db8:85a3::0:8A2E:0370:7334"
                    return "Neither";
                }
            }

            if (isIpv4) {
                if (xs.length != 4) {
                    return "Neither";
                }
                for (int i = 0; i < xs.length; i++) {
                    if (!ifIpv4(xs[i])) {
                        return "Neither";
                    }
                }
                return "IPv4";
            } else {
                if (isIpv6) {
                    if (xs6.length != 8) {
                        return "Neither";
                    }
                    for (int i = 0; i < xs6.length; i++) {
                        if (i == 0) {
                            if (!xs6[i].replaceFirst("^0+", "").equals(xs6[i])) {
                                System.out.println(xs6[i]);
                                return "Neither";
                            }
                        }
                        if (!ifIpv6(xs6[i])) {
                            System.out.println(xs6[i]);
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }


        }

        public static boolean ifIpv4(String s) {
            char c = ' ';
            if (s.equals("0")) {
                return true;
            }
            if (s.length() > 3) {
                return false;
            }
            if (!s.replaceFirst("^0+", "").equals(s)) {// 001 002 01
                return false;
            }
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if ('0' <= c && c <= '9') {
                } else {
                    return false;
                }
            }
            if (Integer.valueOf(s) <= 255) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean ifIpv6(String s) {
            char c = ' ';
            if (s.length() > 4) {
                return false;
            }
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if ('0' <= c && c <= '9') {
                } else if (c >= 'a' && c <= 'f') {

                } else if (c >= 'A' && c <= 'F') {

                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String queryIp="192.0.0.1";
        Solution.validIPAddress(queryIp);
    }
}
