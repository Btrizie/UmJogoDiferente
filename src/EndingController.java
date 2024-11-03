import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class EndingController {
    @FXML
    private Label name;

    @FXML
    private Label slogan;

    @FXML
    private ListView<String> listViewPoints;

    @FXML
    void handle(MouseEvent event) {
        name.setText(Match.match.getLTeams().get(0).getName());
        slogan.setText(Match.match.getLTeams().get(0).getGrito());

        List<Team> lPoints = Match.match.getLTeams();
        ObservableList<String> items2 = FXCollections.observableArrayList();
            for (Team t: lPoints) {
                items2.add(t.toStringEnding());
            }
            listViewPoints.setItems(items2);
    }
}
