package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
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

@Api(tags = "Receipt Statuses API")
@RequestMapping("/api/v1/receiptStatuses")
public interface ReceiptStatusApi {

  @ApiOperation("Get all receipt statuses")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<ReceiptStatusDto> getAllReceiptStatuses();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "ReceiptStatus id")
  @ApiOperation("Get receipt status")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  ReceiptStatusDto getReceiptStatusById(@PathVariable Integer id);

  @ApiOperation("Create receipt status")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  ReceiptStatusDto createReceiptStatus(@RequestBody ReceiptStatusDto receiptStatusDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "ReceiptStatus id")
  @ApiOperation("Update receipt status")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  ReceiptStatusDto updateReceiptStatus(
      @PathVariable Integer id, @RequestBody ReceiptStatusDto receiptStatusDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "ReceiptStatus id")
  @ApiOperation("Delete receipt status")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deleteReceiptStatus(@PathVariable Integer id);
}
