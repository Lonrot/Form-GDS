package integration.controller;


import com.github.tomakehurst.wiremock.WireMockServer;
import integration.service.ServiceIntegration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Import;
import org.wiremock.spring.EnableWireMock;
import web.form.FormGdsApplication;
import web.form.model.AnnualReturnList;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = FormGdsApplication.class)
@Import(ServiceIntegration.class)
@EnableWireMock
class ServiceIntegrationTest {



    @BeforeEach
    void setUp() {
        WireMockServer server = new WireMockServer(options().port(8888).withRootDirectory("src/main/resources/wiremock"));
        server.start();
    }

    @Autowired
    private ServiceIntegration serviceIntegration;

    @Test
    void getAvailableARs() {
        String userID ="256653";
        AnnualReturnList annualReturnList = serviceIntegration.getAvailableARs(userID);
        assertNotNull(annualReturnList, "Error getting ARs");

    }

}