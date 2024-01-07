package com.tondeuse.domain;

/**
 * Représente la pelouse où les tondeuses se déplacent.
 *
 * @param largeur  Largeur de la pelouse.
 * @param longueur Longueur de la pelouse.
 */
public record Pelouse(int largeur, int longueur) {

    /**
     * Constructeur de la classe Pelouse.
     *
     * @throws IllegalArgumentException Si la largeur ou la longueur est négative.
     */
    public Pelouse {
        if (largeur < 0 || longueur < 0) {
            throw new IllegalArgumentException("La largeur et la longueur doivent être positives");
        }
    }

    /**
     * Récupère la largeur de la pelouse.
     *
     * @return La largeur de la pelouse.
     */
    @Override
    public int largeur() {
        return largeur;
    }

    /**
     * Récupère la longueur de la pelouse.
     *
     * @return La longueur de la pelouse.
     */
    @Override
    public int longueur() {
        return longueur;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Pelouse{" +
                "largeur=" + largeur +
                ", longueur=" + longueur +
                '}';
    }
}
