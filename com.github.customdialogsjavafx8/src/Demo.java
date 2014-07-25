import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * CUSTOM SPINNER CONTROL
 * ===============================
 * Last Update : 2014/07/25, 14:52
 * ===============================
 * Demo ilustrating work of two custom dialog windows:
 * "DialogMessageStage" and "DialogYesNoStage".
 * 
 * @author bluevoxel
 * https://github.com/bluevoxel
 *
 */
public class Demo extends Application {

	public Parent createContent() {
		
		/* layout */
		BorderPane layout = new BorderPane();
		
		/*layout -> center*/
		VBox content = new VBox(10);
		
		Button openDialogMessageStage = new Button("Open Message Dialog");
		openDialogMessageStage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				DialogMessageStage dialog = new DialogMessageStage("Dialog Message Stage", 
						"This is an example of dialog message window.", 320, 100, null);
				dialog.show();
			}
		});
		
		Button openDialogYesNoStage = new Button("Open Yes/No Dialog");
		openDialogYesNoStage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				int option;
				DialogYesNoStage dialog = new DialogYesNoStage("Dialog Yes/No Stage", 
						"Choose \"Yes\" to change background color of the \"Open Yes/No Dialog\" button. "
						+ "Choose \"No\" to reset its background color.", 320, 140, null);
				dialog.showAndWait();
				option = dialog.getOption();
				switch (option) {
					case 0:
						// do nothing;
						break;
					case 1:
						openDialogYesNoStage.setStyle("-fx-background-color: #0080FF;");
						break;
					case 2:
						openDialogYesNoStage.setStyle(null);
						break;
				}
			}
		});
		
		content.getChildren().addAll(openDialogMessageStage, openDialogYesNoStage);
		content.setAlignment(Pos.CENTER);
		
		/* add items to the layout */
		layout.setCenter(content);
		return layout;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.setWidth(300);
		stage.setHeight(200);
		stage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
