package com.tondeuse.domain;

/**
 * L'énumération Orientation représente les différentes orientations possibles d'une tondeuse.
 * Chaque orientation est associée à une lettre : N (Nord), E (Est), O (Ouest), S (Sud).
 */
public enum Orientation {
    N("N"),
    E("E"),
    O("O"),
    S("S");

    final String name;

    Orientation(String name) {
        this.name = name;
    }

    /**
     * Retourne l'orientation associée à la lettre spécifiée.
     *
     * @param orientation La lettre représentant l'orientation (N, E, O, S).
     * @return L'orientation correspondante.
     */
    public static Orientation get(char orientation) {
        char upperCaseOrientation = Character.toUpperCase(orientation);
        return switch (upperCaseOrientation) {
            case 'E' -> E;
            case 'W' -> O;
            case 'S' -> S;
            default -> N;
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
