package blackjack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Table {
    Scanner sc = new Scanner(System.in);
    Gambler gambler = new Gambler();
    ArrayList<Chip> gameChips = gambler.takeChips(Gambler.rutaFichero);
    ArrayList<Chip> betChips = new ArrayList<>(); // Almacena las fichas apostadas
    Hand hand = new Hand();
    SelectionMenu selectionMenu = new SelectionMenu();
    private static final Logger LOGGER = LogManager.getRootLogger();


    public void startGame(ArrayList<Chip> gameChips) {
        try {
            System.out.println("Bienvenido a la mesa de blackjack, para empezar a jugar debe apostar un minimo para recibir sus cartas.");
            gameChips = requestBet(gameChips);
            gestionCartas();
            System.out.println("Fichas restantes: " + gameChips.toString());
            System.out.println("Fichas apostadas: " + betChips.toString());
            int doubleBet;
            do {
                System.out.println("Desea doblar su apuesta? 1.Si 2.No");
                doubleBet = sc.nextInt();
            } while (doubleBet != 1 || doubleBet != 2);
        } catch (InputMismatchException e) {
            LOGGER.trace(e.getMessage());
            System.out.println("Se ha equivocado al introducir un valor, hemos detectado una falla. Reiniciamos la partida...");
            selectionMenu.starterMenu();
        }
        //TODO Gestion de duplicar la apuesta que este en el arrayList de betChips cada vez que quiera robar, cada vez que se apueste se debe robar
        // comprobar que la suma de los valores de sus cartas es menor que 21 o si no pierde todas las fichas de betChips
        // añadir el arrayList de betChips al arrayList de gameChips y guardarlo en su fichero, preguntar si quiere volver a jugar y volverle directamente a inicio partida

    }

    public ArrayList<Chip> requestBet(ArrayList<Chip> gameChips) {
        int betSize;
        int betQuantity;
        do {
            System.out.println("Ingrese el tamaño de las fichas (5, 10, 25, 50, 100, 500)");
            betSize = sc.nextInt();
        } while (betSize != 5 && betSize != 10 && betSize != 25 && betSize != 50 && betSize != 100 && betSize != 500);

        do {
            System.out.println("A continuacionla cantidad de fichas de dicho tamaño");
            betQuantity = sc.nextInt();
        } while (betQuantity < 0);
        ArrayList<Chip> newChips = refreshChips(gameChips, betSize, betQuantity);
        if (newChips == null) {
            System.out.println("No tiene suficientes fichas para realizar esta apuesta");
            return requestBet(gameChips);
        } else {
            betChips.add(new Chip(betQuantity, Value.getValue(betSize)));
            return newChips;
        }
    }

    public void gestionCartas() {
        ArrayList<Deck> dealerInitialHand = hand.getDealerInitialHand();
        ArrayList<Deck> gamblerInitialHand = hand.getGamblerInitialHand();
        System.out.println("Cartas del crupier: " + dealerInitialHand.toString());
        System.out.println("Cartas del jugador: " + gamblerInitialHand.toString());
        Deck dealer = new Deck(dealerInitialHand.get(0).getValue(), dealerInitialHand.get(0).getSuit());
        Deck gambler = new Deck(gamblerInitialHand.get(0).getValue(), gamblerInitialHand.get(0).getSuit());
        ArrayList<Deck> valorDelaer = new ArrayList<>();
        ArrayList<Deck> valorGambler = new ArrayList<>();
        //TODO Bucle for para recorrer el arraylist de los valores añadiendolos llamando al metodo deck.getValue();

        System.out.println(dealer.getValue());
        System.out.println(gambler.getValue());
    }

    public ArrayList<Chip> refreshChips(ArrayList<Chip> gameChips, int betSize, int betQuantity) {
        ArrayList<Chip> chips = new ArrayList<>(gameChips);
        for (Chip chip : chips) {
            if (chip.getValue().getValue() == betSize) {
                int newQuantity = chip.getQuantity() - betQuantity;
                if (newQuantity < 0) {
                    return null;
                } else {
                    chip.setQuantity(newQuantity);
                }
            }
        }
        return chips;
    }
}
