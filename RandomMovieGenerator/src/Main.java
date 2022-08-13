import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Main extends Application implements EventHandler<ActionEvent>{
	
	Button buttonH = new Button("Horror");
	Button buttonC = new Button("Comedy");
	Button buttonA = new Button("Action");
	Button buttonR = new Button("Romance");
	Text moviePresent = new Text();
	Label label = new Label("The Movie:");
	MovieList movieList = new MovieList();
	Stage window = new Stage();
	String horror = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\horrorMovies.txt";
	String comedy = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\comedyMovies.txt";
	String action = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\actionMovies.txt";
	String romance = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\romanceMovies.txt";

	public static void main(String[] args) {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Random Movie Generator");
		window.setMinWidth(250);
		window.setMinHeight(250);
		
		moviePresent.setFill(Color.WHITE);
		buttonH.getStyleClass().add("button-purple");
		buttonC.getStyleClass().add("button-yellow");
		buttonA.getStyleClass().add("button-red");
		buttonR.getStyleClass().add("button-pink");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10)); 
		grid.setVgap(8); 
		grid.setHgap(10); 
		
		buttonH.setOnAction(this);
		buttonC.setOnAction(this);
		buttonA.setOnAction(this);
		buttonR.setOnAction(this);
		
		GridPane.setConstraints(buttonH, 0, 0);
		GridPane.setConstraints(buttonC, 0, 1);
		GridPane.setConstraints(buttonA, 0, 2);
		GridPane.setConstraints(buttonR, 0, 3);
		GridPane.setConstraints(moviePresent, 3, 1);
		GridPane.setConstraints(label, 3, 0);

		grid.getChildren().addAll(buttonH, buttonC, buttonA, buttonR, moviePresent, label);
		Scene scene = new Scene(grid, 500, 450); 
		scene.getStylesheets().add("CSS1.css");
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == buttonH) {
			movieList.ReadFile(horror);
			moviePresent.setText(movieList.RandomMovie());
		}
		if(event.getSource() == buttonC) { 
			movieList.ReadFile(comedy);
			moviePresent.setText(movieList.RandomMovie());
		}
		if(event.getSource() == buttonA) { 
			movieList.ReadFile(action);
			moviePresent.setText(movieList.RandomMovie());
		}
		if(event.getSource() == buttonR) { 
			movieList.ReadFile(romance);
			moviePresent.setText(movieList.RandomMovie());
		}
	}
}
