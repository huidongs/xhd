package deadlock;
import java.util.Random;

/**
 * @Author xhd
 * @Date 2021-06-07
 * @Des:
 */
public class MultiTransferMoney {
    private static final int NUM_ACCOUNTS = 500;
    private static final int NUM_MONEY = 1000;
    private static final int NUM_ITERATIONS = 100000000;
    private static final int NUM_THREADS = 20;

    public static void main(String[] args) {
        Random rnd = new Random();
        TransferMoney.Account[] accounts = new TransferMoney.Account[NUM_ACCOUNTS];
        for (int i = 0 ;i< accounts.length;i++){
            accounts[i] = new TransferMoney.Account(NUM_MONEY);
        }
        class TransferThread extends Thread{

            @Override
            public void run() {
                for (int i = 0;i<NUM_ITERATIONS;i++){
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int amount = rnd.nextInt(NUM_MONEY);
                    TransferMoney.transferMoney(accounts[fromAcct],accounts[toAcct],amount);
                }
            }
        }
        for (int i= 0;i<NUM_THREADS;i++){
            new TransferThread().start();
        }
    }
}
