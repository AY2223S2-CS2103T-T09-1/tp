package seedu.address.logic.commands.student;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.student.IndexNumber;
import seedu.address.model.person.student.Student;
import seedu.address.model.person.student.StudentClass;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class StudentDeleteCommand extends StudentCommand {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the student identified by their index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_STUDENT_SUCCESS = "Deleted Student: %1$s";

    private final IndexNumber targetIndex;
    private final StudentClass studentClass;

    public StudentDeleteCommand(IndexNumber targetIndex, StudentClass studentClass) {
        this.targetIndex = targetIndex;
        this.studentClass = studentClass;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Student> Students = model.getFilteredStudentList();

        for (Student student : Students) {
            if (student.getIndexNumber().equals(targetIndex)
                    && student.getStudentClass().equals(studentClass)) {
                model.deleteStudent(student);
                return new CommandResult(String.format(MESSAGE_DELETE_STUDENT_SUCCESS, student));
            }
        }

        throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudentDeleteCommand // instanceof handles nulls
                && targetIndex.equals(((StudentDeleteCommand) other).targetIndex)); // state check
    }
}
