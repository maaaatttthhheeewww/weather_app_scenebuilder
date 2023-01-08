package application;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable, Co_ordinates{
	
	
	@FXML
	private ChoiceBox<String> myChoiceBox;
	@FXML
	private Label myLabel;
	@FXML
	private Button bt;
	
	private String[] places = {"Dublin", "London", "Rome", "Paris", "Madrid", "Armento", "Aughrim"};
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	myChoiceBox.getItems().addAll(places);
	bt.setOnAction(this::getWeather);
}

public void getWeather(ActionEvent event) {
	try {
		Object objs[];
		objs = Weather_api_class.getInfo(myChoiceBox.getValue());
		myLabel.setText(objs[1].toString()+"°C");
	} catch (URISyntaxException | IOException | InterruptedException e) {
		e.printStackTrace();
	}
}
}
