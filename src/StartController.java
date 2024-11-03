import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StartController {
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> listViewPoints;

    @FXML
    private ListView<String> listViewMatches;

     @FXML
    private Label errorChoice;

    @FXML
    void btnTables(ActionEvent event) throws IOException{
        if(Match.match.getLMatches() == null){
            Parent root = FXMLLoader.load(getClass().getResource("EndingInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node)event.getSource())).getScene().getWindow();
            stage.setTitle("[5]Ending");
            stage.setScene(scene);
            stage.show();
        }
        else{
            List<String> lMatches = Match.match.getLMatches();
            ObservableList<String> items = FXCollections.observableArrayList(lMatches);
            listViewMatches.setItems(items);

            List<Team> lPoints = Match.match.getLTeams();
            ObservableList<String> items2 = FXCollections.observableArrayList();
            for (Team t: lPoints) {
                items2.add(t.toStringPartida());
            }
            listViewPoints.setItems(items2);
        }
        
    }

    @FXML
    void btnStart(ActionEvent event) throws IOException {
        String choice = listViewMatches.getSelectionModel().getSelectedItem();
        if(choice != null){
            Match.match.setTeams(choice);
            Parent root = FXMLLoader.load(getClass().getResource("MatchesInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("[3]Matches");
            stage.setScene(scene);
            stage.show();
        }
        else{
            errorChoice.setText("Select a match to start!");
        }
        
    }
}
