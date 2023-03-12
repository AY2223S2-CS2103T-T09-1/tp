package seedu.address.model.person.student;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an Assignment that is assigned to the Student.
 */
public class Assignment {
    protected final String assignmentName;
    protected LocalDate deadline;
    protected final int weightage;
    protected final int maxScore;
    protected int score;

    /**
     * Returns an Assignment object that stores information about the assignment description.
     *
     * @param assignmentName Assignment name.
     * @param deadline Due date for the assignment.
     * @param weightage Weightage of the assignment.
     * @param maxScore Maximum score attainable for the assignment.
     */
    public Assignment(String assignmentName, LocalDate deadline, int weightage, int maxScore, int score) {
        this.assignmentName = assignmentName;
        this.deadline = deadline;
        this.weightage = weightage;
        this.maxScore = maxScore;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Assignment that = (Assignment) o;
        return weightage == that.weightage && maxScore == that.maxScore && assignmentName.equals(that.assignmentName)
                && Objects.equals(deadline, that.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentName, deadline, weightage, maxScore);
    }
}
