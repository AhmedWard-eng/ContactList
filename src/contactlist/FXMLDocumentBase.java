package contactlist;

import com.sun.javafx.charts.ChartLayoutAnimator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class FXMLDocumentBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final BorderPane borderPane;
    protected final Text text;
    protected final TextField textId;
    protected final BorderPane borderPane0;
    protected final Text text0;
    protected final TextField textFN;
    protected final BorderPane borderPane1;
    protected final BorderPane borderPane2;
    protected final Text text1;
    protected final TextField textMN;
    protected final BorderPane borderPane3;
    protected final Text text2;
    protected final TextField textLN;
    protected final BorderPane borderPane4;
    protected final Text text3;
    protected final TextField textEmail;
    protected final BorderPane borderPane5;
    protected final Text text4;
    protected final TextField textPhone;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Button ButtonNew;
    protected final Button ButtonUpdate;
    protected final Button ButtonDelete;
    protected final Button ButtonPrevious;
    protected final Button ButtonNext;
    protected final Button ButtonLast;
    protected final Button ButtonFirst;
    private boolean isNewButton;
    private int nextId;
    private boolean isUbdateButton;
    Alert alert;
    Alert alertEnterAllData;

    public FXMLDocumentBase(DataBaseHandler dbHandler) {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        borderPane = new BorderPane();

        text = new Text();
        textId = new TextField();
        borderPane0 = new BorderPane();
        text0 = new Text();
        textFN = new TextField();
        borderPane1 = new BorderPane();
        borderPane2 = new BorderPane();
        text1 = new Text();
        textMN = new TextField();
        borderPane3 = new BorderPane();
        text2 = new Text();
        textLN = new TextField();
        borderPane4 = new BorderPane();
        text3 = new Text();
        textEmail = new TextField();
        borderPane5 = new BorderPane();
        text4 = new Text();
        textPhone = new TextField();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints6 = new RowConstraints();
        ButtonNew = new Button();
        ButtonUpdate = new Button();
        ButtonDelete = new Button();
        ButtonPrevious = new Button();
        ButtonNext = new Button();
        ButtonLast = new Button();
        ButtonFirst = new Button();

        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Delete dialogue");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure that you want to delete this contact?");
        alertEnterAllData = new Alert(AlertType.WARNING);
        alertEnterAllData.setTitle("Warning Dialog");
        alertEnterAllData.setHeaderText(null);
        alertEnterAllData.setContentText("please enter all data");

        init(dbHandler);
        getFirst(dbHandler);
        setAllUnEditable();
        try {
            nextId = dbHandler.getLastId() + 1;
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        setAlignment(javafx.geometry.Pos.CENTER);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(40.0);
        rowConstraints.setMinHeight(40.0);
        rowConstraints.setPrefHeight(40.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(40.0);
        rowConstraints0.setMinHeight(40.0);
        rowConstraints0.setPrefHeight(40.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(40.0);
        rowConstraints1.setMinHeight(40.0);
        rowConstraints1.setPrefHeight(40.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(40.0);
        rowConstraints2.setMinHeight(40.0);
        rowConstraints2.setPrefHeight(40.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(40.0);
        rowConstraints3.setMinHeight(40.0);
        rowConstraints3.setPrefHeight(40.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(40.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(40.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(70.0);
        rowConstraints5.setMinHeight(70.0);
        rowConstraints5.setPrefHeight(70.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Id");
        text.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text.setWrappingWidth(100.0);
        BorderPane.setMargin(text, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane.setLeft(text);

        BorderPane.setAlignment(textId, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textId, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane.setCenter(textId);

        GridPane.setRowIndex(borderPane0, 1);
        borderPane0.setPrefHeight(200.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(text0, javafx.geometry.Pos.CENTER);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("First Name");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text0.setWrappingWidth(100.0);
        BorderPane.setMargin(text0, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane0.setLeft(text0);

        BorderPane.setAlignment(textFN, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textFN, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane0.setCenter(textFN);

        GridPane.setRowIndex(borderPane1, 2);
        borderPane1.setPrefHeight(200.0);
        borderPane1.setPrefWidth(200.0);

        BorderPane.setAlignment(borderPane2, javafx.geometry.Pos.CENTER);
        borderPane2.setPrefHeight(200.0);
        borderPane2.setPrefWidth(200.0);

        BorderPane.setAlignment(text1, javafx.geometry.Pos.CENTER);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Middle Name");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text1.setWrappingWidth(100.0);
        BorderPane.setMargin(text1, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane2.setLeft(text1);

        BorderPane.setAlignment(textMN, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textMN, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane2.setCenter(textMN);
        borderPane1.setCenter(borderPane2);

        GridPane.setRowIndex(borderPane3, 3);
        borderPane3.setPrefHeight(200.0);
        borderPane3.setPrefWidth(200.0);

        BorderPane.setAlignment(text2, javafx.geometry.Pos.CENTER);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Last Name");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text2.setWrappingWidth(100.0);
        BorderPane.setMargin(text2, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane3.setLeft(text2);

        BorderPane.setAlignment(textLN, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textLN, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane3.setCenter(textLN);

        GridPane.setRowIndex(borderPane4, 4);
        borderPane4.setPrefHeight(200.0);
        borderPane4.setPrefWidth(200.0);

        BorderPane.setAlignment(text3, javafx.geometry.Pos.CENTER);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Email");
        text3.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text3.setWrappingWidth(100.0);
        BorderPane.setMargin(text3, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane4.setLeft(text3);

        BorderPane.setAlignment(textEmail, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textEmail, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane4.setCenter(textEmail);

        GridPane.setRowIndex(borderPane5, 5);
        borderPane5.setPrefHeight(200.0);
        borderPane5.setPrefWidth(200.0);

        BorderPane.setAlignment(text4, javafx.geometry.Pos.CENTER);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Phone");
        text4.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text4.setWrappingWidth(100.0);
        BorderPane.setMargin(text4, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane5.setLeft(text4);

        BorderPane.setAlignment(textPhone, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(textPhone, new Insets(0.0, 10.0, 0.0, 10.0));
        borderPane5.setCenter(textPhone);

        GridPane.setRowIndex(gridPane, 6);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(40.0);
        gridPane.setPrefWidth(563.0);

        columnConstraints0.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(80.0);
        columnConstraints0.setMinWidth(80.0);
        columnConstraints0.setPrefWidth(80.0);

        columnConstraints1.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(80.0);
        columnConstraints1.setMinWidth(80.0);
        columnConstraints1.setPrefWidth(80.0);

        columnConstraints2.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(80.0);
        columnConstraints2.setMinWidth(80.0);
        columnConstraints2.setPrefWidth(80.0);

        columnConstraints3.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(80.0);
        columnConstraints3.setMinWidth(80.0);
        columnConstraints3.setPrefWidth(80.0);

        columnConstraints4.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(80.0);
        columnConstraints4.setMinWidth(80.0);
        columnConstraints4.setPrefWidth(80.0);

        columnConstraints5.setHalignment(javafx.geometry.HPos.RIGHT);
        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(80.0);
        columnConstraints5.setMinWidth(80.0);
        columnConstraints5.setPrefWidth(80.0);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(ButtonNew, javafx.geometry.HPos.CENTER);
        ButtonNew.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonNew.setMnemonicParsing(false);
        ButtonNew.setPrefWidth(76.0);
        ButtonNew.setText("New");
        ButtonNew.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonUpdate, 1);
        GridPane.setHalignment(ButtonUpdate, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(ButtonUpdate, javafx.geometry.VPos.CENTER);
        ButtonUpdate.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonUpdate.setMnemonicParsing(false);
        ButtonUpdate.setPrefWidth(76.0);
        ButtonUpdate.setText("Update");
        ButtonUpdate.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonDelete, 2);
        GridPane.setHalignment(ButtonDelete, javafx.geometry.HPos.CENTER);
        ButtonDelete.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonDelete.setMnemonicParsing(false);
        ButtonDelete.setPrefWidth(76.0);
        ButtonDelete.setText("Delete");
        ButtonDelete.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonFirst, 3);
        GridPane.setHalignment(ButtonFirst, javafx.geometry.HPos.CENTER);
        ButtonFirst.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonFirst.setMnemonicParsing(false);
        ButtonFirst.setPrefWidth(76.0);
        ButtonFirst.setText("First");
        ButtonFirst.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonPrevious, 4);
        GridPane.setHalignment(ButtonPrevious, javafx.geometry.HPos.CENTER);
        ButtonPrevious.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonPrevious.setMnemonicParsing(false);
        ButtonPrevious.setPrefWidth(76.0);
        ButtonPrevious.setText("Previous");
        ButtonPrevious.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonNext, 5);
        GridPane.setHalignment(ButtonNext, javafx.geometry.HPos.CENTER);
        ButtonNext.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonNext.setMnemonicParsing(false);
        ButtonNext.setPrefHeight(31.0);
        ButtonNext.setPrefWidth(76.0);
        ButtonNext.setText("Next");
        ButtonNext.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        GridPane.setColumnIndex(ButtonLast, 6);
        GridPane.setHalignment(ButtonLast, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(ButtonLast, javafx.geometry.VPos.CENTER);
        ButtonLast.setAlignment(javafx.geometry.Pos.CENTER);
        ButtonLast.setMnemonicParsing(false);
        ButtonLast.setPrefWidth(76.0);
        ButtonLast.setText("Last");
        ButtonLast.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getChildren().add(borderPane);
        getChildren().add(borderPane0);
        getChildren().add(borderPane1);
        getChildren().add(borderPane3);
        getChildren().add(borderPane4);
        getChildren().add(borderPane5);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getRowConstraints().add(rowConstraints6);
        gridPane.getChildren().add(ButtonNew);
        gridPane.getChildren().add(ButtonUpdate);
        gridPane.getChildren().add(ButtonDelete);
        gridPane.getChildren().add(ButtonPrevious);
        gridPane.getChildren().add(ButtonFirst);
        gridPane.getChildren().add(ButtonNext);
        gridPane.getChildren().add(ButtonLast);
        getChildren().add(gridPane);

    }

    private void init(DataBaseHandler db) {

        ButtonNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isNewButton) {
                    if (checkAllDataInserted()) {
                        insertData(db);
                        cancelNew();

                        ButtonDelete.setDisable(false);
                        ButtonUpdate.setDisable(false);
                    } else {

                        alertEnterAllData.showAndWait();
                    }
                } else {
                    clearAllText();
                    ButtonNew.setText("Save");
                    setAllEditable();
                    isNewButton = true;
                    textId.setText(String.valueOf(nextId));
                    ButtonDelete.setDisable(true);
                    ButtonUpdate.setDisable(true);
                }
            }

        });

        ButtonUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isUbdateButton) {
                    if (checkAllDataInserted()) {
                        update(db);

                        ButtonUpdate.setText("Update");
                        setAllUnEditable();
                        isUbdateButton = false;
                        ButtonDelete.setDisable(false);
                        ButtonNew.setDisable(false);
                    } else {
                        alertEnterAllData.showAndWait();
                    }
                } else {
                    ButtonUpdate.setText("Save");
                    setAllEditable();
                    isUbdateButton = true;
                    ButtonDelete.setDisable(true);
                    ButtonNew.setDisable(true);
                }
            }

        });
        ButtonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (delete(db)) {
                    clearAllText();
                    getNext(db);
                }

            }
        });

        ButtonFirst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getFirst(db);
                cancelNew();
                cancelUpdate();
            }
        });
        ButtonLast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getLast(db);
                cancelNew();
                cancelUpdate();
            }

        });
        ButtonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                getNext(db);
                cancelNew();
                cancelUpdate();
            }

        });
        ButtonPrevious.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getPrevious(db);
                cancelNew();
                cancelUpdate();
            }

        });
    }

    private boolean checkAllDataInserted() {
        if (textFN.getText().isEmpty() || textMN.getText().isEmpty() || textLN.getText().isEmpty() || textEmail.getText().isEmpty() || textPhone.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void getFirst(DataBaseHandler db) {
        Contact first;
        try {
            first = db.getFirst();
            if (first != null) {
                clearAllText();
                textFN.setText(first.FN);
                textLN.setText(first.LN);
                textMN.setText(first.MN);
                textId.setText(first.id + "");
                textPhone.setText(first.phone);
                textEmail.setText(first.Email);
                ButtonPrevious.setDisable(true);
               
                if(ButtonNext.isDisable()){
                    ButtonNext.setDisable(false);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void getLast(DataBaseHandler db) {
        Contact last;
        try {
            last = db.getLast();
            if (last != null) {
                clearAllText();
                textFN.setText(last.FN);
                textLN.setText(last.LN);
                textMN.setText(last.MN);
                textId.setText(last.id + "");
                textPhone.setText(last.phone);
                textEmail.setText(last.Email);
                ButtonNext.setDisable(true);
               
                if(ButtonPrevious.isDisable()){
                    ButtonPrevious.setDisable(false);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void getNext(DataBaseHandler db) {
        Contact next;
        try {
            next = db.getNext();
            if (next != null) {
                clearAllText();
                textFN.setText(next.FN);
                textLN.setText(next.LN);
                textMN.setText(next.MN);
                textId.setText(next.id + "");
                textPhone.setText(next.phone);
                textEmail.setText(next.Email);
                if(db.getResultSet().isLast()){
                    ButtonNext.setDisable(true);
                }
                if(ButtonPrevious.isDisable()){
                    ButtonPrevious.setDisable(false);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void getPrevious(DataBaseHandler db) {
        Contact prev;
        try {
            prev = db.getPrevious();
            if (prev != null) {
                clearAllText();
                textFN.setText(prev.FN);
                textLN.setText(prev.LN);
                textMN.setText(prev.MN);
                textId.setText(prev.id + "");
                textPhone.setText(prev.phone);
                textEmail.setText(prev.Email);
                if(db.getResultSet().isFirst()){
                    ButtonPrevious.setDisable(true);
                }
                if(ButtonNext.isDisable()){
                    ButtonNext.setDisable(false);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void update(DataBaseHandler db) {
        Contact contact;
        if (checkAllDataInserted()) {
            try {
                setAllEditable();
                contact = new Contact(Integer.parseInt(textId.getText()), textFN.getText(), textMN.getText(), textLN.getText(), textEmail.getText(), textPhone.getText());
                db.updateDB(contact);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean delete(DataBaseHandler db) {
        boolean isDeleted = false;
        if (checkAllDataInserted()) {
            try {
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    db.delete(Integer.parseInt(textId.getText()));
                    isDeleted = true;
                    nextId = db.getLastId() + 1;
                } else {
                    // ... user chose CANCEL or closed the dialog
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    private void insertData(DataBaseHandler db) {
        try {
            Contact contact = new Contact(nextId, textFN.getText(), textMN.getText(), textLN.getText(), textEmail.getText(), textPhone.getText());

            db.insertData(contact);
            nextId = db.getLastId() + 1;
            //TODO : handle primary key constraints
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void setAllUnEditable() {
        textId.setEditable(false);

        textFN.setEditable(false);
        textMN.setEditable(false);
        textLN.setEditable(false);
        textPhone.setEditable(false);
        textEmail.setEditable(false);
    }

    private void setAllEditable() {
        textFN.setEditable(true);
        textMN.setEditable(true);
        textLN.setEditable(true);
        textPhone.setEditable(true);
        textEmail.setEditable(true);
    }

    private void clearAllText() {
        textId.clear();

        textFN.clear();
        textMN.clear();
        textLN.clear();
        textPhone.clear();
        textEmail.clear();
    }

    private void cancelNew() {
        setAllUnEditable();
        ButtonNew.setText("New");
        isNewButton = false;
        ButtonDelete.setDisable(false);
        ButtonUpdate.setDisable(false);
    }

    private void cancelUpdate() {

        ButtonUpdate.setText("Update");
        setAllUnEditable();
        isUbdateButton = false;
        ButtonDelete.setDisable(false);
        ButtonNew.setDisable(false);
    }

}
