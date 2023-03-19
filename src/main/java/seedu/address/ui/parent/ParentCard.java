package seedu.address.ui.parent;

import java.io.File;
import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import seedu.address.model.person.parent.Parent;
import seedu.address.model.person.student.Student;
import seedu.address.ui.UiPart;

/**
 * A parent card feature in the UI representing parent information.
 */
public class ParentCard extends UiPart<Region> {
    private static final String FXML = "ParentCard.fxml";

    public final Parent parent;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private Label age;
    // @FXML
    // private Label image;
    @FXML
    private Circle circle;
    @FXML
    private Label id;
    @FXML
    private FlowPane students;
    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ParentCard(Parent parent, int displayedIndex) {
        super(FXML);
        this.parent = parent;
        id.setText(displayedIndex + ". ");
        name.setText(parent.getName().fullName);
        phone.setText(parent.getPhone().value);
        email.setText(parent.getEmail().value);
        address.setText(parent.getAddress().value);
        age.setText(parent.getAge().value);
        //image.setText(student.getImage().value);
        parent.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        parent.getStudents().stream()
                .sorted(Comparator.comparing(Student -> Student.getName().fullName))
                .forEach(Student -> {
                    students.getChildren().add(new Label(" Student Name: "));
                    students.getChildren().add(new Label(Student.getName().fullName));
                    students.getChildren().add(new Label("\n"));
                    students.getChildren().add(new Label(" Student Class: "));
                    students.getChildren().add(new Label(Student.getStudentClass().getClassName()));
                    students.getChildren().add(new Label("\n"));
                    students.getChildren().add(new Label(" Index Number: "));
                    students.getChildren().add(new Label(Student.getIndexNumber().value));
                    students.getChildren().add(new Label("\n"));
                });
        String path = "src/main/resources/images/" + parent.getName() + ".png";
        File file = new File(path);
        if (!file.exists()) {
            path = "src/main/resources/images/defaultParent.png";
            file = new File(path);
            Image newImage = new Image(file.toURI().toString());
            circle.setFill(new ImagePattern(newImage));
        } else {
            Image newImage = new Image(file.toURI().toString());
            circle.setFill(new ImagePattern(newImage));
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ParentCard)) {
            return false;
        }

        return false;
    }
}
