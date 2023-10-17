package project.ui;

import project.model.customer.Contract;
import java.util.List;

public interface ContractUI {
    Contract changeContract(Contract contract);
    String getContractNumberFromUser();
    int getContractId(List<Contract> contracts);

}
