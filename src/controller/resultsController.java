package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.Exercise;
import model.Session;
import java.util.ArrayList;
import java.util.HashMap;


public class resultsController {
    public TextField timeField;
    public TextField distanceField;
    public Label timeLabel;
    public Label distanceLabel;
    public Text messageLable;
    public Label repsLabel;
    public Label weigthLabel;
    public TextField repsField;
    public TextField weigthField;
    public RadioButton strengthButton;
    public RadioButton enduranceButton;
    public ComboBox<String> sessionChoice;
    public HashMap<String,Integer> sessionMap;
    public ComboBox<String> exerciseChoice;
    private HashMap<String,Integer> exerciseMap;

    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        sessionMap = new HashMap<>();
        exerciseMap = new HashMap<>();
        strengthButton.setToggleGroup(group);
        enduranceButton.setToggleGroup(group);
        strengthButton.setSelected(true);
        fillSessionsBox();
        fillExerciseBox();
        enduranceButton.selectedProperty().addListener((obj,oldValue,newValue)->{
            if(newValue) {
                timeLabel.setVisible(true);
                timeField.setVisible(true);
                distanceLabel.setVisible(true);
                distanceField.setVisible(true);
                repsLabel.setVisible(false);
                repsField.setVisible(false);
                weigthField.setVisible(false);
                weigthLabel.setVisible(false);
            }else{
                timeLabel.setVisible(false);
                timeField.setVisible(false);
                distanceLabel.setVisible(false);
                distanceField.setVisible(false);
                repsLabel.setVisible(true);
                repsField.setVisible(true);
                weigthField.setVisible(true);
                weigthLabel.setVisible(true);
            }
        });


    }

    private void fillSessionsBox(){
        sessionChoice.setItems(FXCollections.observableArrayList(Session.fecthAllSessions()));
        ArrayList<String> array = Session.fecthAllSessions();
        array.forEach(s->{
            int id = Integer.parseInt(s.split("-")[0]);
            sessionMap.put(s,id);
        });
    }

    private void fillExerciseBox(){
        ArrayList<String> array = Exercise.fetchAllExercises();
        ArrayList<String> nameArray = new ArrayList<>();
        array.forEach(s->{
            int id = Integer.parseInt(s.split(",")[0]);
            String name = s.split(",")[1];
            exerciseMap.put(name,id);
            nameArray.add(name);
        });
        exerciseChoice.setItems(FXCollections.observableArrayList(nameArray));
    }


    public void buttonPressed(ActionEvent actionEvent) {

    }
}