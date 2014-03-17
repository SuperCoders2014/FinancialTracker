package edu.cs2340.supercoders.financialtracker.model;

public class Transaction {

	private String name;

	private double amount;

	private String type;

	public Transaction(String name, double amount, String type) {
		this.name = name;
		this.amount = amount;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		String s = "[" + type + "]" + name + ": " + amount + "- ";
		return s;
	}

}
