package com.tondeuse.application;

import com.tondeuse.application.exception.FichierIntrouvableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe LectureFichier est responsable de la lecture des données à partir d'un fichier.
 */
public class LectureFichier {

    private static final Logger LOGGER = Logger.getLogger(LectureFichier.class.getName());

    private static final String INPUT_FILE_PATH = "src/resources/fichier.txt";
    private static final String EXCEPTION_FICHIER_INTROUVABLE = "Le fichier n'existe pas : ";
    private static final String LOG_DEBUT_EXTRACTION = "Début d'extraction des données";

    /**
     * Lit la première ligne du fichier.
     *
     * @return La première ligne du fichier.
     * @throws IOException                En cas d'erreur lors de la lecture du fichier.
     * @throws FichierIntrouvableException Si le fichier n'est pas trouvé.
     */
    public String lirePremiereLigneDuFichier() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_FILE_PATH))) {
            LOGGER.log(Level.INFO, LOG_DEBUT_EXTRACTION);
            return reader.readLine();
        } catch (NoSuchFileException e) {
            throw new FichierIntrouvableException(EXCEPTION_FICHIER_INTROUVABLE + INPUT_FILE_PATH, e);
        }
    }

    /**
     * Lit toutes les lignes du fichier après la première ligne.
     *
     * @return Une liste de chaînes représentant chaque ligne du fichier.
     * @throws IOException                En cas d'erreur lors de la lecture du fichier.
     * @throws FichierIntrouvableException Si le fichier n'est pas trouvé.
     */
    public List<String> lireLesLignesDuFichier() throws IOException {
        List<String> lignes = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT_FILE_PATH))) {
            // sauter la première ligne (dimension pelouse)
            reader.readLine();
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (NoSuchFileException e) {
            throw new FichierIntrouvableException(EXCEPTION_FICHIER_INTROUVABLE + INPUT_FILE_PATH, e);
        }
        return lignes;
    }

}
