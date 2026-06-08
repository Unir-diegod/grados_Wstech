package com.wastech.uni;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptGenerator {
    public static void main(String[] args) {
        System.out.println("HASH_GENERADO=" + new BCryptPasswordEncoder().encode("admin123"));
    }
}
