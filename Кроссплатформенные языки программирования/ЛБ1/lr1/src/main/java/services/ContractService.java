package services;

import java.util.List;

import dao.ContractDao;
import models.Contract;
import models.PatientCard;


public class ContractService {

    private ContractDao contractsDao = new ContractDao();

    public ContractService() {
    }

    public Contract findContract(int id) {
        return contractsDao.findById(id);
    }

    public void saveContract(Contract contract) {
        contractsDao.save(contract);
    }

    public void deleteContract(Contract contract) {
        contractsDao.delete(contract);
    }

    public void updateContract(Contract contract) {
        contractsDao.update(contract);
    }

    public List<Contract> findAllContracts() {
        return contractsDao.findAll();
    }

    public List<PatientCard> findAllPatientCard(Contract contract) {
        return contractsDao.findAllPatientCard(contract);
    }


}
