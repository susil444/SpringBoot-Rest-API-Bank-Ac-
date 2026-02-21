package com.nt.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.Entity.BankAccount;
import com.nt.Repository.IBankAccountRepository;

public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private IBankAccountRepository  accountRepo;

	@Override
	public String openAccount(BankAccount account) {
		// TODO Auto-generated method stub
		 account.setCreateBy(System.getProperty("user.name"));
		 long acno=accountRepo.save(account).getAccno();
		return "Bank Account is opened having accont number::"+acno;
	}

	@Override
	public String withdraw(long acno, double amount) {
		// TODO Auto-generated method stub
		BankAccount account=accountRepo.findById(acno).orElseThrow(()-> new RuntimeException("Invalid acno"));
		//update the object
		account.setBalance(account.getBalance()-amount);
		account.setUpdatedBy(System.getProperty("user.name"));
		//update the object
		accountRepo.save(account);
		return  amount+"  amount is  withdrawn from the account number ::"+acno;
	}

	@Override
	public BankAccount showAccountDetails(long acno) {
		// TODO Auto-generated method stub
		BankAccount account=accountRepo.findById(acno).orElseThrow(()-> new RuntimeException("Invalid acno"));
		return account;
	}

	@Override
	public String deposite(long acno, double amount) {
		// TODO Auto-generated method stub
		BankAccount account=accountRepo.findById(acno).orElseThrow(()-> new RuntimeException("Invalid acno"));
		//update the object
		account.setBalance(account.getBalance()+amount);
		account.setUpdatedBy(System.getProperty("user.name"));
		//update the object
		accountRepo.save(account);
		return  amount+"  amount is  deposited in to the account number ::"+acno;

	}

	@Override
	public String transferMoney(long srcAcno, long destAcno, double Amount) {
		// TODO Auto-generated method stub
		 withdraw(srcAcno, Amount);
		  deposite(destAcno, Amount);
		return Amount+" amount is transfered from "+srcAcno+" to "+destAcno;
	}
	}

