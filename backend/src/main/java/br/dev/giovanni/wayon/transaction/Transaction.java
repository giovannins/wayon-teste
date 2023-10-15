package br.dev.giovanni.wayon.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "origin_account")
	private String originAccount;

	@Column(name = "destiny_account")
	private String destinyAccount;

	@Column(name = "money")
	private BigDecimal value;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	@Column(name = "schedule_date")
	private LocalDate scheduleDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(String originAccount) {
		this.originAccount = originAccount;
	}

	public String getDestinyAccount() {
		return destinyAccount;
	}

	public void setDestinyAccount(String destinyAccount) {
		this.destinyAccount = destinyAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Transaction(String originAccount, String destinyAccount, BigDecimal value, BigDecimal tax,
			LocalDate transactionDate, LocalDate scheduleDate) {
		this.originAccount = originAccount;
		this.destinyAccount = destinyAccount;
		this.value = value;
		this.tax = tax;
		this.transactionDate = transactionDate;
		this.scheduleDate = scheduleDate;
	}
	
	Transaction() { }

}
