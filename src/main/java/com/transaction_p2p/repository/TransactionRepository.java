package com.transaction_p2p.repository;

import com.transaction_p2p.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public class TransactionRepository extends JpaRepository<Transaction, Long> {
}
