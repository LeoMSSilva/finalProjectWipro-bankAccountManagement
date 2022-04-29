package com.bankAccountManagement.finalProjectWipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankAccountManagement.finalProjectWipro.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
