package com.company;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.*;

public class Exchange {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final Object LOCK = new Object();
    public static int time = 0;
    public static boolean isExchange = true;
    public static Share[] shares;
    public static Trader[] traders;

    public void setWorkingTime(int l) {
        time = (int) (l*60*1000);
    }

    public void addSharesForCompanies(Share[] givenShares) {
        shares = givenShares;

    }

    public void addTraders(Trader[] givenTraders) {
        traders = givenTraders;
    }

    public void startTrading() {
        System.out.println(LocalTime.now() + " - початок роботи біржі");
        new Thread(() -> {
            try {
                synchronized (LOCK) {
                    LOCK.wait(time);
                    endWorking();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Біржа").start();

        /*================================SHARE=================================================*/
        for(int j = 0; j < shares.length; j++) {

            int finalJ = j;
            new Thread(() -> {
                try {
                    synchronized (LOCK) {
                        while (isExchange) {
                            LOCK.wait(30 * 1000);
                            if (!isExchange) {
                                break;
                            }
                            System.out.println(ANSI_YELLOW + LocalTime.now() + " - акція " + shares[finalJ].getName() + " оновилася в ціні: " + shares[finalJ].changePrice() + ANSI_RESET);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Акція " + shares[finalJ].getName()).start();
        }

        /*================================TRADERS=================================================*/
        for(int j = 0; j < traders.length; j++) {
            int finalJ = j;
            new Thread(() -> {
                try {
                    synchronized (LOCK) {
                        while (isExchange) {
                            LOCK.wait(5 * 1000);
                            if (!isExchange) {
                                break;
                            }
                            /*====SHARE IN TRADER====*/
                            for(int d = 0; d < traders[finalJ].target.length; d++) {

                                Share share = traders[finalJ].target[d];

                                for (int i = 0; i < shares.length; i++) {
                                    if (Objects.equals(share.getName(), shares[i].getName()) && traders[finalJ].getShareStatus(shares[i])) {
                                        if (share.getPrice() == shares[i].getPrice()) {
                                            System.out.println(ANSI_GREEN + LocalTime.now() + " Спроба купівлі акції " + shares[i].getName() + " для " + traders[finalJ].getName() + " успішна." +
                                                    " Куплено" + share.getAmount() + "акцій" + ANSI_RESET);
                                            shares[i].setAmount(shares[i].getAmount() - share.getAmount());
                                            traders[finalJ].changeShareStatusToFalse(shares[i]);
                                        } else {
                                            System.out.println(LocalTime.now() + " Спроба купівлі акції " + shares[i].getName() + " для " + traders[finalJ].getName() + " не успішна");
                                        }
                                    }
                                }
                            }

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "трейдер " + traders[finalJ].getName()).start();
        }
    }

    public void endWorking(){
        System.out.println(LocalTime.now() + " - кінець роботи біржі");
        isExchange = false;
        printResults();
    }

    public void printResults() {

        new Thread(() -> {
            synchronized (LOCK) {
                try {
                    if(!isExchange){

                        System.out.println(ANSI_GREEN + "\nПІДСУМКИ");

                        for(int i = 0; i < traders.length; i++){
                            for(int j = 0; j < traders[i].target.length; j++){
                                if(!traders[i].getShareStatus(shares[j])){
                                    System.out.println("Трейдер " + traders[i].getName() + " купив " + traders[i].target[j].getAmount() + " акцій компанії "+ traders[i].target[j].getName());
                                }
                            }
                        }

                    } else {
                        LOCK.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Підсумок").start();

    }

}
