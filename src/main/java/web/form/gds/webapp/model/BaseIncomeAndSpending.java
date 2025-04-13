package web.form.gds.webapp.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public abstract class BaseIncomeAndSpending {
    @Min(value = 1)
    @Max(value = 5000, message = "Income cannot be more than 5000")
    @NotNull
    private int income;

    @Min(value = 1)
    @Max(value = 5000, message = "Spending cannot be more than 5000")
    @NotNull
    @Valid
    private int spending;

    @Override
    public String toString() {
        return "Income: " + this.income + " Spending: " + this.spending;
    }
}