package web.core.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.form.service.IncomeAndSpendingService;

import java.util.List;

@Component
public class IncomeAndSpendingServiceFactory {

    private final List<IncomeAndSpendingService> services;

    @Autowired
    public IncomeAndSpendingServiceFactory(List<IncomeAndSpendingService> services) {
        this.services = services;
    }

    public IncomeAndSpendingService getService(String year) {
        return services.stream()
                .filter(service -> service.supportedYear().equals(year))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No service found for year: " + year));
    }
}
