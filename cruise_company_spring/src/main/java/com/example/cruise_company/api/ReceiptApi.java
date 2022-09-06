package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.ReceiptDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Receipt API")
@RequestMapping("/api/v1/receipts")
public interface ReceiptApi {

  @ApiOperation("Get all receipts")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<ReceiptDto> getAllReceipts();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Receipt id")
  @ApiOperation("Get receipt")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  ReceiptDto getReceiptById(@PathVariable Integer id);

  @ApiOperation("Create receipt")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  ReceiptDto createReceipt(@RequestBody ReceiptDto receiptDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Receipt id")
  @ApiOperation("Update receipt")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  ReceiptDto updateReceipt(@PathVariable Integer id, @RequestBody ReceiptDto receiptDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Receipt id")
  @ApiOperation("Delete receipt")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deleteReceipt(@PathVariable Integer id);
}
