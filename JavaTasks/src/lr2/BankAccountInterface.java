package lr2;

interface BankAccountInterface {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class BankAccount implements BankAccountInterface {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Неверная сумма для депозита.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств или неверная сумма для снятия.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(1000);
        System.out.println("Текущий баланс: " + account.getBalance());

        account.withdraw(500);
        System.out.println("Текущий баланс: " + account.getBalance());

        account.withdraw(600);
        System.out.println("Текущий баланс: " + account.getBalance());

    }
}
