package com.bigcoach.fpu;

import java.io.IOException;
import java.io.InputStream;

public class SerialReader implements Runnable {
    InputStream in;

    public SerialReader(InputStream in) {
        this.in = in;
    }

    public void run() {
        byte[] buffer = new byte[10];
        int len;
        try {
            while ((len = this.in.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        try {
//        	int len;
//        	char input = 0;
//        	System.out.println(input);
//        	
//        	while((len = this.in.read()) != -1) {
//        		char charData = (char)len;
//        		System.out.println(charData);
//        		break;
//        	}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
