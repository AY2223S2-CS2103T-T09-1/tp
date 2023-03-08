package seedu.address.model.person.student;

import java.time.LocalDate;

public class Homework extends Assignment{
    public static final String MESSAGE_CONSTRAINTS = "Homework must be letters or numbers";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    private boolean isDone;

    public Homework(String assignmentName, LocalDate deadline, int weightage, int maxScore, boolean isDone) {
        super(assignmentName, deadline, weightage, maxScore);
        this.isDone = isDone;
    }

    public static boolean isValidHomework(String test) {
        if (test.equals("Insert student homework here!")) {
            return true;
        }
        return test.matches(VALIDATION_REGEX);
    }
    /*

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Test// instanceof handles nulls
                && value.equals(((Test) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

     */

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}