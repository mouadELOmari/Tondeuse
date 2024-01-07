package com.tondeuse.application;

import com.tondeuse.application.utils.StringUtils;
import com.tondeuse.domain.Instruction;
import com.tondeuse.domain.Orientation;
import com.tondeuse.domain.Position;
import com.tondeuse.domain.Tondeuse;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe TondeuseCreateur est responsable de la création des objets Tondeuse
 * à partir des lignes de position et d'instructions.
 */
public class TondeuseCreateur {

    /**
     * Message d'exception pour une ligne de position vide ou null.
     */
    private final static String EXCEPTION_MESSAGE_LIGNE_VIDE = "La ligne de position est vide ou null.";

    /**
     * Crée une liste de tondeuses à partir des lignes de position et d'instructions.
     *
     * @param lignes Les lignes de position et d'instructions.
     * @return Une liste d'objets Tondeuse.
     * @throws IllegalArgumentException Si la ligne de position est vide ou null.
     */
    public List<Tondeuse> creerTondeusesDepuisLignes(List<String> lignes) {
        List<Tondeuse> tondeuses = new ArrayList<>();
        for (int i = 0; i < lignes.size(); i += 2) {
            String positionLine = lignes.get(i);
            String instructionsLine = lignes.get(i + 1);
            Tondeuse tondeuse = creerTondeuseDesLignes(positionLine, instructionsLine);
            tondeuses.add(tondeuse);
        }
        return tondeuses;
    }

    /**
     * Crée un objet Tondeuse à partir des lignes de position et d'instructions.
     *
     * @param positionLine      La ligne de position.
     * @param instructionsLine  La ligne d'instructions.
     * @return Un objet Tondeuse.
     * @throws IllegalArgumentException Si la ligne de position est vide ou null.
     */
    public Tondeuse creerTondeuseDesLignes(String positionLine, String instructionsLine) {
        // Vérifier si positionLine est vide ou null
        if (positionLine == null || positionLine.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_LIGNE_VIDE);
        }
        positionLine = StringUtils.removeAllWhitespaces(positionLine);
        int horizontal = Character.getNumericValue(positionLine.charAt(0));
        int vertical = Character.getNumericValue(positionLine.charAt(1));
        Orientation orientation = Orientation.get(positionLine.charAt(2));

        Position position = new Position(horizontal, vertical, orientation);
        List<Instruction> instructions = parserInstructions(instructionsLine);

        return new Tondeuse(position, instructions);
    }

    /**
     * Parse la ligne d'instructions et renvoie une liste d'objets Instruction.
     *
     * @param ligne La ligne d'instructions.
     * @return Une liste d'objets Instruction.
     */
    public List<Instruction> parserInstructions(String ligne) {
        List<Instruction> instructions = new ArrayList<>();
        for (char instructionChar : ligne.toCharArray()) {
            Instruction enumInstruction = Instruction.get(instructionChar);
            instructions.add(enumInstruction);
        }
        return instructions;
    }
}
