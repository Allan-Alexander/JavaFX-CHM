/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chelic_pneumatic;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saji
 */
public class ChelicFXMLController implements Initializable {

    @FXML
    private Pane SidePane;
    @FXML
    private JFXButton Force_Btn;
    @FXML
    private JFXTextField A1_txt = null;
    @FXML
    private JFXTextField A2_txt = null;
    @FXML
    private JFXTextField L_txt = null;
    @FXML
    private JFXTextField P_txt = null;
    @FXML
    private JFXTextField Lh_txt = null;
    @FXML
    private JFXTextField A3_txt = null;
    @FXML
    private Label Qa_txt;
    @FXML
    private Label Qb_txt;
    @FXML
    private Label Qn_txt;
    @FXML
    private JFXTextField n_txt = null;
    @FXML
    private JFXButton Clear_btn;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label Qa_txt1;
    @FXML
    private Label Qb_txt1;
    @FXML
    private Label Qn_txt1;

    public ChelicFXMLController() {
        this.A1_txt = null;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Force_Btn.setStyle("-fx-background-color:#2a1f45 ");
        
        
          A1_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                A1_txt.setText(oldValue);
            }
        }
    });
          
     A2_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                A2_txt.setText(oldValue);
            }
        }
    });
     
      A3_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                A3_txt.setText(oldValue);
            }
        }
    });
          
       L_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                L_txt.setText(oldValue);
            }
        }
    });
       
       
       
       Lh_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                Lh_txt.setText(oldValue);
            }
        }
    });
      
       
        P_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                P_txt.setText(oldValue);
            }
        }
    });
        
        
         n_txt.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("|[-\\+]?|[-\\+]?\\d+\\.?|[-\\+]?\\d+\\.?\\d+")){
                n_txt.setText(oldValue);
            }
        }
    });
          
          
    }

    
    @FXML
    private void Frc_btn(MouseEvent event) {
     Force_Btn.setStyle("-fx-background-color:#2a1f45 ");
     
    }

    @FXML
    private void submit_clicked(MouseEvent event) {
        try{
        float A1=0.00f,A2=0.00f,A3=0.00f,L=0.00f,Lh=0.00f,n=0.00f,P=0.00f,Qa = 0.00f,Qb = 0.00f,Qn=0.00f;
        A1 = Float.valueOf(A1_txt.getText());
        A2 = Float.valueOf(A2_txt.getText());
        A3 = Float.valueOf(A3_txt.getText());
        L = Float.valueOf(L_txt.getText());
        P = Float.valueOf(P_txt.getText());
        Lh = Float.valueOf(Lh_txt.getText());
        n = Float.valueOf(n_txt.getText());
           
        Qa = (A1+A2)*L*((P+1.033f)/1.033f)*(1/1000f);
        float Qa1 = ((A1+A2)*L*((P+1.033f)/1.033f)*(1/1000f))/60;
        Qa_txt.setText(String.valueOf(String.format("%.02f", Qa)));
        Qa_txt1.setText(String.valueOf(String.format("%.02f", Qa1)));
        
        Qb = 2*A3*Lh*(P/1.033f)*(1/1000f);
        float Qb1 = (2*A3*Lh*(P/1.033f)*(1/1000f))/60;
        Qb_txt.setText(String.valueOf(String.format("%.02f", Qb)));
        Qb_txt1.setText(String.valueOf(String.format("%.02f", Qb1)));
        
        Qn = (Qa+Qb)*n;
        float Qn1 = ((Qa+Qb)*n)/60;
        Qn_txt.setText(String.valueOf(String.format("%.02f", Qn)));
        Qn_txt1.setText(String.valueOf(String.format("%.02f", Qn1)));
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Input Fields Are Empty");
        }
        
        
        
        
     
    }

    @FXML
    private void clear_btn(MouseEvent event) {
       try{ A1_txt.setText("");
        A2_txt.setText("");
        A3_txt.setText("");
        L_txt.setText("");
        P_txt.setText("");
        Lh_txt.setText("");
        n_txt.setText("");
        Qa_txt.setText("");
        Qb_txt.setText("");
        Qn_txt.setText("");
        Qa_txt1.setText("");
        Qb_txt1.setText("");
        Qn_txt1.setText("");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error Occured");
       }
    }

    
    
    
    
    
}
