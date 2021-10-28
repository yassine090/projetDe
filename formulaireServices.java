/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaireServices;

import Myconnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projetpidev.formulaire;



/**
 *
 * @author LENOVO
 */
public class formulaireServices {
    public Connection cnx;
    private PreparedStatement ste;

    public formulaireServices (){
    cnx = MyConnection.getInstance().getConnection();}

    public void ajouterFormulaire(formulaire f) throws SQLException{
        String req ="INSERT INTO formulaire (Id,Nom,Prenom,Adresse,DateNaissance,Sexe,descriptionSymptomes "
                + ") "
                 + "VALUES (?,?,?,?,?,?,?)";
       ste = cnx.prepareStatement(req);
         
            ste.setInt(1,f.getId());
            ste.setString(2, f.getNom());
            ste.setString(3,f.getPrenom());
            ste.setString(4, f.getDateNaissance());
            ste.setString(5, f.getAdresse());
            ste.setString(6,f.getSexe());
            ste.setString(7,f.getDescriptionSymptomes());
            ste.executeUpdate();
            System.out.println("formulaire ajoutéé");}
         
          
           public void supprimerFormulaire(int Id){
try{
String req = "DELETE FROM formulaire WHERE Id=? ;";
        ste=cnx.prepareStatement(req);
ste.setInt(1,Id);
ste.executeUpdate();

}catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
}
public void modifierFormulaire(int Id,String Nom, String Prenom , String Adresse,String DateNaissance,String Sexe, String DescriptionSymptomes) throws SQLException{
   try{
    String req = "update formulaire set Id='"+Id+"',"+"Nom='"+Nom+"',"+"Prenom='"+Prenom+"',"+"DateNaissance='"+DateNaissance+"',"+"Adresse='"+Adresse+"',"+"Sexe='"+Sexe+"',"+"DescriptionSymptomes='"+DescriptionSymptomes+"'where Id='"+Id+"'";
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(formulaireServices.class.getName()).log(Level.SEVERE, null, ex);
}

}
public void rechercherFormulaire(int id){
    
        
        try {
            List<formulaire>formulaire = new ArrayList<>();
            ste = cnx.prepareStatement("select * from formulaire where id='"+id+"'");
            formulaire f = new formulaire();
            ResultSet rs = ste.executeQuery();
            while(rs.next()){
                f.setId(id);
                f.setNom(rs.getString("Nom"));
                f.setPrenom(rs.getString("Prenom"));
                f.setDateNaissance(rs.getString("DateNaissance"));
                f.setAdresse(rs.getString("Adresse"));
                f.setSexe(rs.getString("Sexe"));
                f.setDescriptionSymptomes(rs.getString("descriptionSymptomes"));
                
                formulaire.add(f);
            }
            System.out.println(formulaire);
        } catch (SQLException ex) {
            Logger.getLogger(formulaireServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 public ObservableList<formulaire> afficherFormualrie() {
    
        ObservableList formulaire = FXCollections.observableArrayList();
     try {   
        String sql ="Select * from formulaire";
        ste = cnx.prepareStatement(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        while(rs.next())
        {
            formulaire.add(new formulaire(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return formulaire;
        
    }
    }


        
            
