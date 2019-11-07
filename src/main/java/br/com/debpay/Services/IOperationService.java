package br.com.debpay.Services;

import br.com.debpay.DTO.OperationDTO;

import java.util.Date;
import java.util.List;

public interface IOperationService {
    int createOperation(OperationDTO dto);
    List<OperationDTO> listOperations(int id, Date dueDate);
}
