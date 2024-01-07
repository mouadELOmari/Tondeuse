package com.tondeuse.domain;

/**
 * Représente la position d'une tondeuse sur une pelouse.
 */
public class Position {

    /**
     * Coordonnée X de la position.
     */
    private int x;

    /**
     * Coordonnée Y de la position.
     */
    private int y;

    /**
     * Orientation de la tondeuse.
     */
    private Orientation orientation;

    /**
     * Constructeur de la classe Position.
     *
     * @param x           La coordonnée X de la position.
     * @param y           La coordonnée Y de la position.
     * @param orientation L'orientation de la tondeuse.
     */
    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Avance la tondeuse d'une case dans la direction actuelle.
     *
     * @param pelouse La pelouse sur laquelle la tondeuse se déplace.
     */
    void avancer(Pelouse pelouse) {
        int deltaX = 0;
        int deltaY = 0;

        switch (this.getOrientation()) {
            case N -> deltaY = 1;
            case E -> deltaX = 1;
            case O -> deltaX = -1;
            case S -> deltaY = -1;
        }
        // la position ne peut en aucun cas dépasser les limites de la pelouse
        int nouveauX = Math.max(0, Math.min(this.x + deltaX, pelouse.largeur()));
        int nouveauY = Math.max(0, Math.min(this.y + deltaY, pelouse.longueur()));

        this.x = nouveauX;
        this.y = nouveauY;
    }

    /**
     * Tourne la tondeuse à droite.
     */
    void tournerADroite() {
        switch (this.orientation) {
            case N -> orientation = Orientation.E;
            case E -> orientation = Orientation.S;
            case O -> orientation = Orientation.N;
            case S -> orientation = Orientation.O;
        }
    }

    /**
     * Tourne la tondeuse à gauche.
     */
    void tournerAGauche() {
        switch (this.orientation) {
            case N -> orientation = Orientation.O;
            case E -> orientation = Orientation.N;
            case O -> orientation = Orientation.S;
            case S -> orientation = Orientation.E;
        }
    }

    /**
     * Récupère la coordonnée X de la position.
     *
     * @return La coordonnée X de la position.
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère la coordonnée Y de la position.
     *
     * @return La coordonnée Y de la position.
     */
    public int getY() {
        return y;
    }

    /**
     * Récupère l'orientation de la tondeuse.
     *
     * @return L'orientation de la tondeuse.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "" + x + y + orientation + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + orientation.hashCode();
        return result;
    }
}
