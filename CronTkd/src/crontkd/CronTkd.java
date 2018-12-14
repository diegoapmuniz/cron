/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crontkd;

import cron.Cron;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Diego Muniz <diego2605@gmail.com>
 */
public class CronTkd extends JApplet {

    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                      
                 
                UIManager.put("OptionPane.background",new ColorUIResource(new java.awt.Color(218, 230, 205)));
                UIManager.put("ContentPane.background",new ColorUIResource(new java.awt.Color(218, 230, 205)));
                UIManager.put("Panel.background",new ColorUIResource(new java.awt.Color(218, 230, 205)));
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                   
                } catch (Exception e) {
                }
                
                Cron cron = new Cron();
                //conexaobanco();
                cron.setTitle("Cronômetro V1.0");
                
                cron.setVisible(true);
                

            }

            /*private void conexaobanco() {
                    System.out.println("Entrou Na Conexão");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/banco/dbTeste", "sa", "");

            //Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println(nome + " - " + email);
            }
           // stm.execute("SHUTDOWN");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver JDBC. ");
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e);
            e.printStackTrace();
        }
            }*/
        });
    }

    @Override
    public void init() {
        
        /*fxContainer = new JFXPanel();
         fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
         add(fxContainer, BorderLayout.CENTER);*/
        // create JavaFX scene
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                //conexaoBanco();

                //createScene();
            }
        });
    }

    private void createScene() {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        fxContainer.setScene(new Scene(root));
    }

    /*public void conexaoBanco() {
        System.out.println("Entrou Na Conexão");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/banco", "sa", "");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println(nome + " - " + email);
            }
            stm.execute("SHUTDOWN");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver JDBC. ");
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e);
            e.printStackTrace();
        }
    }*/

}
