package cmd;

import java.sql.* ;
import java.io.* ;

import com.mysql.cj.jdbc.Driver;
import org.apache.commons.lang3.StringUtils;

public class DbTest {

    public static void main(String[] args)
    {
        try {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.cj.jdbc.Driver") ;
            Driver pilote = (Driver)c.newInstance() ;
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
            // Adresse IP de l’hôte de la base et port
            String ip =  "localhost" ;  // dépend du contexte
            String port =  "3390" ;  // port MySQL par défaut
            // Nom de la base ;
            String nomBase =  "employee" ;  // dépend du contexte
            // Chaîne de connexion
            String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;  // dépend du contexte
            String motDePasse =  "example" ;  // dépend du contexte
            // Connexion
            Connection con = DriverManager.getConnection(
                    conString, nomConnexion, motDePasse) ;

            // Envoi d’un requête générique
            String sql =  "select * from departments" ;
            Statement smt = con.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;
            System.out.println(StringUtils.rightPad("department_id", 20)+StringUtils.rightPad("department_name", 20) + StringUtils.rightPad("location_id", 20));
            while (rs.next()) {
                System.out.println(StringUtils.rightPad(String.valueOf(rs.getInt("department_id")), 20) +
                        StringUtils.rightPad(rs.getString("department_name"), 20) +
                        StringUtils.rightPad(String.valueOf(rs.getInt("location_id")), 20)) ;
            }
        }  catch (Exception e) {
            // gestion des exceptions
            System.out.println(e.getMessage());
        }
    }
}
