package web.form.gds.webapp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public abstract class BaseIncomeAndSpending {
    @Min(value = 1)
    @NotNull
    private int income;

    @Min(value = 1)
    @NotNull
    private int spending;

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }

    @Override
    public String toString() {
        return "Income: " + this.income + " Spending: " + this.spending;
    }
}