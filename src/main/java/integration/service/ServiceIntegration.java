package integration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import web.form.model.AnnualReturnList;

@Service
public class ServiceIntegration {

    private final RestClient restClient;

    public ServiceIntegration(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://localhost:8888").build();
    }

    public AnnualReturnList getAvailableARs(String userID){
        return this.restClient.get().uri("/api/available-ars/{userID}",userID).retrieve().body(AnnualReturnList.class);
    }
}
