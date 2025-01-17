package nl.averageflow.springwarehouse.domain.transaction;

import nl.averageflow.springwarehouse.domain.transaction.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public final class TransactionController {

    private final TransactionServiceContract transactionService;

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/transactions")
    public Page<Transaction> getTransactions(final Pageable pageable) {
        return this.transactionService.getTransactions(pageable);
    }

    @GetMapping("/api/transactions/{uid}")
    public Optional<Transaction> getTransaction(@PathVariable final UUID uid) {
        return this.transactionService.getTransactionByUid(uid);
    }
}
