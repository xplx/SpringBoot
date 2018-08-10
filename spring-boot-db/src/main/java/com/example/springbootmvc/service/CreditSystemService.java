package com.example.springbootmvc.service;

public interface CreditSystemService {
	public int getUserCredit(int userId);
	public boolean addCedit(int userId, int score);
}
