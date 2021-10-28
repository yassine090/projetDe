/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfacepackage;

import java.awt.HeadlessException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EmailController implements Initializable {

    @FXML
    public TextField envoyeA;
    @FXML
    public TextField envoyerDe;
    @FXML
    public TextField pass;
    @FXML
    public TextField Sub;
    @FXML
    public TextArea Msg;
    @FXML
    public Button envoye;
    @FXML
    public Label MessageEnvoye;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void envoiMail(ActionEvent event) {
         sendEmail(envoyeA.getText(),envoyerDe.getText(),pass.getText(),Sub.getText(),Msg.getText());
         
    }
    

    public void sendEmail(String to ,String from, String host,String user, String pass){
       
        
        //setup mail server
        
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session;
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                return new javax.mail.PasswordAuthentication(user, pass);
                
            }
        });
        //create mail
        try
         {
             Message message1= new MimeMessage(session);
             
             message1.setFrom( new InternetAddress("no-reply@gmail.com"));
             message1.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
             message1.setText(host);
             message1.setText(user);
             
             Transport.send(message1);
             
              JOptionPane.showMessageDialog(null,"message sent");
         
         }   
         
         catch(HeadlessException | MessagingException e)
         {
          JOptionPane.showMessageDialog(null,e);
         }
      
        
        
    }
}
    
    

