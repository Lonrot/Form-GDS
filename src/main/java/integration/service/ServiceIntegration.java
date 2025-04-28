package integration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import web.form.model.initialpage.AnnualReturn;
import web.form.model.initialpage.AnnualReturnArray;
import wiremock.org.apache.commons.lang3.StringUtils;

@Service
@Slf4j
public class ServiceIntegration {

    private final RestClient restClient;

    public ServiceIntegration(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8888").build();
    }

    //I prefer a validator factory instead of this but no time I just want to implement basic checking :D
    //I just hope god forgive my sins
    public AnnualReturnArray getAvailableARs(String userID) {
        if (userID == null || userID.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        } else if (!StringUtils.isNumeric(userID)) {
            throw new IllegalArgumentException("User ID must contains only numbers, ID used: " + userID + " ");
        }

        AnnualReturnArray annualReturnArray = this.restClient.get()
                .uri("/api/available-ars/{userID}", userID)
                .retrieve()
                .body(AnnualReturnArray.class);

        assert annualReturnArray != null;
        log.info("Retrieved a total of {} ARs", annualReturnArray.annualReturns().length);
        for (AnnualReturn annualReturn : annualReturnArray.annualReturns()) {
            log.info("AR cycle: {}, start date: {}, end date: {}, completed: {}, next to complete: {}", annualReturn.getARCycle(), annualReturn.getARCycleStartDate(), annualReturn.getARCycleEndDate(), annualReturn.getCompleted(), annualReturn.getNextToComplete());
        }
        return annualReturnArray;
    }
}

