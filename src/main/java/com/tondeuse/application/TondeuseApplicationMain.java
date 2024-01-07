package com.tondeuse.application;


import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe principale de l'application Tondeuse.
 * Cette classe contient la méthode principale "main" qui lance l'exécution du contrôleur de tondeuse.
 */
public class TondeuseApplicationMain {
    private static final Logger LOGGER = Logger.getLogger(TondeuseApplicationMain.class.getName());

    public static void main(String[] args) {
        String positionFinale = TondeuseController.getPositionFinale();
        LOGGER.log(Level.INFO, "La position finale est {0}", positionFinale);
    }
}
