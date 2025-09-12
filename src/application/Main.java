package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- Top (HBox: Title) ---
        Label title = new Label("📅 Ssstudents Projects Planner!!@@!!");
        title.setId("title");
        HBox top = new HBox(title);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20));

        // --- Left (VBox: Task List) ---
        Label tasksLabel = new Label("My Tasks");
        Button task1 = new Button("✔ Math Homework - Due Today");
        Button task2 = new Button("❌ Java Project - Due Friday");
        Button task3 = new Button("❌ Physics Lab Report - Next Week");
        Button task4 = new Button("✔ English Essay - Done");

        VBox left = new VBox(12, tasksLabel, task1, task2, task3, task4);
        left.setPadding(new Insets(15));
        left.setAlignment(Pos.TOP_LEFT);
        left.setPrefWidth(230);

        // --- Center (GridPane: Add Task Form) ---
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

        // --- Right (TilePane: Quick Actions) ---
        Label quickLabel = new Label("Quick Actions");
        Button viewCalendar = new Button("📆 View Calendar");
        Button viewStats = new Button("📊 Progress Report");
        Button settings = new Button("⚙ Settings");
        TilePane right = new TilePane(10, 10, viewCalendar, viewStats, settings);
        right.setAlignment(Pos.TOP_CENTER);
        right.setPadding(new Insets(15));
        VBox rightBox = new VBox(10, quickLabel, right);
        rightBox.setAlignment(Pos.TOP_CENTER);
        rightBox.setPrefWidth(180);

        // --- Bottom (Charts Section) ---
        Label chartLabel = new Label("📊 Task Statistics");

        // PieChart: Completed vs Pending
        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data("Completed", 2));
        pieChart.getData().add(new PieChart.Data("Pending", 2));
        pieChart.setTitle("Task Completion");

        // BarChart: Tasks by Priority
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

        HBox chartsBox = new HBox(40, pieChart, barChart);
        chartsBox.setAlignment(Pos.CENTER);
        chartsBox.setPadding(new Insets(15));

        VBox bottom = new VBox(10, chartLabel, chartsBox);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(15));

        // --- Root Layout (BorderPane) ---
        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setLeft(left);
        root.setCenter(center);
        root.setRight(rightBox);
        root.setBottom(bottom);

        // --- Scene ---
        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setTitle("Student Planner Demo - Layouts + Charts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
