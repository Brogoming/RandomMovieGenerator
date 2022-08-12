import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class Main extends Application implements EventHandler<ActionEvent>{
	
	Button buttonH = new Button("Horror");
	Button buttonC = new Button("Comedy");
	Text moviePresent = new Text();
	MovieList movieList = new MovieList();
	Stage window = new Stage();
	String horror = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\horrorMovies.txt";
	String comedy = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\comedyMovies.txt";

	public static void main(String[] args) {
		launch(args); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Random Movie Generator");
		window.setMinWidth(250);
		window.setMinHeight(250);
		
		HBox topMenu = new HBox(); 
		buttonH.setOnAction(this);
		buttonC.setOnAction(this);
		topMenu.getChildren().addAll(buttonH, buttonC); 

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu); 
		borderPane.setCenter(moviePresent);

		Scene scene = new Scene(borderPane, 500, 450); 
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
	}

}
