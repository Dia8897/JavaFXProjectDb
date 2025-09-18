package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        
//    BorderPane root = createBorderPaneSkeleton();       // Step 1
//      BorderPane root = createBorderPaneWithTop();        // Step 2
//         BorderPane root = createBorderPaneWithLeft();       // Step 3
//         BorderPane root = createBorderPaneWithCenter();     // Step 4
//        BorderPane root = createBorderPaneWithRight();      // Step 5
     		BorderPane root = createBorderPaneWithBottom();      // Step 6

//   Wrap BorderPane in a ScrollPane to be able to scroll
   ScrollPane scrollPane = new ScrollPane(root);
   scrollPane.setFitToWidth(true);
   scrollPane.setFitToHeight(true);

   // Scene now uses the scrollPane instead of root
   Scene scene = new Scene(scrollPane, 600, 600);
//   Scene scene = new Scene(root);
   primaryStage.setX(750);
   primaryStage.setY(0);
        
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("JavaFX Layout Puzzle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Step 1: Empty BorderPane
    private BorderPane createBorderPaneSkeleton() {
//      A BorderPane in JavaFX is a layout container that arranges its children into five regions:
//              1. Top – content at the top edge
//              2. Bottom – content at the bottom edge
//              3. Left – content along the left side
//              4. Right – content along the right side
//              5. Center-fills the remaining space in the middle
        BorderPane root = new BorderPane();
       
//      Adds padding inside the BorderPane (space between edges of the window and its children)

        // Just empty panes in each region to visualize
        root.setTop(new HBox());
        root.setLeft(new VBox());
        root.setCenter(new GridPane());
        root.setRight(new VBox());
        root.setBottom(new HBox());
//      empty objects in each of the five regions of the border pane
//      each region can contain a real object like: VBox, HBox, GridPane

        root.setStyle("-fx-border-color: gray; -fx-border-width: 5px;");
//      red border around the borderPane to see it clearly
        root.getStyleClass().add("body");

        return root;
//      returns the created borderPane
    }
   

    // Step 2: Top HBox
    private BorderPane createBorderPaneWithTop() {
        BorderPane root = createBorderPaneSkeleton();
        
        Label title = new Label("📅 Student Project Planner");
        title.getStyleClass().add("title");
        
        Label subtitle = new Label("Plan your week efficiently!");
        subtitle.getStyleClass().add("subTitle");
        
        TextField searchField = new TextField();
        searchField.setPromptText("Search tasks...");
        searchField.getStyleClass().add("search-field");
     
        searchField.setPrefWidth(200);
        
        Button profileBtn = new Button("👤");
        
        
        HBox top = new HBox(15,title,subtitle,searchField,profileBtn); //creating an HBox: horizontal container
        top.setAlignment(Pos.CENTER); //center all the children (title) horizontally 
        top.setPadding(new Insets(20)); //padding inside the HBox: space between HBox and title
        top.setStyle("-fx-border-color: steelblue; -fx-border-width: 3px;"); // visualize HBox with a blue border

        root.setTop(top); //puts the HBox inside the top region of the borderpane

        return root;
    }

    // Step 3: Left VBox
    private BorderPane createBorderPaneWithLeft() {
        BorderPane root = createBorderPaneWithTop(); //builds on top already

        Label tasksLabel = new Label("Tasks");
        Button task1 = new Button("✔ Research Topic - Alice (Due Today)");
        task1.getStyleClass().add("task-completed");

        Button task2 = new Button("❌ Design Prototype - Bob (Due Friday)");
        task2.getStyleClass().add("task-pending");

        Button task3 = new Button("⚠ Code Implementation - Charlie (Next Week)");
        task3.getStyleClass().add("task-progress");

        Button task4 = new Button("✔ Testing & QA - Diana (Done)");
        task4.getStyleClass().add("task-completed");

        Button task5 = new Button("📝 Final Report - Alice & Bob (Next Week)");
        task5.getStyleClass().add("task-report");

       VBox left = new VBox(15, tasksLabel,task1,task2,task3,task4,task5);
       root.setLeft(left);
//      creating a vertical container: 12 is the spacing between the children, the children are the label and the buttons
     
        left.setPadding(new Insets(15)); //padding inside the VBox, around the edges
        left.setAlignment(Pos.TOP_LEFT); //align the children at the top left of the VBox
        left.setPrefWidth(230); //set the preferred width of the VBox to ensure it doesn't shrink too much
        left.setStyle("-fx-border-color: darkslategray; -fx-border-width: 2px;"); // visualize VBox

   

        return root;
    }
    
    
    private BorderPane createBorderPaneWithCenter() {
        BorderPane root = createBorderPaneWithLeft(); // builds on top + left already
        root.setCenter(createCenterGridPane()); // adds the GridPane to the center
        return root;
    }

    private GridPane createCenterGridPane() {
    	//creating the elements of the gridPane
    	 Label centerTitle = new Label("Add New Task");
    	 centerTitle.getStyleClass().add("center-title");
    	    
    	 Label nameLabel = new Label("Task Name:");
    	 nameLabel.getStyleClass().add("center-label");
    	 TextField nameField = new TextField();
    	 nameField.getStyleClass().add("center-textfield");

    	 Label deadlineLabel = new Label("Deadline:");
    	    deadlineLabel.getStyleClass().add("center-label");
    	    TextField deadlineField = new TextField();
    	    deadlineField.getStyleClass().add("center-textfield");
    	    
    	    
    	    Label priorityLabel = new Label("Priority:");
    	    priorityLabel.getStyleClass().add("center-label");
    	    ChoiceBox<String> priorityBox = new ChoiceBox<>();
    	    priorityBox.getItems().addAll("Low", "Medium", "High");
    	    priorityBox.getStyleClass().add("center-choicebox");

    	    Button addButton = new Button("➕ Add Task");
    	    addButton.getStyleClass().add("center-add-button");
    	    

        Label assignedLabel = new Label("Assigned To:");       
        assignedLabel.getStyleClass().add("center-label");
        TextField assignedField = new TextField();               
        assignedField.getStyleClass().add("center-textfield");
         

      GridPane center = new GridPane();
      center.setHgap(12);
      center.setVgap(12);
      center.setPadding(new Insets(20));

        center.add(centerTitle, 0, 0);                           // row 0, col 0
        center.add(nameLabel, 0, 1);                              // row 1, col 0
        center.add(nameField, 1, 1);                              // row 1, col 1
        center.add(assignedLabel, 2, 1);                          // row 1, col 2
        center.add(assignedField, 2, 2);                          // row 2, col 2
        center.add(deadlineLabel, 0, 2);                          // row 2, col 0
        center.add(deadlineField, 1, 2);                          // row 2, col 1
        center.add(priorityLabel, 0, 3);                          // row 3, col 0
        center.add(priorityBox, 1, 3);                            // row 3, col 1
        center.add(addButton, 1, 4);                              // row 4, col 1



        center.setStyle("-fx-border-color:lightgray; -fx-border-width: 2px;"); // visualize GridPane
        center.getStyleClass().add("center-gridpane");

        return center;
    }
    
    
 // Step 5: Right VBox (Quick Actions)
    private BorderPane createBorderPaneWithRight() {
        BorderPane root = createBorderPaneWithCenter(); // builds on top + left + center already

        // Create label and buttons for quick actions
        Label quickLabel = new Label("Quick Actions");
        quickLabel.getStyleClass().add("right-label");
        
        Button viewCalendar = new Button("📆 View Calendar");
        viewCalendar.getStyleClass().add("calendar-btn");
        
        Button viewStats = new Button("📊 Progress Report");
        viewStats.getStyleClass().add("stats-btn");
        
        Button settings = new Button("⚙ Settings");
        settings.getStyleClass().add("settings-btn");

        // VBox to hold the quick actions vertically
        VBox right = new VBox(15,quickLabel, viewCalendar, viewStats,settings);
        root.setRight(right);
      
        right.setAlignment(Pos.TOP_CENTER); // align children at top center
        right.setPrefWidth(180); // preferred width
        right.setStyle("-fx-border-color: purple; -fx-border-width: 2px;"); // visualize VBox
        right.getStyleClass().add("right-vbox");       


        return root;
    }


    // Step 6: Bottom VBox + HBox (Charts)
    private BorderPane createBorderPaneWithBottom() {
        BorderPane root = createBorderPaneWithRight();
        root.setBottom(createBottomVBox());
        return root;
    }

    private VBox createBottomVBox() {
        Label chartLabel = new Label("📊 Task Statistics");

        PieChart pieChart = createPieChart();
        BarChart barChart = createBarChart();

        HBox chartsBox = new HBox(40, pieChart, barChart);
        chartsBox.setAlignment(Pos.CENTER);
        chartsBox.setPadding(new Insets(40));
        chartsBox.setStyle("-fx-border-color: brown; -fx-border-width: 5px;");

        VBox bottom = new VBox(20, chartLabel, chartsBox);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(15));
        bottom.setStyle("-fx-border-color: brown; -fx-border-width: 5px;");

        return bottom;
    }

    public PieChart createPieChart() {
    	ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    	data.addAll(
    			new PieChart.Data("Completed", 2),
    			new PieChart.Data("Pending", 3),
    			new PieChart.Data("Soon", 2));
    	PieChart pie = new PieChart(data);
    	
    	
    	pie.setLegendSide(Side.BOTTOM);
    	pie.setTitle("Tasks Status");
    	pie.setLabelLineLength(20);
    	pie.setLabelsVisible(true);
    	
    	pie.setId("statusPie");
    	return pie;
    	
   }
    
    public BarChart createBarChart() {
    	CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Priority");
        yAxis.setLabel("Number of Tasks");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Tasks by Priority");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Tasks");
        
        series.getData().add(new XYChart.Data<>("Low", 1));
        series.getData().add(new XYChart.Data<>("Medium", 2));
        series.getData().add(new XYChart.Data<>("High", 1));
        
        // we can change the legend's side
        barChart.setLegendSide(Side.TOP);
        barChart.getData().add(series);
        
        barChart.setId("priorityBar");
        
        return barChart;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
