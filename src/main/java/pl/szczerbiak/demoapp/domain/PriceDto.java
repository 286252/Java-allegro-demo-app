package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceDto {
    private final double amount;
    private final String currency;

    @Override
    public String toString() {
        return "PriceDto{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @JsonCreator
    public PriceDto(@JsonProperty("amount") double amount,
                            @JsonProperty("currency") String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
