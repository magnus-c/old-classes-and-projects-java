
public class Money {

	private int dollars;
	private int cents;
	
	//constructor
	public Money add(Money m) {
		int dol = m.dollars + dollars;
		int cent = m.cents+cents;
		Money answer = new Money(dol, cent);
		return answer;
		
	}
	
	public Money() {
		dollars = 0;
		cents = 0;
	}
	public Money(int dollar, int cent) {
        dollars = dollar;
        cents = cent;
        normalize();
    }
	public Money subtract(Money m) {
        int dol = dollars - m.dollars;
        int cent = cents - m.cents;

        while (cent < 0) {
            dol--;
            cent = cent+100;
        }
        Money answer = new Money(dol, cent);
        return answer;
    }
	public Money multiply(int m) {
		int dol = dollars * m;
		int cent = cents * m;
		Money answer = new Money(dol, cent);
		return answer;
	}
	public static Money[] multiply(Money[] moneys, int amt) {
        Money[] answer = new Money[moneys.length];
        for(int i = 0; i < moneys.length; i++) {
            answer[i] = new Money(moneys[i].getDollars(), moneys[i].getCents());
            answer[i].dollars = answer[i].getDollars() * amt;
            answer[i].cents = answer[i].getCents() * amt;
            answer[i].normalize();
        }
        return answer;
	}
	public boolean equals(Money money) {
		if(dollars == money.dollars) {
			if(cents == money.cents) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
        return String.format("$%d.%02d", dollars, cents);
    }
	private void normalize() {
		dollars = dollars + cents / 100;
        cents = cents % 100;
    }
	
	//getters and setters
	public int getDollars() {
		return dollars;
	}
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}
	public int getCents() {
		return cents;
	}
	public void setCents(int cents) {
		this.cents = cents;
	}
}

