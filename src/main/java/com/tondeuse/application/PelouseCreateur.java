package com.tondeuse.application;

import com.tondeuse.application.utils.StringUtils;
import com.tondeuse.domain.Pelouse;

/**
 * La classe PelouseCreateur est responsable de la création d'une instance de Pelouse à partir d'une ligne d'entrée.
 */
public class PelouseCreateur {

    /**
     * Crée une pelouse à partir d'une ligne d'entrée.
     *
     * @param inputLine La ligne d'entrée représentant les dimensions de la pelouse.
     * @return Une instance de Pelouse avec les dimensions spécifiées.
     */
    public Pelouse creerPelouse(String inputLine) {
        // Supprimer les espaces blancs de la ligne d'entrée
        inputLine = StringUtils.removeAllWhitespaces(inputLine);

        // Extraire les dimensions de la pelouse à partir de la ligne d'entrée
        int largeur = Character.getNumericValue(inputLine.charAt(0));
        int longueur = Character.getNumericValue(inputLine.charAt(1));

        // Créer et retourner une nouvelle instance de Pelouse
        return new Pelouse(largeur, longueur);
    }
}
