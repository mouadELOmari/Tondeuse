package com.tondeuse.domain;

/**
 * L'énumération Instruction représente les différentes instructions possibles pour une tondeuse.
 * Chaque instruction est associée à une lettre : G (Gauche), D (Droite), A (Avancer).
 */
public enum Instruction {
    G("G"),
    D("D"),
    A("A");

    final String name;

    Instruction(String name) {
        this.name = name;
    }

    /**
     * Retourne l'instruction associée à la lettre spécifiée.
     *
     * @param instruction La lettre représentant l'instruction (G, D, A).
     * @return L'instruction correspondante.
     */
    public static Instruction get(char instruction) {
        return switch (instruction) {
            case 'G' -> G;
            case 'A' -> A;
            default -> D;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
