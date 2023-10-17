package project.ui;

import project.model.requisites.Requisites;

import java.util.List;

public interface RequisitesUI {
    Requisites changeRequisites(Requisites requisites);
    int getRequisitesId(List<Requisites> requisites);
}
