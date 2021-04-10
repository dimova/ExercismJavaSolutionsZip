public class BankAccount {
    private long balance;
    private boolean open = false;

    public BankAccount(){}

    public void open(){open = true;}

    public long getBalance() throws BankAccountActionInvalidException {
        if(open==false) throw new BankAccountActionInvalidException("Account closed");
        return balance;
    }

    public synchronized void deposit(int d) throws BankAccountActionInvalidException {
        if(open==false) throw new BankAccountActionInvalidException("Account closed");
        if(d<0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance+=d;
    }

    public synchronized void withdraw(int w) throws BankAccountActionInvalidException {
        if(open==false) throw new BankAccountActionInvalidException("Account closed");
        if(balance==0) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        if(balance<w) throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        if(w<0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        balance-=w;
    }

    public void close(){open=false;}
}
