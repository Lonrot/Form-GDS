package web.form.model.incomeandspending;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseIncomeAndSpending {


    @Min(value = 1)
    @Max(value = 5000, message = "Income cannot be more than 5000")
    @NotNull
    private int income;

    @Min(value = 1)
    @Max(value = 5000, message = "Spending cannot be more than 5000")
    @NotNull
    private int spending;

    @Override
    public String toString() {
        return "Income: " + this.income + " Spending: " + this.spending;
    }
}
