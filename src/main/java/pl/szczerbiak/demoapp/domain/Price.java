package pl.szczerbiak.demoapp.domain;

public class Price {
    private final double amount;

    private final String currency;

    public Price(double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.amount, amount) == 0
                && currency.equals(price.currency);
    }

//    @Override
//    public int hashCode(){
//        return Object.hash(amount,currency);
//    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
