package org.wwi23amb.util;

import java.util.Scanner;

public class ScannerHelper {
    private static Scanner myScanner;

    public ScannerHelper() {
        myScanner = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return myScanner;
    }
}
