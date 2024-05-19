package blackjack;

import java.util.Scanner;

public class SelectionMenu {
    Scanner sc = new Scanner(System.in);
    Gambler gambler = new Gambler();
    Table table = new Table();

    public void starterMenu() {
        int option;
        do {
            System.out.println("Bienvenido a nuestro casino Arvid!. Desea sentarse en una mesa?");
            System.out.println("""
                    1. Si (Admito todas las reponsabilidades de mis pedidas de dinero y no hago responsable al casino)
                    2. No (Le temo al exito y prefiero irme a casa)""");
            option = sc.nextInt();
        } while (option != 1 && option != 2);
        switch (option) {
            case 1:
                System.out.println("Ha acudido al casino alguna vez? 1.Si 2.No");
                int option2 = sc.nextInt();
                if (option2 == 1) {
                    System.out.println("Aqui tiene su stack de fichas de la última vez");
                    System.out.println(gambler.takeChips(Gambler.rutaFichero));
                } else if (option2 == 2) {
                    System.out.println("Aqui tiene su stack de fichas de cortesia");
                    System.out.println(gambler.generateChips());
                }
                if (option2 != 1 && option2 != 2) {
                    System.out.println("Entiendo que le tengas miedo al exito... Adios!");
                    break;
                }
                System.out.println("Desea empezar a jugar? 1.Si 2.No");
                int option3 = sc.nextInt();
                if (option3 == 1) {
                    table.startGame(table.gameChips);
                } else {
                    System.out.println("Entiendo que le tengas miedo al exito... Adios!");
                }
                break;
            default:
                System.out.println("Entiendo que le tengas miedo al exito... Adios!");
                break;
        }
    }
}