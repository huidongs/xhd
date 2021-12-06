package deadlock;

/**
 * @Author xhd
 * @Date 2021-06-07
 * @Des: 演示转账
 */
public class TransferMoney implements Runnable {
    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 2;
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("a账户余额：" + a.balance);
        System.out.println("b账户余额：" + b.balance);
    }

    public static void transferMoney(Account from, Account to, int amount) {
        class Helper {
            public void Transfer() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                } else {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("转账成功");
                }
            }

        }
        int hashFrom = System.identityHashCode(from);
        int hashTO = System.identityHashCode(to);
        if (hashFrom < hashTO) {
            synchronized (from) {
                synchronized (to) {
                    new Helper().Transfer();
                }
            }
        }else if (hashFrom>hashTO){
            synchronized (to) {
                synchronized (from) {
                    new Helper().Transfer();
                }
            }
        }else {
            synchronized (lock){

            }

        }

    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 2) {
            transferMoney(b, a, 200);
        }
    }

    static class Account {
        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }
}
