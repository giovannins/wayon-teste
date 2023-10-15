package br.dev.giovanni.wayon.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
	
	private static final Logger log = LoggerFactory.getLogger(TaxService.class);
	
	public BigDecimal calculateTax(Transaction transaction) {
		BigDecimal transactionValue = transaction.getValue();
		LocalDate transactionDate = transaction.getTransactionDate();
		LocalDate scheduleDate = transaction.getScheduleDate();

		log.info(String.valueOf(transactionValue));
		log.info(String.valueOf(transactionDate));
		log.info(String.valueOf(scheduleDate));
		
		long daysBetween = ChronoUnit.DAYS.between(scheduleDate, transactionDate);

		log.info(String.valueOf(daysBetween));
		
		if (daysBetween >= 0 && daysBetween <= 10) {
			return new BigDecimal("0.00"); // Taxa de 0% para transferências de 1 a 10 dias.
		} else if (daysBetween >= 11 && daysBetween <= 20) {
			return transactionValue.multiply(new BigDecimal("0.082")); // Taxa de 8.2% para transferências de 11 a 20
																		// dias.
		} else if (daysBetween >= 21 && daysBetween <= 30) {
			return transactionValue.multiply(new BigDecimal("0.069")); // Taxa de 6.9% para transferências de 21 a 30
																		// dias.
		} else if (daysBetween >= 31 && daysBetween <= 40) {
			return transactionValue.multiply(new BigDecimal("0.047")); // Taxa de 4.7% para transferências de 31 a 40
																		// dias.
		} else if (daysBetween >= 41 && daysBetween <= 50) {
			return transactionValue.multiply(new BigDecimal("0.017")); // Taxa de 1.7% para transferências de 41 a 50
																		// dias.
		}

		return new BigDecimal("3.00"); // Taxa fixa de R$ 3.00 para transferências com 0 dias de antecedência.
	}
}
