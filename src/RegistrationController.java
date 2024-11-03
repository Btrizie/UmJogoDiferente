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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
    private Stage stage;
    private Scene scene;
    private boolean error;
    private int count;

    @FXML
    private TextField fieldName, fieldGrito, fieldYear;

    @FXML
    private ListView<String> listView;

    @FXML
    private Label errorLabel;

    @FXML
    void btnRegister(ActionEvent event) {
        error = false;
        count = Match.match.getId();
        errorHandling();
        if(error == false && count < 16){
            Team t = new Team(fieldName.getText(), fieldGrito.getText(), fieldYear.getText());
            Match.match.add(t);  
            updateListView();
        }
        else if(count == 16){
            errorLabel.setText("Maximum number of teams reached!");
        }
    }

    @FXML
    void btnStart(ActionEvent event) throws IOException {
        count = Match.match.getId();
        
        if(count >= 8 && count%2 == 0){
            Parent root = FXMLLoader.load(getClass().getResource("StartInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("[1]Start/Phases");
            stage.setScene(scene);
            stage.show();
        }
        else{
            errorLabel.setText("Unable to start the championship!");
        }
    }

    //faz o update da lista na interface
    private void updateListView() {
        List<Team> listaTimes = Match.match.getLTeams();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Team t: listaTimes) {
            items.add(t.toString());
        }
        listView.setItems(items);
    }

    public void errorHandling(){
        ifAux(fieldName);
        ifAux(fieldGrito);
        ifAux(fieldYear);
    }

    public void ifAux(TextField a){
        if(a.getText() == null || a.getText().trim().isEmpty()){
            a.setPromptText("Mandatory field!");
            error = true;
        } 
    }
}
