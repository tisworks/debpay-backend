package br.com.debpay.Services;

import br.com.debpay.DTO.OperationDTO;

import java.util.ArrayList;
import java.sql.Date;

public interface IOperationService {
    ArrayList<OperationDTO> listOperations(int id, Date dueDate);
}
