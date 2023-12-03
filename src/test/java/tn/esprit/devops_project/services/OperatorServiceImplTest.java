package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    public void testRetrieveAllOperators() {
        // Arrange
        Operator operator1 = new Operator(/* constructor parameters */);
        Operator operator2 = new Operator(/* constructor parameters */);
        List<Operator> operators = Arrays.asList(operator1, operator2);
        when(operatorRepository.findAll()).thenReturn(operators);

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testAddOperator() {
        // Arrange
        Operator operator = new Operator(/* constructor parameters */);
        when(operatorRepository.save(Mockito.any())).thenReturn(operator);

        // Act
        Operator result = operatorService.addOperator(operator);

        // Assert
        assertEquals(operator, result);
    }

    @Test
    public void testDeleteOperator() {
        // Arrange
        Long id = 1L;

        // Act
        operatorService.deleteOperator(id);

        // Assert
        verify(operatorRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateOperator() {
        // Arrange
        Operator operator = new Operator(/* constructor parameters */);

        // Act
        Operator result = operatorService.updateOperator(operator);

        // Assert
        verify(operatorRepository, times(1)).save(operator);
        assertEquals(operator, result);
    }

    @Test
    public void testRetrieveOperator() {
        // Arrange
        Long id = 1L;
        Operator operator = new Operator(/* constructor parameters */);
        when(operatorRepository.findById(id)).thenReturn(Optional.of(operator));

        // Act
        Operator result = operatorService.retrieveOperator(id);

        // Assert
        assertEquals(operator, result);
    }

    @Test
    public void testRetrieveOperatorNotFound() {
        // Arrange
        Long id = 1L;
        when(operatorRepository.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(NullPointerException.class, () -> operatorService.retrieveOperator(id));
    }
}
