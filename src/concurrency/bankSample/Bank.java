package concurrency.bankSample;

public class Bank implements Runnable {
	private Account account;

	public Bank(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			account.subtractAmount(1000);
		}
	}

}
