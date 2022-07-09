package uz.ATM;

import org.json.simple.JSONArray;
import uz.ATM.Service.CardService;
import uz.ATM.Service.ServiceImplement;
import uz.ATM.model.MenuSelect;


import java.io.FileNotFoundException;
import java.util.Scanner;

import static uz.ATM.checkCardAndPin.CheckCard.checkID;

public class ATMMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        CardService serviceImpelement = new ServiceImplement();
        begin:
        while (true){
            System.out.println("0. Enter your card number, if exist");
            System.out.println("1. If you do not have a card. Sign up first, and get a card");
            switch (scanner.nextInt()){
                case 0 : {
                    System.out.println("Enter your card number : ");
                    String accountNum = scanner.nextLine();
                    JSONArray inserted = checkID();
                    MenuSelect.menuSelect(inserted);
                    break;
                }
                case 1 : {
                    System.out.println("Select the card type : ");
                    System.out.println(" 1. UZCARD \n 2. HUMO \n 3. VISA \n 4. MASTER CARD \n 5. UNION PAY \n 0. BACK");
                    int cardNum = scanner.nextInt();
                    if(cardNum == 0){
                        continue begin;
                    }
                    serviceImpelement.addCard(cardNum);
                }
            }
        }


    }
}





//id -> accountNum
