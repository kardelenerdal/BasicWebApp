package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

// kardelen
@Service
public class QueryProcessor {

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
            int num1 = Integer.parseInt(parts[parts.length - 1]);
            String num2 = parts[parts.length - 2];
            int num2int = Integer.parseInt(num2.substring(0, num2.length() - 1));
            return Integer.toString(Math.max(num1, num2int));
        } else if (query.contains("plus")) {
            String[] parts = query.split(" ");
            int num1 = Integer.parseInt(parts[2]);
            int num2 = Integer.parseInt(parts[4]);
            return Integer.toString(num1 + num2);
        } else {
            return "";
        }
    }
}
