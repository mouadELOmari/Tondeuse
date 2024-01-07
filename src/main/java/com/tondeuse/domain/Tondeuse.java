package com.tondeuse.domain;

import java.util.List;

/**
 * Représente une tondeuse dans le système.
 */
public class Tondeuse {

    /**
     * La position actuelle de la tondeuse.
     */
    private final Position position;

    /**
     * Les instructions à suivre par la tondeuse.
     */
    private final List<Instruction> instructions;

    /**
     * Constructeur de la classe Tondeuse.
     *
     * @param position     La position initiale de la tondeuse.
     * @param instructions Les instructions à suivre par la tondeuse.
     */
    public Tondeuse(Position position, List<Instruction> instructions) {
        this.position = position;
        this.instructions = List.copyOf(instructions);
    }

    /**
     * Avance la tondeuse dans la pelouse en fonction de ses instructions.
     *
     * @param pelouse La pelouse sur laquelle la tondeuse se déplace.
     * @return La nouvelle position de la tondeuse après exécution des instructions.
     */
    public Position deplacer(Pelouse pelouse) {
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case A -> avancer(pelouse);
                case G -> tournerAGauche();
                case D -> tournerADroite();
            }
        }
        return new Position(position.getX(), position.getY(), position.getOrientation());
    }

    /**
     * Avance la tondeuse d'une case dans la direction actuelle.
     *
     * @param pelouse La pelouse sur laquelle la tondeuse se déplace.
     */
    private void avancer(Pelouse pelouse) {
        position.avancer(pelouse);
    }

    /**
     * Tourne la tondeuse à droite.
     */
    private void tournerADroite() {
        position.tournerADroite();
    }

    /**
     * Tourne la tondeuse à gauche.
     */
    private void tournerAGauche() {
        position.tournerAGauche();
    }

    /**
     * Récupère la position actuelle de la tondeuse.
     *
     * @return La position actuelle de la tondeuse.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Récupère les instructions à suivre par la tondeuse.
     *
     * @return Les instructions à suivre par la tondeuse.
     */
    public List<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tondeuse tondeuse = (Tondeuse) o;

        if (!position.equals(tondeuse.position)) return false;
        return instructions.equals(tondeuse.instructions);
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + instructions.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Tondeuse{" +
                "position=" + position +
                ", instructions=" + instructions +
                '}';
    }
}
