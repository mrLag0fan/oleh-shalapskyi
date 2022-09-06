package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptJpaRepository extends JpaRepository<Receipt, Integer> {}
