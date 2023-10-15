package br.dev.giovanni.wayon.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("/transaction/statements")
	public List<Transaction> findAll() {
		return service.allStatement();
	}
	
	@PostMapping("/transaction/create")
	ResponseEntity<Transaction> schedule(@RequestBody Transaction transaction) {
		Transaction scheduleTransaction = service.scheduleTransaction(transaction);
		return ResponseEntity.ok(scheduleTransaction);
	}
}
