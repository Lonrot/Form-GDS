package integration.controller;


import com.github.tomakehurst.wiremock.WireMockServer;
import integration.service.ServiceIntegration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Import;
import org.wiremock.spring.EnableWireMock;
import web.form.FormGdsApplication;
import web.form.model.initialpage.AnnualReturnArray;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = FormGdsApplication.class)
@Import(ServiceIntegration.class)
@EnableWireMock
class ServiceIntegrationTest {

    private WireMockServer server;


    @BeforeEach
    void setUp() {
        server = new WireMockServer(options().port(8888).withRootDirectory("src/main/resources/wiremock"));
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Autowired
    private ServiceIntegration serviceIntegration;

    @Test
    void getAvailableARs() {
        String userID = "256653";
        AnnualReturnArray annualReturnArray = serviceIntegration.getAvailableARs(userID);
        assertNotNull(annualReturnArray, "Error getting ARs");
    }

    @Test
    void getAvailableARs_nullUserID() {
        String userID = null;
        String expectedMessage = "User ID cannot be null or empty";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            serviceIntegration.getAvailableARs(userID);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            serviceIntegration.getAvailableARs(userID);
        });
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void getAvailableARs_invalidUserID() {
        String userID = "256653a";
        String expectedMessage = "User ID must contains only numbers, ID used: 256653a ";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            serviceIntegration.getAvailableARs(userID);
        });
        assertTrue(exception.getMessage().contains(expectedMessage));
        assertThrows(IllegalArgumentException.class, () -> {
            serviceIntegration.getAvailableARs(userID);
        });
    }


}