package com.tondeuse.application;

import com.tondeuse.domain.Pelouse;
import com.tondeuse.domain.Position;
import com.tondeuse.domain.Tondeuse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La classe TondeuseController est responsable de la gestion des tondeuses,
 * de la lecture des données, et de la récupération des positions finales.
 */
public class TondeuseController {
    private static final Logger LOGGER = Logger.getLogger(TondeuseController.class.getName());
    private static final String ERREUR_LECTURE_EXCEPTION = "Une erreur s'est produite lors de la lecture des données.";

    /**
     * Récupère les positions finales des tondeuses après lecture des données.
     *
     * @return Une chaîne représentant les positions finales des tondeuses.
     */
    public static String getPositionFinale() {
        try {
            // Initialisation des créateurs et du lecteur de fichier
            LectureFichier lectureFichier = new LectureFichier();
            PelouseCreateur pelouseCreateur = new PelouseCreateur();
            TondeuseCreateur tondeuseCreator = new TondeuseCreateur();

            // Lecture de la première ligne pour définir les limites de la pelouse
            String pelouseLimit = lectureFichier.lirePremiereLigneDuFichier();
            Pelouse maPelouse = pelouseCreateur.creerPelouse(pelouseLimit);

            // Lecture des lignes de chaque tondeuse
            List<String> tondeuseLignes = lectureFichier.lireLesLignesDuFichier();
            List<Tondeuse> tondeuses = tondeuseCreator.creerTondeusesDepuisLignes(tondeuseLignes);

            // Déplacement de chaque tondeuse et récupération des positions finales
            Position finalPosition;
            StringBuilder result = new StringBuilder();
            for (Tondeuse tondeuse : tondeuses) {
                finalPosition = tondeuse.deplacer(maPelouse);
                result.append(finalPosition.toString());
            }
            return result.toString();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, ERREUR_LECTURE_EXCEPTION, e);
            return "";
        }
    }
}
