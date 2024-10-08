package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.repositories.EmployeeRepository;
import com.helloWorld.beautyShop.services.implementation.EmployeeImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeImpTest {

    @InjectMocks
    private EmployeeImp employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldSaveEmployee() {

        EmployeeModel newEmployee = new EmployeeModel();

        when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);

        EmployeeModel savedEmployee = employeeService.saveEmployee(newEmployee);

        assertEquals(newEmployee.getEmployeeId(), savedEmployee.getEmployeeId());
    }

    @Test
    public void shouldNotAllowShortVisitorInAttraction() {

        AttractionModel newAttraction = new AttractionModel();
        VisitorModel shortVisitor = new VisitorModel();

        shortVisitor.setHeight(1.45F);
        newAttraction.setMinHeightAllowed(1.5F);

        assertEquals(employeeService.isVisitorHeightAllowed(shortVisitor.getHeight(), newAttraction.getMinHeightAllowed()), false);
    }

    @Test
    public void shouldAllowTallVisitorInAttraction() {

        AttractionModel newAttraction = new AttractionModel();
        VisitorModel shortVisitor = new VisitorModel();

        shortVisitor.setHeight(1.85F);
        newAttraction.setMinHeightAllowed(1.5F);

        assertEquals(employeeService.isVisitorHeightAllowed(shortVisitor.getHeight(), newAttraction.getMinHeightAllowed()), true);
    }

    @Test
    public void shouldReturnFalseWhenTicketHasNoBalance() {

        TicketModel newTicket = new TicketModel();
        newTicket.setTicketBalance(0);

        assertEquals(employeeService.hasVisitorTicketBalance(newTicket.getTicketBalance()), false);
    }

    @Test
    public void shouldReturnTrueWhenTicketHasBalance() {

        TicketModel newTicket = new TicketModel();
        newTicket.setTicketBalance(3);

        assertEquals(employeeService.hasVisitorTicketBalance(newTicket.getTicketBalance()), true);
    }

}