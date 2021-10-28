/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionsService;

import Myconnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projetpidev.Questions;

/**
 *
 * @author LENOVO
 */
public class QuestionsService {
    public Connection cnx;
    private PreparedStatement ste;
    

public QuestionsService(){
    cnx = MyConnection.getInstance().getConnection();
}
public void Questionnaire(Questions f) throws SQLException{
    String req ="INSERT INTO questions (Id,Question1,Question2,Question3,Question4,Question5,Question6,Question7 "
                + ") "
                 + "VALUES (?,?,?,?,?,?,?,?)";
     ste = cnx.prepareStatement(req);
         
            ste.setInt(1,f.getId());
            ste.setString(2, f.getQuestion1());
            ste.setString(3,f.getQuestion2());
            ste.setString(4,  f.getQuestion3());
            ste.setString(5, f.getQuestion4());
            ste.setString(6,f.getQuestion5());
            ste.setString(7,f.getQuestion6());
            ste.setString(8,f.getQuestion7());
            ste.executeUpdate();
            System.out.println("questionaire ajoutéé");
         

}
        
}