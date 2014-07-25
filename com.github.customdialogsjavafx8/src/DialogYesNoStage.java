import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DialogYesNoStage extends Stage {

	private int option = 0;
	
	/**
	 * CUSTOM DIALOG YES/NO WINDOW
	 * @param title
	 * @param message
	 * @param width
	 * @param height
	 * @param icon
	 */
	public DialogYesNoStage(String title, String message, int width, int height, Image icon) {
		super();
		
		/* get stylesheet path */
		String stylesheet = DialogMessageStage.class.getResource("Style.css").toExternalForm();
		
		/* layout */
		BorderPane layout = new BorderPane();
		
		/* layout -> center */
		TextArea textArea = new TextArea(message);
		textArea.setWrapText(true);
		textArea.setEditable(false);
		textArea.setId("textArea");
		textArea.getStylesheets().add(stylesheet);
		
		/* layout -> bottom */
		HBox buttonsBox = new HBox(20);
		
		Button yes = new Button("Yes");
		yes.setPrefWidth(60);
		yes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				option = 1;
				close();
			}
		});
		
		Button no = new Button("No");
		no.setPrefWidth(60);
		no.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				option = 2;
				close();
			}
		});
		
		buttonsBox.getChildren().addAll(yes, no);
		buttonsBox.setAlignment(Pos.CENTER);
		
		/* add items to the layout */
		layout.setCenter(textArea);
		layout.setBottom(buttonsBox);
		
		BorderPane.setMargin(textArea, new Insets(20, 10, 10, 10));
		BorderPane.setMargin(buttonsBox, new Insets(10, 10, 20, 10));
		
		/* create scene */
		Scene scene = new Scene(layout, width, height);
		
		/* set stage preferences */
		this.setScene(scene);
		this.setTitle(title);
		this.setResizable(false);
		if (icon != null) {
			this.getIcons().add(icon);
		}
		
		/* un-comment line below if you want dialog to be always on top */
		//this.initModality(Modality.APPLICATION_MODAL);
	}
	
	/**
	 * RETURN OPTION VALUE
	 * =============================
	 * // Example use in practise:
	 * 
	 * int option;
	 * DialogYesNoStage dialog = new DialogYesNoStage(title, message, width, height, icon);
	 * dialog.showAndWait();
	 * option = dialog.getOption();
	 * switch (option) {
	 *     case 0:
	 *         // do something
	 *         break;
	 *     case 1:
	 *         // do something
	 *         break;
	 *     case 2:
	 *         // do something
	 *         break;
	 * }
	 * =============================
	 * @return
	 */
	public int getOption() {
		return option;
	}
}
