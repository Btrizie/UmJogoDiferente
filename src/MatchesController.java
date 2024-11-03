import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MatchesController {
    private Stage stage;
    private Scene scene;
    private String tA, tB;
    private int idA, idB;

    private int blotsA, blotsB, plifsA, plifsB, advrunghsA, advrunghsB;

    @FXML
    private Label pointsA, pointsB;

    @FXML
    private Label teamA, teamB;

    @FXML
    void btnStart(ActionEvent event) {
        tA = Match.match.getTeamA();
        tB = Match.match.getTeamB();
        idA = Match.match.getIdA(tA);
        idB = Match.match.getIdB(tB);
        teamA.setText(tA);
        teamB.setText(tB);
    }

    @FXML
    void btnBlotA(ActionEvent event) {
        int int1 = Integer.parseInt(pointsA.getText());
        pointsA.setText(String.valueOf(int1 + 5));
        blotsA++;
    }

    @FXML
    void btnBlotB(ActionEvent event) {
        int int2 = Integer.parseInt(pointsB.getText());
        pointsB.setText(String.valueOf(int2 + 5));
        blotsB++;
    }

    @FXML
    void btnPlifA(ActionEvent event) {
        int int2 = Integer.valueOf(pointsB.getText());
        pointsB.setText(String.valueOf(int2 + 1));
        plifsB++;
    }

    @FXML
    void btnPlifB(ActionEvent event) {
        int int1 = Integer.valueOf(pointsA.getText());
        pointsA.setText(String.valueOf(int1 + 1));
        plifsA++;
    }

    @FXML
    void btnAdA(ActionEvent event) {
        int int1 = Integer.valueOf(pointsA.getText());
        pointsA.setText(String.valueOf(int1 - 10));
        advrunghsA++;
    }

    @FXML
    void btnAdB(ActionEvent event) {
        int int2 = Integer.valueOf(pointsB.getText());
        pointsB.setText(String.valueOf(int2 - 10));
        advrunghsB++;
    }

    @FXML
    void btnEnd(ActionEvent event) throws IOException {
        Match.match.getLTeams().get(idA).setPoints(blotsA, plifsA, advrunghsA);
        Match.match.getLTeams().get(idB).setPoints(blotsB, plifsB, advrunghsB);


        if(setWinner(idA, idB)){
            Parent root = FXMLLoader.load(getClass().getResource("StartInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("[1]Start/Phases");
            stage.setScene(scene);
            stage.show();
        }
        else{
            //arrumar aqui ainda 
            Parent root = FXMLLoader.load(getClass().getResource("GrushtInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("[4]Grusht");
            stage.setScene(scene);
            stage.show();
        }
    }

    public boolean setWinner(int idA, int idB) {
        List<Team> teams = Match.match.getLTeams();
        
        Team timeA = teams.get(idA);
        Team timeB = teams.get(idB);

        if (timeA.getTotal() > timeB.getTotal()) {
            Match.match.setLEnding(tA, tB, tA);
            return true;
        } 
        else if (timeB.getTotal() > timeA.getTotal()) {
            Match.match.setLEnding(tA, tB, tA);
            return true;
        } 
        else {
            return false;
        }
    }
}
