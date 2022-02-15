package west_jacob.savannah;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Layout {
    private Savannah model;
    private Controller controller;

    public SavannahView getView() {
        return view;
    }

    private SavannahView view;

    public Layout(Stage stage) {
        model = new Savannah();
        controller = new Controller(model, this);
        view = new SavannahView(model);

        //Top Info Bar
        HBox infoBarFlow = makeTopInfoBar();

        //Button Matrix
        GridPane btnPane = view.drawLayout();
        //btnPane.setGridLinesVisible(true);

        //Side Info
        GridPane sideInfo = makeSideInfoBar();

        //Set up the Main Layout
        GridPane pane = new GridPane();
        pane.setMinSize(600, 700);

        //Row Constraints
        RowConstraints row0 = new RowConstraints(75);
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        pane.getRowConstraints().addAll(row0, row1);

        //Column Constraints
        ColumnConstraints col0 = new ColumnConstraints(100);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(col0, col1);

        //Add nodes to pane
        pane.add(infoBarFlow, 0, 0, 2, 1);
        pane.add(btnPane, 1, 1);
        pane.add(sideInfo, 0, 1);
        //pane.setGridLinesVisible(true);


        Scene scene = new Scene(pane);
        stage.setTitle("Savannah Simulator");
        stage.setScene(scene);
        stage.show();
    }

    private HBox makeTopInfoBar() {
        HBox infoBarFlow = new HBox();
        infoBarFlow.setAlignment(Pos.CENTER);

        FlowPane resizeBtnFlow = new FlowPane(Orientation.VERTICAL);
        Button resizeThree = new Button("3x3");
        Button resizeFive = new Button("5x5");
        Button resizeEight = new Button("8x8");
        resizeBtnFlow.getChildren().addAll(resizeThree, resizeFive, resizeEight);

        GridPane resizeBtnGroup = new GridPane();
        Text resize = new Text("Resize: ");
        resizeBtnGroup.add(resizeBtnFlow, 1, 0);
        resizeBtnGroup.add(resize, 0, 0);

        Button newDayBtn = new Button("New Day");

        FlowPane textStatsFlow = new FlowPane(Orientation.VERTICAL);
        Text day = new Text("Day: 0");
        Text filled = new Text("Filled: 0");
        Text died = new Text("Died: 0");
        textStatsFlow.getChildren().addAll(day, filled, died);
        textStatsFlow.setAlignment(Pos.CENTER);

        Region spacer0 = new Region();
        HBox.setHgrow(spacer0, Priority.ALWAYS);

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        infoBarFlow.getChildren().addAll(textStatsFlow, spacer0, newDayBtn, spacer1, resizeBtnGroup);
        infoBarFlow.setAlignment(Pos.CENTER);

        return infoBarFlow;
    }

    private GridPane makeSideInfoBar() {
        GridPane sideInfo = new GridPane();
        sideInfo.setAlignment(Pos.CENTER );
        Text animalInfo = new Text("Animal Info");
        ComboBox<String> animalDropdown = new ComboBox<>();
        animalDropdown.getItems().addAll("Cheetah", "Zebra");
        animalDropdown.getSelectionModel().select(0);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton addBtn = new RadioButton("Add");
        RadioButton viewBtn = new RadioButton("View");
        addBtn.setToggleGroup(toggleGroup);
        viewBtn.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(addBtn);
        addBtn.setAlignment(Pos.CENTER);

        VBox selectInfo = new VBox();
        selectInfo.setAlignment(Pos.CENTER);
        selectInfo.getChildren().addAll(animalDropdown, addBtn, viewBtn);
        sideInfo.add(selectInfo, 0, 0);
        sideInfo.add(animalInfo, 0, 1);

        RowConstraints sideRow0 = new RowConstraints();
        RowConstraints sideRow1 = new RowConstraints();
        sideRow0.setPercentHeight(50);
        sideRow1.setPercentHeight(50);
        sideRow1.setValignment(VPos.TOP);
        sideInfo.getRowConstraints().addAll(sideRow0, sideRow1);

        ColumnConstraints sideCol0 = new ColumnConstraints();
        sideCol0.setHalignment(HPos.CENTER);
        sideInfo.getColumnConstraints().add(sideCol0);

        return sideInfo;
    }

    public void show() {
        //Show the view
    }
}