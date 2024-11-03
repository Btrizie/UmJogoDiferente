import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GrushtController {

    @FXML
    private TextField fieldDA;

    @FXML
    private TextField fieldDB;

    @FXML
    private Label teamA;

    @FXML
    private Label teamB;

    @FXML
    void handle(MouseEvent event) {
        teamA.setText(Match.match.getTeamA());
        teamB.setText(Match.match.getTeamB());
    }

    @FXML
    void btnValidate(ActionEvent event) throws IOException {
        int dBA = Integer.parseInt(fieldDA.getText());
        int dBB = Integer.parseInt(fieldDB.getText());
        String tA = Match.match.getTeamA();
        String tB = Match.match.getTeamB();
        int idA = Match.match.getIdA(tA);
        int idB = Match.match.getIdB(tB);

        if (dBA > dBB){
            Match.match.getLTeams().get(idA).setTotal(3);
            Match.match.setLEnding(tA, tB, tA);
        } 
        else if (dBA < dBB) {
            Match.match.getLTeams().get(idB).setTotal(3);
            Match.match.setLEnding(tA, tB, tB);
        }

        Parent root = FXMLLoader.load(getClass().getResource("StartInterface.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("[1]Start/Phases");
        stage.setScene(scene);
        stage.show();
    }

}

