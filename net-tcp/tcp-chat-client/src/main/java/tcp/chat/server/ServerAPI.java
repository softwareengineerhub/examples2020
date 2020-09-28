package tcp.chat.server;

import com.app.data.ChatData;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerAPI extends Thread {
    private String host;
    private int port;
    private Socket socket;
    private TextArea textArea;

    public ServerAPI(String host, int port, TextArea textArea) {
        try {
            this.host = host;
            this.port = port;
            this.textArea=textArea;
            socket = new Socket(InetAddress.getByName(host), port);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {

            while (true) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ChatData chatData = (ChatData) in.readObject();
                System.out.println("data form server: "+chatData);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                            String text = textArea.getText();
                            textArea.setText(text+"\n"+chatData);
                    }
                });

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void sendMessageToServer(String username, String message) {
        ChatData chatData = new ChatData();
        chatData.setUsername(username);
        chatData.setMessage(message);
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(chatData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
