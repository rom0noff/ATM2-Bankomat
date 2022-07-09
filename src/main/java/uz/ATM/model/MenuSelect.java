package uz.ATM.model;

import org.json.simple.JSONArray;
import uz.ATM.Service.CardService;
import uz.ATM.Service.ServiceImplement;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static uz.ATM.checkCardAndPin.CheckCard.checkPin;

public class MenuSelect {
    public static void menuSelect(JSONArray inserted) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        CardService cardService = new ServiceImplement();
        if (inserted != null) {
            if (checkPin(inserted)) {
                while (true) {
                    System.out.println("======-==MENU==-======");
                    System.out.println("1. Money transfer");
                    System.out.println("2. Check balance");
                    System.out.println("3. Income and expenditure history");
                    System.out.println("4. Exchange rates");
                    System.out.println("0. Exit");

                    switch (scanner.nextInt()) {
                        case 1: {
                            cardService.throwMoney(inserted);
                            break;
                        }
                        case 2: {
                            cardService.seeBalance(inserted);
                            break;
                        }
                        case 3 : {
                            cardService.historyCard(inserted);
                            break;
                        }
                        case 4 : {
                            cardService.exchangeInfo();
                        }
                        case 0 : {
                            return;
                        }
                        default:
                            System.err.println("Error number.");
                    }
                }
            }
        }
    }
}
