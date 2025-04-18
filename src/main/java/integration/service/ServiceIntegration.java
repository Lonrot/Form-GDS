package integration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import web.form.model.AnnualReturnList;
import wiremock.org.apache.commons.lang3.StringUtils;

@Service
public class ServiceIntegration {

    private final RestClient restClient;

    public ServiceIntegration(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8888").build();
    }

    public AnnualReturnList getAvailableARs(String userID){
        if(userID == null || userID.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        } else if(!StringUtils.isAlpha(userID)) {
            throw new IllegalArgumentException("User ID must contains only numbers, ID used: " + userID + " ");
        }

        return this.restClient.get().uri("/api/available-ars/{userID}",userID).retrieve().body(AnnualReturnList.class);
    }
}
