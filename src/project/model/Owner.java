package project.model;

import project.model.recyclableUnits.RecyclableUnit;
import project.model.requisites.BankAccount;
import project.model.requisites.Requisites;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Company {
    private List<RecyclableUnit> recyclableUnits;

    public Owner(Requisites ownerRequisites, List<BankAccount> ownerBankAccounts, List<RecyclableUnit> recyclableUnits) {
        super(1);
        super.setBankAccounts(ownerBankAccounts);
        super.addRequisites(ownerRequisites);
        this.recyclableUnits = recyclableUnits;
    }

    public void addUnit(RecyclableUnit recyclableUnit) {
        if (recyclableUnits.contains(recyclableUnit)) {
            recyclableUnits.set(recyclableUnits.indexOf(recyclableUnit), recyclableUnit);
        } else {
            recyclableUnits.add(recyclableUnit);
        }
    }

    public void  removeUnit(RecyclableUnit recyclableUnit) {
        recyclableUnits.remove(recyclableUnit);
    }

    public void setRecyclableUnits(List<RecyclableUnit> recyclableUnits) {
        this.recyclableUnits = recyclableUnits;
    }

    public int getOWNER_ID() {
        return super.getID();
    }

    public Requisites getOwnerRequisites() {
        return super.getRequisitesList().get(0);
    }

    public List<BankAccount> getOwnerBankAccounts() {
        return super.getBankAccounts();
    }

    public List<RecyclableUnit> getRecyclableUnits() {
        return recyclableUnits == null ? new ArrayList<>() : recyclableUnits;
    }
}
