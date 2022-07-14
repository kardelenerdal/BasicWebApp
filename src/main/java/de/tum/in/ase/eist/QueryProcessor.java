package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

// kardelen
@Service
public class QueryProcessor {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Kardelen";
        } else if (query.contains("largest")) {
            String[] parts = query.split(" ");
            int max = 0;
            for (String x : parts) {
                if (x.charAt(0) <= '9' && x.charAt(0) >= '0') {
                    if (x.charAt(x.length() - 1) == ',') {
                        x = x.substring(0, x.length() - 1);
                    }
                    if (Integer.parseInt(x) > max) {
                        max = Integer.parseInt(x);
                    }
                }
            }
            return Integer.toString(max);
        } else if (query.contains("plus")) {
            String[] parts = query.split(" ");
            int num1 = Integer.parseInt(parts[2]);
            int num2 = Integer.parseInt(parts[4]);
            return Integer.toString(num1 + num2);
        } else if (query.contains("multiplied")) {
            String[] parts = query.split(" ");
            int num1 = Integer.parseInt(parts[2]);
            int num2 = Integer.parseInt(parts[5]);
            return Integer.toString(num1 * num2);
        } else if (query.contains("square") && query.contains("cube")) {
            String[] parts = query.split(" ");
            int res = 0;
            for (String x : parts) {
                if (x.charAt(0) <= '9' && x.charAt(0) >= '0') {
                    if (x.charAt(x.length() - 1) == ',') {
                        x = x.substring(0, x.length() - 1);
                    }
                    int num = Integer.parseInt(x);
                    double sqrt = Math.sqrt(num);
                    double cubeRoot = Math.cbrt(num);
                    if (sqrt - Math.floor(sqrt) == 0 && Math.round(cubeRoot) == cubeRoot) {
                        res = num;
                        break;
                    }
                }
            }
            return Integer.toString(res);
        } else if (query.contains("primes")) {
            String[] parts = query.split(" ");
            int res = 0;
            for (String x : parts) {
                if (x.charAt(0) <= '9' && x.charAt(0) >= '0') {
                    if (x.charAt(x.length() - 1) == ',') {
                        x = x.substring(0, x.length() - 1);
                    }
                    if (isPrime(Integer.parseInt(x))) {
                        res = Integer.parseInt(x);
                    }
                }
            }
            return Integer.toString(res);
        } else if (query.contains("eiffel")) {
            return "Paris";
        } else {
            return "";
        }
    }
}
