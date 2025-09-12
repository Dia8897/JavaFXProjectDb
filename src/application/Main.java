package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        
      //   BorderPane root = createBorderPaneSkeleton();       // Step 1
//        BorderPane root = createBorderPaneWithTop();        // Step 2
//         BorderPane root = createBorderPaneWithLeft();       // Step 3
//         BorderPane root = createBorderPaneWithCenter();     // Step 4
//         BorderPane root = createBorderPaneWithRight();      // Step 5
   BorderPane root = createBorderPaneWithBottom();      // Step 6

        Scene scene = new Scene(root, 1000, 650);
        primaryStage.setTitle("JavaFX Layout Puzzle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Step 1: Empty BorderPane
    private BorderPane createBorderPaneSkeleton() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        return root;
    }

    // Step 2: Top HBox
    private BorderPane createBorderPaneWithTop() {
        BorderPane root = createBorderPaneSkeleton();
        root.setTop(createTopHBox());
        return root;
    }

    private HBox createTopHBox() {
        Label title = new Label("📅 Student Project Planner");
        HBox top = new HBox(title);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20));
        top.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");
        return top;
    }

    // Step 3: Left VBox
    private BorderPane createBorderPaneWithLeft() {
        BorderPane root = createBorderPaneWithTop();
        root.setLeft(createLeftVBox());
        return root;
    }

    private VBox createLeftVBox() {
        Label tasksLabel = new Label("My Tasks");
        Button task1 = new Button("✔ Math Homework - Due Today");
        Button task2 = new Button("❌ Java Project - Due Friday");
        Button task3 = new Button("❌ Physics Lab Report - Next Week");
        Button task4 = new Button("✔ English Essay - Done");

        VBox left = new VBox(12, tasksLabel, task1, task2, task3, task4);
        left.setPadding(new Insets(15));
        left.setAlignment(Pos.TOP_LEFT);
        left.setPrefWidth(230);
        left.setStyle("-fx-border-color: green; -fx-border-width: 2px;");
        return left;
    }

    // Step 4: Center GridPane
    private BorderPane createBorderPaneWithCenter() {
        BorderPane root = createBorderPaneWithLeft();
        root.setCenter(createCenterGridPane());
        return root;
    }

    private GridPane createCenterGridPane() {
        Label nameLabel = new Label("Task Name:");
        TextField nameField = new TextField();
        Label deadlineLabel = new Label("Deadline:");
        TextField deadlineField = new TextField();
        Label priorityLabel = new Label("Priority:");
        ChoiceBox<String> priorityBox = new ChoiceBox<>();
        priorityBox.getItems().addAll("Low", "Medium", "High");
        Button addButton = new Button("➕ Add Task");

        GridPane center = new GridPane();
        center.setHgap(12);
        center.setVgap(12);
        center.setPadding(new Insets(20));
        center.add(nameLabel, 0, 0);
        center.add(nameField, 1, 0);
        center.add(deadlineLabel, 0, 1);
        center.add(deadlineField, 1, 1);
        center.add(priorityLabel, 0, 2);
        center.add(priorityBox, 1, 2);
        center.add(addButton, 1, 3);
        center.setStyle("-fx-border-color: orange; -fx-border-width: 2px;"); // visualize
        return center;
    }

    // Step 5: Right VBox + TilePane
    private BorderPane createBorderPaneWithRight() {
        BorderPane root = createBorderPaneWithCenter();
        root.setRight(createRightVBox());
        return root;
    }

    private VBox createRightVBox() {
        Label quickLabel = new Label("Quick Actions");
        Button viewCalendar = new Button("📆 View Calendar");
        Button viewStats = new Button("📊 Progress Report");
        Button settings = new Button("⚙ Settings");

        TilePane right = new TilePane(10, 10, viewCalendar, viewStats, settings);
        right.setAlignment(Pos.TOP_CENTER);

        VBox rightBox = new VBox(10, quickLabel, right);
        rightBox.setAlignment(Pos.TOP_CENTER);
        rightBox.setPrefWidth(180);
        rightBox.setStyle("-fx-border-color: purple; -fx-border-width: 2px;");
        return rightBox;
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
        bottom.setStyle("-fx-border-color: brown; -fx-border-width: 5px;"); // visualize

        return bottom;
    }

    public PieChart createPieChart() {
    	PieChart pieChart = new PieChart();
    	pieChart.getData().add(new PieChart.Data("Completed", 2));
    	pieChart.getData().add(new PieChart.Data("Pending", 2));
    	pieChart.setTitle("Task Completion");
    	return pieChart;
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
        barChart.getData().add(series);
        return barChart;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
