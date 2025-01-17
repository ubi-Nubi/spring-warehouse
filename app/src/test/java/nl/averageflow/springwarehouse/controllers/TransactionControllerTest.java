package nl.averageflow.springwarehouse.controllers;

import nl.averageflow.springwarehouse.domain.transaction.TransactionController;
import nl.averageflow.springwarehouse.domain.transaction.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TransactionControllerTest {

    @Autowired
    private TransactionController controller;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
