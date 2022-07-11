package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.repository.ReceiptRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReceiptRepositoryListImpl implements ReceiptRepository {

  private final List<Receipt> list = new ArrayList<Receipt>();

  @Override
  public Receipt getReceipt(Integer id) {
    return list.stream()
        .filter(receipt -> receipt.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Receipt not found"));
  }

  @Override
  public List<Receipt> getAllReceipts() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deleteReceipt(Integer id) {
    return list.removeIf(receipt -> receipt.getId().equals(id));
  }

  @Override
  public Receipt createReceipt(Receipt receipt) {
    list.add(receipt);
    return receipt;
  }

  @Override
  public Receipt updateReceipt(Integer id, Receipt receipt) {
    if (list.removeIf(receipt1 -> receipt1.getId().equals(id))) {
      list.add(receipt);
    } else {
      throw new RuntimeException("Receipt not found");
    }
    return receipt;
  }
}
