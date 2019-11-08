package br.com.debpay.services;

import br.com.debpay.dto.OperationDTO;
import br.com.debpay.dto.OperationFilterDTO;

import java.util.List;

public interface IOperationService {
  void createOperation(OperationDTO dto);

  List<OperationDTO> listOperations(OperationFilterDTO dto);
}
