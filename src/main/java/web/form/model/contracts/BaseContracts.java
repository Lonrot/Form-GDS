package web.form.model.contracts;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import web.form.model.Form;
import web.form.model.PageName;

@Getter @Setter
public abstract class BaseContracts implements Form {

    private static final PageName PAGE_ID = PageName.CONTRACTS;

    @NotNull(message = "Contract number cannot be empty")
    @Min(value = 1, message = "Contract number cannot be less than one")
    private Integer field1;

    @NotNull(message = "Contract number cannot be empty")
    @Min(value = 0, message = "Contract number cannot be empty")
    private Integer field2;

    @NotNull(message = "Contract number cannot be empty")
    @Min(value = 0, message = "Contract number cannot be empty")
    private Integer field3;

    @NotNull(message = "Contract number cannot be empty")
    @Min(value = 0, message = "Contract number cannot be empty")
    private Integer field4;

    @NotNull(message = "Contract number cannot be empty")
    @Min(value = 0, message = "Contract number cannot be empty")
    private Integer field5;

    @Override
    public PageName getPageID() {
        return PAGE_ID;
    }
}
