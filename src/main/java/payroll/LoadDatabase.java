package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Richard", "Hendricks", "Founder"));
            employeeRepository.save(new Employee("Erlich", "Bachman", "Co-Founder"));
            employeeRepository.save(new Employee("Bertram", "Gilfoyle", "Principal Engineer"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded: " + employee));

            orderRepository.save(new Order("Galaxy s23 Ultra", Status.COMPLETED));
            orderRepository.save(new Order("B&O Beoplay Ex", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded: " + order));
        };
    }
}
