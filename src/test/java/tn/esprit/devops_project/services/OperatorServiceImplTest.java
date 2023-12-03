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
    @Test
    void testAddOperator() {
        // Arrange
        Operator operator = new Operator(/* constructor parameters */);
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator);

        // Act
        Operator result = operatorService.addOperator(operator);

        // Assert
        assertEquals(operator, result);
        verify(operatorRepository, times(1)).save(operator);
    }
    @Test
    void testDeleteOperator() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        operatorService.deleteOperator(idToDelete);

        // Assert
        verify(operatorRepository, times(1)).deleteById(idToDelete);
    }
    @Test
    void testUpdateOperator() {
        // Arrange
        Operator operatorToUpdate = new Operator(/* set constructor parameters */);
        when(operatorRepository.save(any(Operator.class))).thenReturn(operatorToUpdate);

        // Act
        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);

        // Assert
        verify(operatorRepository, times(1)).save(operatorToUpdate);
        assertEquals(operatorToUpdate, updatedOperator);
    }

}
