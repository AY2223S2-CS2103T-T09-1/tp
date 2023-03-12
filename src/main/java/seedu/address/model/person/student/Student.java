package seedu.address.model.person.student;

import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Age;
import seedu.address.model.person.Comment;
import seedu.address.model.person.Email;
import seedu.address.model.person.Image;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Sex;
import seedu.address.model.tag.Tag;

/**
 * Represents a Student object extends from Person class.
 */
public class Student extends Person {
    private final IndexNumber indexNumber;
    private final Sex sex;
    private final ParentName parentName;
    private final Age age;
    private final Image image;
    private final Cca cca;
    private final StudentClass sc;
    private Attendance attendance;
    private Homework homework;
    private Test test;
    private Comment comment;

    /**
     * Returns a Student object that stores information about the student particulars.
     *
     * @param name Student's name.
     * @param sc Student's class.
     * @param indexNumber Student's index number.
     * @param sex Student's gender.
     * @param parentName Student's parent's / NOK(next-of-kin)'s name.
     * @param age Student's age.
     * @param image Student's image.
     * @param email Student's email address.
     * @param phone Student's contact number.
     * @param cca Student's CCA.
     * @param address Student's residential address.
     * @param attendance Student's attendance.
     * @param homework Homework given to student.
     * @param test Tests student took.
     * @param tags Tag given to student.
     */
    public Student(Name name, StudentClass sc, IndexNumber indexNumber, Sex sex, ParentName parentName, Age age,
                   Image image, Email email, Phone phone, Cca cca, Address address, Attendance attendance,
                   Homework homework, Test test, Set<Tag> tags, Comment comment) {
        super(name, phone, email, address, tags);
        this.indexNumber = indexNumber;
        this.sex = sex;
        this.parentName = parentName;
        this.age = age;
        this.image = image;
        this.cca = cca;
        this.sc = sc;
        this.attendance = attendance;
        this.homework = homework;
        this.test = test;
        this.comment = comment;
    }

    /**
     * A method that returns the Student's Index Number.
     *
     * @return Student's Index Number.
     */
    public IndexNumber getIndexNumber() {
        return indexNumber;
    }

    /**
     * A method that returns the Student's Gender.
     *
     * @return Student's Gender.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * A method that returns the Student's Parent / NOK Name.
     *
     * @return Parent / NOK name.
     */
    public ParentName getParentName() {
        return parentName;
    }

    /**
     * A method that returns the Student's Age.
     *
     * @return Student's Age.
     */
    public Age getAge() {
        return age;
    }

    /**
     * A method that returns the Student's Image.
     *
     * @return Student's Image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * A method that returns the Student's CCA.
     *
     * @return Student's CCA.
     */
    public Cca getCca() {
        return cca;
    }

    /**
     * A method that returns the Student's class.
     *
     * @return Student's class.
     */
    public StudentClass getStudentClass() {
        return sc;
    }

    /**
     * A method that returns the Student's attendance.
     *
     * @return Student's attendance.
     */
    public Attendance getAttendance() {
        return attendance;
    }

    /**
     * A method that returns information about the homework the Student was given.
     *
     * @return Homework information.
     */
    public Homework getHomework() {
        return homework;
    }

    /**
     * A method that returns information about the test the Student took.
     *
     * @return Test information related to the Student.
     */
    public Test getTest() {
        return test;
    }

    /**
     * A method that returns the comment given to this Student.
     *
     * @return Comments given to this Student.
     */
    public Comment getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return otherStudent.getName().equals(getName())
                && otherStudent.getStudentClass().equals(getStudentClass())
                && otherStudent.getIndexNumber().equals(getIndexNumber())
                && otherStudent.getSex().equals(getSex())
                && otherStudent.getParentName().equals(getParentName())
                && otherStudent.getAge().equals(getAge())
                && otherStudent.getImage().equals(getImage())
                && otherStudent.getPhone().equals(getPhone())
                && otherStudent.getEmail().equals(getEmail())
                && otherStudent.getCca().equals(getCca())
                && otherStudent.getAddress().equals(getAddress())
                && otherStudent.getTags().equals(getTags());
    }
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Student Class: ")
                .append(getStudentClass())
                .append("; Index Number: ")
                .append(getIndexNumber())
                .append("; Sex: ")
                .append(getSex())
                .append("; Parent Name: ")
                .append(getParentName())
                .append("; Student Age: ")
                .append(getAge())
                .append("; Image Path: ")
                .append(getImage())
                .append("; Student Email: ")
                .append(getEmail())
                .append("; Student Phone: ")
                .append(getPhone())
                .append("; CCA: ")
                .append(getCca());


        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }
}
