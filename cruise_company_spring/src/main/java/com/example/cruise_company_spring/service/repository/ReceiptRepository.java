package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.Receipt;
import java.util.List;

public interface ReceiptRepository {

    Receipt getReceipt(Integer id);

    List<Receipt> getAllReceipts();

    boolean deleteReceipt(Integer id);

    Receipt createReceipt(Receipt receipt);

    Receipt updateReceipt(Integer id, Receipt receipt);
}
