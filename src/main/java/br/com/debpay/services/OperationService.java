package br.com.debpay.services;

import br.com.debpay.dao.IOperationDAO;
import br.com.debpay.dto.OperationDTO;
import br.com.debpay.dto.OperationFilterDTO;
import br.com.debpay.entities.Contact;
import br.com.debpay.entities.Operation;
import br.com.debpay.entities.OperationType;

import java.util.ArrayList;
import java.util.List;

public class OperationService implements IOperationService {

    private final IOperationDAO dao;

    public OperationService(IOperationDAO dao) {
        this.dao = dao;
    }

    @Override
    public void createOperation(OperationDTO dto) {
        var op = new Operation();
        op.setDescription(dto.getDescription());
        op.setType(dto.getType());
        op.setDueDate(dto.getDueDate());
        op.setInstallmentsLeft(dto.getInstallmentsLeft());
        op.setValue(dto.getValue());

        var contact = new Contact();
        contact.setId(dto.getContactID());
        op.setContact(contact);

        dao.save(op);
    }

    @Override
    public List<OperationDTO> listOperations(OperationFilterDTO dto) {
        var operations = this.dao.getAll(dto.getUserID(), dto.getDueDate());
        var returnList = new ArrayList<OperationDTO>();
        for (Operation op : operations) {
            returnList.add(operationToDTO(op));
        }
        return returnList;
    }

    private OperationDTO operationToDTO(Operation op) {
        var dto = new OperationDTO();
        dto.setId(op.getId());
        dto.setDescription(op.getDescription());
        dto.setType(op.getType());
        dto.setDueDate(op.getDueDate());
        dto.setInstallmentsLeft(op.getInstallmentsLeft());
        dto.setValue(op.getValue());
        dto.setContactID(op.getContact().getId());
        return dto;
    }
}
