package web.form.gds.webapp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class PeriodConfirmation {

    @Getter
    @Setter
    private LocalDate startDate;
    @Getter@Setter
    private LocalDate endDate;

    public PeriodConfirmation() {
        startDate = LocalDate.now().minusDays(90);
        endDate = LocalDate.now().plusDays(120);

    }
}
