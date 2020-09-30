package tcp.chat.client;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tcp.chat.server.ServerAPI;


public class MainApp extends Application {
    private ServerAPI serverAPI;

    private Label hostLabel;
    private TextField hostTextField;
    private Label portLabel;
    private TextField portTextField;
    private Label usernameLabel;
    private TextField usernameTextField;
    private Button connectButton;
    private TextField messageField;
    private Button sendButton;
    private TextArea textArea;


    @Override
    public void start(Stage stage) throws Exception {


        VBox root = new VBox();

        hostLabel = new Label("Host:");
        hostTextField = new TextField("127.0.0.1");
        root.getChildren().addAll(hostLabel, hostTextField);

        portLabel = new Label("Port:");
        portTextField = new TextField("8082");
        root.getChildren().addAll(portLabel, portTextField);


        usernameLabel = new Label("Username:");
        usernameTextField = new TextField("admin");
        root.getChildren().addAll(usernameLabel, usernameTextField);


        connectButton = new Button("Connect");
        root.getChildren().add(connectButton);

        messageField = new TextField();
        sendButton = new Button("Send:");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(messageField, sendButton);
        root.getChildren().add(hBox);

        textArea = new TextArea();
        root.getChildren().add(textArea);


        connectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String host = hostTextField.getText().trim();
                String port = portTextField.getText().trim();
                serverAPI = new ServerAPI(host, Integer.parseInt(port), textArea);
                serverAPI.start();
                changeState(false);
            }
        });

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message = messageField.getText().trim();
                String username = usernameTextField.getText().trim();
                serverAPI.sendMessageToServer(username, message);
            }
        });

        changeState(true);


        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("TCP Chat");
        stage.setScene(scene);
        stage.show();
    }

    private void changeState(boolean isNotConnected) {
        messageField.setDisable(isNotConnected);
        sendButton.setDisable(isNotConnected);
        textArea.setDisable(isNotConnected);

        hostLabel.setDisable(!isNotConnected);
        hostTextField.setDisable(!isNotConnected);
        portLabel.setDisable(!isNotConnected);
        portTextField.setDisable(!isNotConnected);
        usernameLabel.setDisable(!isNotConnected);
        usernameTextField.setDisable(!isNotConnected);
        connectButton.setDisable(!isNotConnected);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
