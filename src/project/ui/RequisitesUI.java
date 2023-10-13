package project.ui;

import project.model.requisites.Requisites;

import java.util.List;

public interface RequisitesUI {
    int CHANGE_COMPANY_NAME_CHOICE = 1;
    int CHANGE_TAXPAYER_ID_CHOICE = 2;
    int CHANGE_CLASSIFIER_CODE_CHOICE = 3;
    int CHANGE_LEGAL_ADDRESS_CHOICE = 4;
    int CHANGE_MAILING_ADDRESS_CHOICE = 5;
    int CHANGE_PHONE_CHOICE = 6;
    int SAVE_CHOICE = 7;
    int CANCEL_CHOICE = 8;
    void displayRequisitesData(Requisites requisites);
    int getUserChoice();
    String getCompanyNameFromUser();
    int getTaxpayerIdFromUser();
    int getClassifierCodeFromUser();
    String getLegalAddressFromUser();
    String getMailingAddressFromUser();
    String getPhoneFromUser();
    void displayRequisitesList(List<Requisites> requisites);
    DataListMenuUI dataListMenu();
    int getRequisitesId(int listSize);
}
