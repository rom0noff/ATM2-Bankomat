package uz.ATM.Service;

import org.json.simple.JSONArray;

import java.io.FileNotFoundException;

public interface CardService {
    void addCard(int cardNumber) throws FileNotFoundException;
    void historyCard(JSONArray inserted) throws FileNotFoundException;
    void throwMoney(JSONArray inserted);
    void seeBalance(JSONArray inserted);
    void exchangeInfo();
}
