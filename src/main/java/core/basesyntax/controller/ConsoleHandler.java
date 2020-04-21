package core.basesyntax.controller;

import core.basesyntax.model.Bet;
import core.basesyntax.db.Storage;

import java.util.Scanner;

public class ConsoleHandler {
    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(value, risk);
                Storage.bets.add(bet);
                System.out.println(bet.toString());
            } catch (Exception e) {
                System.out.println("Please enter correct values!");
            }
        }
    }
}
