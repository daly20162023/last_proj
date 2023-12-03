package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllOperators() {
        // Arrange
        Operator operator1 = new Operator(/* constructor parameters */);
        Operator operator2 = new Operator(/* constructor parameters */);
        List<Operator> operators = Arrays.asList(operator1, operator2);
        when(operatorRepository.findAll()).thenReturn(operators);

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(2, result.size());
        assertEquals(operator1, result.get(0));
        assertEquals(operator2, result.get(1));
    }
}
