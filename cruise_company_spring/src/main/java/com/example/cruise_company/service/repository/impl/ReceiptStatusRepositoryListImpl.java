package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.exception.entity_not_found.ReceiptStatusNotFoundException;
import com.example.cruise_company.service.model.ReceiptStatus;
import com.example.cruise_company.service.repository.ReceiptStatusRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptStatusRepositoryListImpl implements ReceiptStatusRepository {

  private final List<ReceiptStatus> list = new ArrayList<ReceiptStatus>();

  @Override
  public ReceiptStatus getReceiptStatus(Integer id) {
    return list.stream()
        .filter(receiptStatus -> receiptStatus.getId().equals(id))
        .findFirst()
        .orElseThrow(ReceiptStatusNotFoundException::new);
  }

  @Override
  public List<ReceiptStatus> getAllReceiptStatuses() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deleteReceiptStatus(Integer id) {
    return list.removeIf(receiptStatus -> receiptStatus.getId().equals(id));
  }

  @Override
  public ReceiptStatus createReceiptStatus(ReceiptStatus receiptStatus) {
    list.add(receiptStatus);
    return receiptStatus;
  }

  @Override
  public ReceiptStatus updateReceiptStatus(Integer id, ReceiptStatus receiptStatus) {
    if (list.removeIf(receiptStatus1 -> receiptStatus1.getId().equals(id))) {
      list.add(receiptStatus);
    } else {
      throw new ReceiptStatusNotFoundException();
    }
    return receiptStatus;
  }
}
