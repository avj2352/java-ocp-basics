package com.scjp.www;

import org.springframework.boot.autoconfigure.SpringBootApplication;
// custom
import com.scjp.www.enums.ClientError;

@SpringBootApplication
public class Main {

    public static void main(String [] args) {
        System.out.println("Main Java " + ClientError.UNHANDLED_EXCEPTION);
    }
    
}
