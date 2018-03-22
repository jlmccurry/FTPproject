package ftpproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author jlmcc
 */

public class FtpProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(5,5,5,5));
        
        FtpRetrieve ftp = new FtpRetrieve();

        TextField servTxtField = new TextField();
        Label serverLabel = new Label("Server");
        pane.add(serverLabel, 0, 0, 1, 1);
        pane.add(servTxtField, 1, 0, 1, 1);
        
        TextField portTxtField = new TextField();
        portTxtField.setMaxWidth(50);
        Label portLabel = new Label("Port");
        pane.add(portLabel, 0, 1, 1, 1);
        pane.add(portTxtField, 1, 1, 1, 1);
        
        TextField userTxtField = new TextField();
        Label userLabel = new Label("User");
        pane.add(userLabel, 2, 0, 1, 1);
        pane.add(userTxtField, 3, 0, 1, 1);
        
        TextField passTxtField = new TextField();
        Label passLabel = new Label("Password");
        pane.add(passLabel, 2, 1, 1, 1);
        pane.add(passTxtField, 3, 1, 1, 1);
        
        Button goButton = new Button("Connect");
        pane.add(goButton, 4, 0, 1, 1);
        
        goButton.setOnAction(e -> {
            ftp.setServerName(servTxtField.getText());
            ftp.setPortNum(Integer.parseInt(portTxtField.getText()));
            ftp.setUserName(userTxtField.getText());
            ftp.setPassWord(passTxtField.getText());
            ftp.getFile();
            boolean success = ftp.getSuccess();
        });
        
        Scene scene = new Scene(pane, 1024, 768);
        
        primaryStage.setTitle("FTP Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
