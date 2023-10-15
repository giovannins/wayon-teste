package br.dev.giovanni.wayon.transaction;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private TaxService taxService;
	
	public Transaction scheduleTransaction(Transaction transaction) {
		BigDecimal tax = taxService.calculateTax(transaction);
		transaction.setTax(tax);
		return repository.save(transaction);
	}
	
	public List<Transaction> allStatement() {
		return repository.findAll();
	}
	
}
