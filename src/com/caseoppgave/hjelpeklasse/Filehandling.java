package com.caseoppgave.hjelpeklasse;

import java.io.BufferedReader;
import java.io.FileReader;

public class Filehandling {

    // Metode for å lage et objekt av klassen BufferedReader
    // Representerer filen for lesing
    public static BufferedReader createReadConnection(String filename) {
        try {
            FileReader fileLink = new FileReader(filename);

            BufferedReader readBuffer = new BufferedReader(fileLink);

            return readBuffer;

        } catch(Exception e) {
            return null;
        }
    }
}
