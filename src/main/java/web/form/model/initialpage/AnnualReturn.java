package web.form.model.initialpage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnualReturn {

    @JsonProperty("ARCycle")
    String ARCycle;

    @JsonProperty("ARCycleStartDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate ARCycleStartDate;

    @JsonProperty("ARCycleEndDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate ARCycleEndDate;

    @JsonProperty("completed")
    Boolean completed;

    Boolean nextToComplete = false;

    String ARCycleStartDateFormatted;
    String ARCycleEndDateFormatted;


}
