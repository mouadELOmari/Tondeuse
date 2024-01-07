package com.tondeuse.application;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

    public class LectureFichierTest {


        private LectureFichier lectureFichier;

        @Before
        public void setUp() {
            lectureFichier = new LectureFichier();
        }

        @Test
        public void testLirePremiereLigneDuFichier() throws IOException {
            String input = "5 5";
            String result = lectureFichier.lirePremiereLigneDuFichier();
            assertEquals(input, result);
        }

        @Test
        public void testLireLesLignesDuFichier() throws IOException {
            List<String> result = lectureFichier.lireLesLignesDuFichier();
            List<String> expected = Arrays.asList("1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
            assertEquals(expected, result);
        }
    }
