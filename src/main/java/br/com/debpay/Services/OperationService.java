package br.com.debpay.Services;

import br.com.debpay.DAO.IOperationDAO;
import br.com.debpay.DTO.OperationDTO;
import br.com.debpay.Entities.Operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationService implements IOperationService {

    private final IOperationDAO dao;

    public OperationService(IOperationDAO dao) {
        this.dao = dao;
    }

    @Override
    public int createOperation(OperationDTO dto) {
        var op = new Operation();
        op.setDescription();

        dao.save();


        return 0;
    }

    @Override
    public List<OperationDTO> listOperations(int id, Date dueDate) {
        var operations = this.dao.getAll(id,dueDate);
        var returnList = new ArrayList<OperationDTO>();
        for (Operation op : operations) {
            returnList.add(OperationDTO.converter(op));
        }

        return nil;
    }
}
