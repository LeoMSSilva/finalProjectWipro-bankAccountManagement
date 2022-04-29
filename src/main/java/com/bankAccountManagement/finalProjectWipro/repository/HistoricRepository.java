package com.bankAccountManagement.finalProjectWipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankAccountManagement.finalProjectWipro.model.Account;
import com.bankAccountManagement.finalProjectWipro.model.Historic;

import java.util.List;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, Long> {
    List<Historic> findByAccount(Account account);
}
