import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class InterestTableGUI extends Application {
	
	double year;
	TextArea displayArea;
	Button simple, compound, both;
	
	Label principal = new Label("Principal:");
	
	Label rate = new Label("Rate(Percentage):");
	
	Label numYears = new Label("Number of Years:");
	
	TextField principalIn = new TextField();
	
	TextField rateIn = new TextField();
	
	Slider horizontalSlider = new Slider();
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Interest Table Calculator");
		simple = new Button();
		compound = new Button();
		both = new Button();
		simple.setText("SimpleInterest");
		compound.setText("CompoundInterest");
		both.setText("BothInterests");
		
		displayArea = new TextArea();
		displayArea.setEditable(false);
		
		horizontalSlider.setPrefWidth(250);
		horizontalSlider.setMin(1);
		horizontalSlider.setMax(25);
		horizontalSlider.setValue(1);
		horizontalSlider.setMajorTickUnit(4);
		horizontalSlider.setShowTickMarks(true);
		horizontalSlider.setShowTickLabels(true);
		horizontalSlider.valueProperty().addListener(e -> {year=(horizontalSlider.getValue());});
		/* Setting the listener */ 
		
		HBox display = new HBox(8);
		display.getChildren().add(displayArea);

		HBox pane = new HBox(8);
		pane.getChildren().addAll(simple,compound, both);
		pane.setAlignment(Pos.CENTER);
		
		HBox pane2 = new HBox(8);
		
		pane2.getChildren().addAll(principal,principalIn, rate, rateIn);
		
		HBox slider = new HBox(8);
		slider.getChildren().addAll(numYears,horizontalSlider);
		slider.setAlignment(Pos.CENTER);
		
		VBox product = new VBox(8);
		product.getChildren().addAll(display, pane2,slider, pane);
		
		compound.setOnAction(new ButtonHandler());
		
		simple.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double pNum = Double.parseDouble(principalIn.getText());
				double rNum = Double.parseDouble(rateIn.getText());
				
				Interest interest = new Interest(pNum, rNum, year);
				displayArea.setText(interest.simpleInterest(pNum, rNum, year));
			}
		});
		
		both.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double pNum = Double.parseDouble(principalIn.getText());
				double rNum = Double.parseDouble(rateIn.getText());
				
				Interest interest = new Interest(pNum, rNum, year);
				displayArea.setText(interest.bothInterest(pNum, rNum, year));
			}
		});
		
		Scene scene = new Scene(product, 480,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			double pNum = Double.parseDouble(principalIn.getText());
			double rNum = Double.parseDouble(rateIn.getText());			
			Interest interest = new Interest(pNum, rNum, year);
			displayArea.setText(interest.compoundInterest(pNum, rNum, year));
		}
	}
}