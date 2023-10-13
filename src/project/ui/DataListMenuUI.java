package project.ui;

public interface DataListMenuUI {
    String CREATE_NEW_OBJECT_CHOICE = "new";
    String SELECT_OBJECT_CHOICE = "select";
    String CANCEL_CHOICE = "cancel";
    void displayListMenu();
    String getUserChoice();
}
