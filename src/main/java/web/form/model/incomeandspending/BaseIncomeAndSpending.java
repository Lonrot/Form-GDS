package web.form.model.incomeandspending;




import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import web.form.model.Form;
import web.form.model.PageName;


@Getter @Setter
public abstract class BaseIncomeAndSpending implements Form {

    @Getter
    private static final PageName PAGE_ID = PageName.INCOME_AND_SPENDING;


    @Min(value = 1)
    @Max(value = 5000, message = "Income cannot be more than 5000")
    @NotNull
    protected Integer income;

    @Min(value = 1)
    @Max(value = 5000, message = "Spending cannot be more than 5000")
    @NotNull
    protected Integer spending;

    @Override
    public  PageName getPageID() {
        return PAGE_ID;
    }

    @Override
    public String toString() {
        return "Income: " + this.income + " Spending: " + this.spending;
    }
}
