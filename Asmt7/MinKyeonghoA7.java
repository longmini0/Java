import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.*;


public class MinKyeonghoA7 extends Application {

    // Initialize labels that will be used in start() method
    Label title, firstName, lastName, gender, phoneNumber, university, skills;

    @Override
    public void start(Stage myStage) {

        // Give the stage a title
        myStage.setTitle("New Grad Application");

                /* Create the elements of the first scene - 'myScene1' */

            /* [1] 'Title' element */
            // Create an user's title selection using ListView
            // Source: Class note 'XChapters7-JavaFX.pdf -  page25 - 27'
        // Create a label
        title = new Label("Titles");
        Text titleInput = new Text("");  // text initialization to get the user selection
        // Create an ObservableList of entries for the list view
        ObservableList<String> titles = FXCollections.observableArrayList("Mr.", "Mrs.",
                "Ms.", "Ph.D.", "Dr.", "Prof.");
        ListView<String> myTitle = new ListView<>(titles);  // Create the list view
        myTitle.setPrefSize(100,70); // Set the height and width
        // Get the selected item in the list view
        myTitle.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            public void changed(ObservableValue<? extends String> changed, String oldVal,
                                String newVal) {
                // Set the text using new selected value
                titleInput.setText(newVal);
            }
        });

            /* [2] 'First Name', 'Last Name', 'Phone Number' elements */
            // Create an input field from user's name and phone number using TextField
            // Source: Class note 'XChapters7-JavaFX.pdf - page30 - 33'
        // Create labels
        firstName = new Label("First Name");
        lastName = new Label("Last Name");
        phoneNumber = new Label("Phone Number");
        // Create text fields
        TextField firstFld = new TextField();
        TextField lastFld = new TextField();
        TextField phoneFld = new TextField();
        // text initialization to get the user input
        Text fullName = new Text("");
        Text myPhoneNumber = new Text("");


            /* [3] 'Gender' element */
            // Create an user's gender selection using RadioButton
            // Source: https://www.javatpoint.com/javafx-radiobutton
        // Create a label
        gender = new Label("Gender");
        // text initialization to get the user selection from radio button
        Text myGender = new Text("");
        Text selGen = new Text("");
        // set up the toggle group to make sure the user can select only one button in a group
        ToggleGroup group = new ToggleGroup();
        // Create RadioButtons and set the toggle group
        RadioButton rbMale = new RadioButton("Male");
        RadioButton rbFemale = new RadioButton("Female");
        RadioButton rbOther = new RadioButton("Other");
        rbMale.setToggleGroup(group);
        rbFemale.setToggleGroup(group);
        rbOther.setToggleGroup(group);
        // Get an user selection from group
        // Source: https://www.geeksforgeeks.org/javafx-radiobutton-with-examples/
        group.selectedToggleProperty().addListener(new ChangeListener<>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)group.getSelectedToggle();
                if (rb != null) {
                    String selGender = rb.getText(); // get a user's selected text
                    selGen.setText(selGender); // set the text as user choice
                }
            }
        });


            /* [4] 'University' element */
            // Create an user's university selection using editable ComboBox
            // Source: https://www.tutorialspoint.com/how-to-edit-a-combobox-in-javafx
        // Create a label
        university = new Label("University");
        // text initialization to get user's selection from ComboBox
        Text selUni = new Text("");
        Text myUniversity = new Text("");
        // Create ComboBox
        ComboBox<String> myUniver = new ComboBox<>();
        // Create universities list and add several universities
        ObservableList<String> universities = myUniver.getItems();
        universities.addAll("UC Berkeley", "Stanford University", "UC Los Angeles", "UC Irvine",
                "Santa Clara University", "San Jose State University", "Yonsei University",
                "Seoul National University", "University of Southern California");
        myUniver.setEditable(true); // make ComboBox editable
        // Get an user's university input
        // Source: http://www.java2s.com/Code/Java/JavaFX/AddchangelistenertoComboBoxvalueProperty.htm
        myUniver.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String oldVal,
                                String newVal) {
                selUni.setText(newVal);     // set the text as user's input
            }
        });

            /* [5] 'Skills' element */
            // Create an user's skill selection using multiple selection ListView
            // Source: https://self-learning-java-tutorial.blogspot.com/2018/06/javafx-listview-select-multiple-items.html
        // Create a label
        skills = new Label("Skills");
        // Text initialization to get user's multiple selection
        Text myAbilities = new Text("");
        Text selAbs = new Text("");
        // Create skills list
        ObservableList<String> skillLists = FXCollections.observableArrayList("Java", "Python",
                "MySQL", "C++", "Machine Learning", "Deep Learning", "R programming", "JavaScript",
                "Excel", "MS Word", "Powerpoint", "Data mining", "Data preprocessing", "Data analyzing");
        // Create ListView and set skills from skillsList above
        ListView<String> mySkill = new ListView<>();
        mySkill.setItems(skillLists);
        // enable skills to be selected multiple
        mySkill.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        mySkill.setPrefSize(100,70);
        // Handle the mouse click event to make sure the user does not need to press 'ctrl' to choose multiple
        // Source: https://stackoverflow.com/questions/40900478/mimicking-ctrlclick-multiple-selection-in-listview-using-javafx
        mySkill.addEventFilter(MouseEvent.MOUSE_PRESSED, evt -> {
            Node node = evt.getPickResult().getIntersectedNode();

            while (node != null && node != mySkill && !(node instanceof ListCell)) {
                node = node.getParent();
            }

            if (node instanceof ListCell) {
                // prevent further handling
                evt.consume();

                ListCell cell = (ListCell) node;
                ListView lv = cell.getListView();

                // focus the listview
                lv.requestFocus();

                if (!cell.isEmpty()) {
                    // handle selection for non-empty cells
                    int index = cell.getIndex();
                    if (cell.isSelected()) {
                        lv.getSelectionModel().clearSelection(index);
                    } else {
                        lv.getSelectionModel().select(index);
                    }
                }
            }

        });
        // Get the multiple selected skills from user
        // Source: https://coderanch.com/t/708325/java/JavaFX-Display-Multiple-Selected-Items
        mySkill.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> changed, String oldVal,
                                String newVal) {
                String selItems = ""; // initialize string
                ObservableList<String> selected = mySkill.getSelectionModel().getSelectedItems();
                for (String item : selected) {
                    // Create user skills and arrange them
                    selItems += item + " ";
                }
                selAbs.setText(selItems); // set text as user's skills
            }
        });






                /* Create the second scene */
            // Use a GridPane for the rootNode2 and create the second scene - 'myScene2'
            // Source: https://www.javatpoint.com/javafx-gridpane
        GridPane rootNode2 = new GridPane();
        // set a vertical and horizontal gap between elements
        rootNode2.setVgap(10);
        rootNode2.setHgap(5);
        rootNode2.setAlignment(Pos.CENTER_LEFT); // align rootNode - CENTER_LEFT
        rootNode2.setPadding(new Insets(0,10,0,10)); // create padding to the left
        // Create a scene
        Scene myScene2 = new Scene(rootNode2, 500,600);

                /* Create the third Scene */
            // Use a FlowPane for rootNode3 and create the third scene - 'myScene3'
            // Source: Class note 'XChapters7-JavaFX.pdf'
        FlowPane rootNode3 = new FlowPane();
        rootNode3.setAlignment(Pos.CENTER); // align rootNode - CENTER
        // Create a scene
        Scene myScene3 = new Scene(rootNode3, 500,600);


            /* Review button action */
        // Create 'Review' button in myScene1 and set its action for myScene2
        Button btnReview = new Button("Review");
        btnReview.setOnAction(e -> {
            // Move to the second scene - 'myScene2'
            myStage.setScene(myScene2);

            // Get the user selections of title, firstname, lastname and concatenate them as a full name
            // Source: https://www.tutorialspoint.com/how-to-retrieve-the-contents-of-a-text-field-in-javafx
            String titleValue = titleInput.getText();
            String fName = firstFld.getText();
            String lName = lastFld.getText();
            fullName.setText(titleValue + " " + fName + " " + lName);

            // Get the user selection of gender from RadioButton
            String genderValue = selGen.getText();
            myGender.setText("Gender: " + genderValue);

            // Get the user input of phone number from TextField
            String pNumber = phoneFld.getText();
            myPhoneNumber.setText("Phone Number: " + pNumber);

            // Get the user input of university from editable ComboBox
            String uniValue = selUni.getText();
            myUniversity.setText("University: " + uniValue);

            // Get the user multiple selections of skills from ListView
            String skillValue = selAbs.getText();
            myAbilities.setText("Skills selected are: " + skillValue);

        });


                /* Create the first scene */
            // Use a GridPane for rootNode1 and create the first scene - 'myScene1'
            // Source: https://www.javatpoint.com/javafx-gridpane
        GridPane rootNode = new GridPane();
        // Set the vertical and horizontal gap between elements
        rootNode.setVgap(12);
        rootNode.setHgap(5);
        rootNode.setAlignment(Pos.CENTER_LEFT); // align rootNode - CENTER_LEFT
        rootNode.setPadding(new Insets(0,10,0,10)); // Set the padding
        // Create a scene
        Scene myScene1 = new Scene(rootNode, 500,600);


            /* Arrange the elements in myScene1 by adding several rows */
            // Source: https://www.javatpoint.com/javafx-gridpane
        rootNode.addRow(0, title);
        rootNode.addRow(1, myTitle);
        rootNode.addRow(2, firstName, lastName);
        rootNode.addRow(3, firstFld, lastFld);
        rootNode.addRow(4, gender, phoneNumber);
        rootNode.addRow(5, rbMale, phoneFld);
        rootNode.addRow(6, rbFemale);
        rootNode.addRow(7, rbOther);
        rootNode.addRow(8, university);
        rootNode.addRow(9, myUniver);
        rootNode.addRow(10, skills);
        rootNode.addRow(11, mySkill);
        rootNode.addRow(12, btnReview);



                /* Create labels and buttons in myScene2 */
            // Source: http://www.learningaboutelectronics.com/Articles/How-to-create-multiple-scenes-and-switch-between-scenes-in-JavaFX.php
        Label label2 = new Label("Thank you for applying, please review your details");
        // Create a back button
        Button btnBack = new Button("< Back");
        btnBack.setOnAction(e -> {
            myStage.setScene(myScene1); // go back to myScene1 to re-edit
        });
        // Create a submit button
        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(e -> {
            myStage.setScene(myScene3); // submit and move to myScene3
        });


            /* Arrange elements in myScene2 by adding several rows */
            // Source: https://www.javatpoint.com/javafx-gridpane
        rootNode2.addRow(0, btnBack);
        rootNode2.addRow(1, label2);
        rootNode2.addRow(2, fullName);
        rootNode2.addRow(3, myGender);
        rootNode2.addRow(4, myPhoneNumber);
        rootNode2.addRow(5, myUniversity);
        rootNode2.addRow(6, myAbilities);
        rootNode2.addRow(7, btnSubmit);



            /* Create the label in myScene3 */
        Label label3 = new Label("Congratulations! Application Sent.");
        // Display the label
        rootNode3.getChildren().addAll(label3);

        // Set the scene on the Stage
        myStage.setScene(myScene1);
        // Show the stage and its scene
        myStage.show();

    }

    public static void main(String[] args) {
        // Start the JavaFx application by calling launch()
        Application.launch(args);
    }

}
