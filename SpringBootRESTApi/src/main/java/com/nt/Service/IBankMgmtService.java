package com.nt.Service;

import com.nt.Entity.BankAccount;

public interface IBankMgmtService {
	public String openAccount(BankAccount account);
    public String withdraw(long acno,double amount);
    public BankAccount showAccountDetails(long acno);
    public String deposite(long acno,double amount);
    public String transferMoney(long srcAcno,long destAcno,double Amount);
}
