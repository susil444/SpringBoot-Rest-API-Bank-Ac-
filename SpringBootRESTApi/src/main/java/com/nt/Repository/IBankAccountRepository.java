package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.Entity.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount,Long>{

}
