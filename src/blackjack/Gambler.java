package blackjack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gambler {
    private static final Logger LOGGER = LogManager.getRootLogger();
    static final String rutaFichero = "fichas.dat";

    Scanner sc = new Scanner(System.in);

    public ArrayList generateChips() {
        ArrayList<Chip> chips = new ArrayList<>();

        Chip chip5 = new Chip(20, Value.FIVE);
        chips.add(chip5);
        Chip chip10 = new Chip(15, Value.TEN);
        chips.add(chip10);
        Chip chip25 = new Chip(10, Value.TWENTY_FIVE);
        chips.add(chip25);
        Chip chip50 = new Chip(5, Value.FIFTY);
        chips.add(chip50);
        Chip chip100 = new Chip(3, Value.HUNDRED);
        chips.add(chip100);
        Chip chip500 = new Chip(1, Value.FIVE_HUNDRED);
        chips.add(chip500);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            oos.writeObject(chips);
        } catch (IOException e) {
            LOGGER.trace(e.getMessage());
        }
        return chips;
    }

    public ArrayList takeChips(String rutaFichero) {
        ArrayList takenChips = new ArrayList();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));
            takenChips = (ArrayList) ois.readObject();
        } catch (IOException e) {
            LOGGER.trace(e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.trace(e.getMessage());
        }
        return takenChips;
    }

    public ArrayList<Chip> addChip() {
        System.out.println("Bienvenido a la caja!\nCuantas fichas de 5 desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int fiveChips = sc.nextInt();
        System.out.println("Cuantas fichas de 10 desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int tenChips = sc.nextInt();
        System.out.println("Cuantas fichas de 25 desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int twentyFiveChips = sc.nextInt();
        System.out.println("Cuantas fichas de 50 desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int fiftyChips = sc.nextInt();
        System.out.println("Cuantas fichas de 100 desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int hundredChips = sc.nextInt();
        System.out.println("Introduzca la cantidad de fichas de 500 que desea obtener?(Si no desea fichas de este valor introduzca 0)");
        int fiveHundredChips = sc.nextInt();

        ArrayList<Chip> takenChips = takeChips(rutaFichero);
        ArrayList<Chip> addedChips = new ArrayList<>();

        Chip chip5 = new Chip(fiveChips, Value.FIVE);
        addedChips.add(chip5);

        Chip chip10 = new Chip(tenChips, Value.TEN);
        addedChips.add(chip10);

        Chip chip25 = new Chip(twentyFiveChips, Value.TWENTY_FIVE);
        addedChips.add(chip25);

        Chip chip50 = new Chip(fiftyChips, Value.FIFTY);
        addedChips.add(chip50);

        Chip chip100 = new Chip(hundredChips, Value.HUNDRED);
        addedChips.add(chip100);

        Chip chip500 = new Chip(fiveHundredChips, Value.FIVE_HUNDRED);
        addedChips.add(chip500);

        for (int i = 0; i < takenChips.size(); i++) {
            int chipQuantity = takenChips.get(i).getQuantity();
            Chip chip2 = addedChips.get(i);
            takenChips.get(i).setQuantity(chip2.getQuantity() + chipQuantity);
        }

        return takenChips;
    }

    public void saveChips(List<Chip> fichas, String rutaFichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            oos.writeObject(fichas);
        } catch (IOException e) {
            System.out.println("Error al guardar las fichas: " + e.getMessage());
        }
    }
}
