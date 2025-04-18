package web.form.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnnualReturn(String ARCycle, LocalDate ARCycleStartDate, LocalDate ARCycleEndDate) {
}
