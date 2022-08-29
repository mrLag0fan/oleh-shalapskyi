package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.ReceiptStatus;
import java.util.List;

public interface ReceiptStatusRepository {

  ReceiptStatus getReceiptStatus(Integer id);

  List<ReceiptStatus> getAllReceiptStatuses();

  boolean deleteReceiptStatus(Integer id);

  ReceiptStatus createReceiptStatus(ReceiptStatus receiptStatus);

  ReceiptStatus updateReceiptStatus(Integer id, ReceiptStatus receiptStatus);
}
