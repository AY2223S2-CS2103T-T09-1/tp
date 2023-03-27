# PowerConnect User Guide

Greetings! Welcome to PowerConnect! <br>

Looking for a simple and all in one solution for your teaching needs? Look no further. <br>

PowerConnect is a fully customized platform for tuition teachers and school teachers with the primary focus on 
tuition teachers now as we are still working to scale our features. School teachers, do still give us a try. While our 
features are limited at this stage, we are working hard to scale them to better compete with other Learning Managment
System (LMS) tools currently in the market. <br>

We aim to make PowerConnect as simple as possible for you to use with a focus on command line interface where you don't
have to navigate complex user menus to access the features you need, especially if you can type fast. <br>

Without further ado, let's get started!


##### Table of Contents
1. [Quick Start](#quick-start)
2. [Features](#features)
    1. [Legend](#legend)
    2. [Student Features](#student)
         1. [Add student: `add`](#addstudent)
         2. [Add students' grade: `grade`](#gradestudent)
         3. [Deletes students' grade: `gradedelete`](#gradedelete)
         4. [Add comments to students: `comment`](#commentstudent)
         5. [Listing all students in a particular class: `list`](#liststudent)
         6. [Editing a student's particulars: `edit`](#editstudent)
         7. [Searching students: `find`](#findstudent)
         8. [Deleting a student: `delete`](#deletestudent)
    3. [Parent Features](#parent)
        1. [Add Parent/Next-of-Kin: `add`](#addparent)
        2. [Listing all Parents/Next-of-Kins: `list`](#listparent)
        3. [Editing a Parent/Next-of-Kin particulars: `edit`](#editparent)
        4. [Deleting a Parent/Next-of-Kin: `delete`](#deleteparent)
    4. [General Features](#general)
       1. [Viewing help: `help`](#help)
       2. [Exiting program: `exit`](#exit)
       3. [Additional Features](#addfeatures)
3. [Saving the data](#savingdata)
4. [Editting the data file](#editdatafile)
5. [Images](#images)
6. [FAQ](#faq)
7. [Command Summary](#summary)
   1. [Command Summary for Student](#summarystudent)
   2. [Command Summary for Parent](#summaryparent)
<a name="quickstart"/>
--------------------------------------------------------------------------------------------------------------------

## Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `PowerConnect.jar` from [here](https://github.com/AY2223S2-CS2103T-T09-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for PowerConnect.

4. In the same folder, create a new folder named “image” and store all images to be used for the program in this folder. eg student image and parent image. For the student image, it should be named <STUDENT_NAME><CLASS><INDEX NUMBER>.png. For the parent image, it should be named <PARENT_NAME>.

5. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar PowerConnect.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

6. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list student` : Lists all students.

    * `student 1A add n/Tan Ah Cow in/13 s/M pn/Tan Ah Niu pnP/91234567 rls/Father` : Adds a student in class 1A named `Tan Ah Cow` to PowerConnect.

    * `student 1A delete in/13` : Deletes the student with index number 13 in class 1A

    * `student 1A grade in/13 test/CA1 score/75 deadline/15/05/2023 weightage/20`: Adds a test named CA1, score of 75, deadline of 15/05/2023, weightage 20% to student index number 13 in class 1A
    * `student 1A gradedelete in/13 test/CA1`: Deletes a test named CA1 for student in class 1A with index 13
    * `clear` : Deletes all contacts.
    * `exit` : Exits the app.


7. Refer to the [Features](#features) below for details of each command.

   <a name="features"/>
--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

This section aims to provide a brief overview of the features available in PowerConnect and the appropriate CLI command to call them. <br>

### Legend
* Command lines supplied by the user are NOT case sensitive. User needs to be ensure they have typed in the command in the correct case.
  E.g. in the list feature, user can call it via this method:
  `student 5A list`



* Words in `UPPER_CASE` are the parameters to be supplied by the user.
  e.g. in `…add <NAME>...`, `NAME` is a parameter which can be used as `…add John…`.


* Items in `<>` brackets are the values that the user should fill in and is compulsory.
  e.g. in `…add <NAME>…` , `NAME` is a parameter that needs to be included, can be used as `…add John…`.


* All items in the square brackets are OPTIONAL.

  e.g. in `…add…[..c/<CCA>.. ]...` , `CCA` is an optional parameter that need not be given by the user and can be skipped, can be used as `…add…`  or `…add…c/Mathematics Club nok/…` .



* Student Particulars:
  * Compulsory:
    - Name n/<**NAME**>
      -  Student's name
    - Class <**CLASS**>
      - Student's class
    - Index Number in/<**INDEX_NUMBER**>
      - Number value of student's index number
    - Parents/ Next-of-kin pn/<**PARENT/NOK**>
      - Parent's name
    - Parents/ Next-of-kin pnP/<**PARENT/NOK_PHONE_NUMBER**>
      - Parent's phone number
      - Should not include country code
    - Parents/ Next-of-kin rls/<**RELATIONSHIP**>
      - Relationship between student and parent
  * Optional:
    - Age ageS/[**AGE**]
        - Numerical value of student's age
    - Sex s/[**SEX**]
      - Student's gender
      - Should be either M or F
    - CCA c/[**CCA**]
      - Student's CCA
    - Comments com/[**COMMENTS**]
      - Student's comments
    - Image imgS/[**IMAGE**]
      - Student's image
      - Should be in .png format
      - Should be named <STUDENT_NAME><CLASS><INDEX NUMBER>.png
      - Should be stored in the image folder
    - Residential address a/[**RESIDENTIAL_ADDRESS**]
      - Student's residential address
    - Email e/[**EMAIL**]
      - Student's email address
    - Phone number pnS/[**PHONE_NUMBER**]
      - Student's phone number
      - Should not include country code

  *  Academics:
      - Attendance att/<**ATTENDANCE**>
          - Can be T/F/`Date`
      - Test test/<**TEST_NAME**>
        - String value of test name
      - Homework hw/<**HOMEWORK**>
          - String value of homework name
      - Grade gde/<**GRADE**>
          - String value of grade results
      - Tags t/<**TAGS**>
          - String value of tags

* Parent / Guardians Particular
  * Compulsory:
    - Name n/<**NAME**>
      -  Parent's name
    - Phone number pnP/<**PHONE_NUMBER**>
      - Parent's phone number
      - Should not include country code
  * Optional:
    - Age ageP/[**AGE**]
      - Numerical value of parent's/NOK age
    - Image imgP/[**IMAGE**]
      - Parent's image
      - Should be in .png format
      - Should be named <PARENT_NAME>.png
      - Should be stored in the image folder
    - Email e/[**EMAIL**]
      - Parent's email address
    - Residential address a/[**RESIDENTIAL_ADDRESS**]
      - Parent's residential address

## General Command for Student Related features

* For all following features that are related to `students`, start first by typing `student <CLASS>` before adding the respective command for the feature.<br>
* Compulsory field are inside <> while optional fields are in []
  <a name="addstudent"/>

### Adding a Student: `add`

Adds a student to the database

Format: `add n/<NAME> in/<INDEX_NUMBER> pn/<NOK_NAME> pnP/<NOK_CONTACT_NUMBER> rls<NOK_RELATIONSHIP_TO_STUDENT> [s/<SEX> a/<REISDENTIAL_ADDRESS> ageS/<AGE> imgS/<ABSOLUTE_PATH_TO_IMAGE> eS/<EMAIL_ADDRESS> pnS/<PHONE_NUMBER> cca/<CCA>]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person with the same name and same class but different index number can exist.
</div>

Examples:
* `student 1A add n/TanAhCow in/03 pn/TanAhNiu pnP/91234567 rls/Father` <br>

  *Above is a situation where some of the student's information is not given!
* `student 1A add n/Tan Ah Cow in/13 s/M pn/Tan Ah Niu pnP/91234567 rls/Father a/Blk 456 Ang Mo Kio Avenue 6 #11-800 S(560456) ageS/14 imgS/C:// eS/tanahcow@gmail.com pnS/91234567 cca/Captain Ball att/T `

Imagesource will be displayed in decreasing priority: <br>
* Absolute or relative file path
* images/<STUDENT_NAME><STUDENT_CLASS>.png
* Default Image (?) <br>

Note: <br>
1. User cannot create two students of the same index number and same class
2. Upon creation of a student, a new parent is also created if the parent does not exist based on the particulars given for the parent. Otherwise, the student will get binded to the matching parent.

<a name = "attendance" />

### Marking attendance for student: `attendance`

Marks the student as being present or allow you to define that the student was present
Ensure that if you mark the same date for the same student as being present, it will prompt that you have indeed added the same date (for verification)

Format : `attendance in/<INDEX_NUMBER> att/<DATE_PRESENT>`

Examples: 
* `student 3A attendance in/25 att/T`
* `student 3A attendance in/25 att/25/02/2023

Date is in DD/MM/YYYY format <br>
This date can be set to:
* T (Indicates that the student was present today)
* F (Default when adding student)
* Specific date (Used when you want to update the attendance of the student in the past)
<a name="gradestudent"/>

### Adding a grade for student : `grade`

Adds a test OR homework grade for the student corresponding to the `INDEX_NUMBER` in the `CLASS`

Duplicate test/homework  is checked through having the same name

Format: `grade in/<INDEX_NUMBER> [test/<TEST_NAME> OR hw/<HOMEWORK_NAME>] [score/<score> deadline/<DEADLINE(DD/MM/YYYY)> weightage/<WEIGHTAGE>] [hwdone/<HOMEWORK_DONE(true/false)>]`

Examples:
* `student 3A grade 25 test/Mid-Terms`
* `student 1A grade in/13 test/CA1 score/75 weightage/10`
* `student 1A grade in/13 hww/homework1 score/75 deadline/25/04/2023 weightage/10 hwdone/true`<br><br>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
1. Test or Homework name is compulsory for the command to work and must not be duplicate of current tests/homework in student.
2. hwdone is compulsory for homework.
3. Score is out of 100
4. Weightage is out of 100%
</div>

<a name = "gradedelete" />

### Deleting a grade for student : `gradedelete`

Deletes a test OR homework grade for the student corresponding to the `INDEX_NUMBER` in the `CLASS`

Duplicate test/homework  is checked through having the same name

Format: `gradedelete in/<INDEX_NUMBER> [test/<TEST_NAME> OR hw/<HOMEWORK_NAME>]`

Examples:
* `student 3A gradedelete 25 test/Mid-Terms`
* `student 1A gradedelete in/13 test/CA1`

<a name = 'commentstudent'/>

### Adding comments for student : `comment`

Adds a comment for the student corresponding to the `INDEX_NUMBER` in the `CLASS`

Format: `comment in/<INDEX_NUMBER> com/<COMMENT>`

Examples:

* `student 3A comment in/25 com/Quiet person, needs to interact more with classmates`

Note: <br>
If an existing comment is already available for the selected student, the new comment will OVERRIDE the old comment! Hence, users should check on existing comments before adding a new comment!
<a name = "liststudent"/> <br><br>

### Listing all students in the selected class: `list`

Shows a list of all students in the selected class in the database

Format: `list`

Examples:
* `student 1A list`
* `student 1B list`

**Expected Outcome:**
![list message](images/list.png)
  
<a name = "editstudent" /> <br><br>

### Edit Student:  `edit`

Edits personal details of students for the student corresponding to the `INDEX_NUMBER` in the `CLASS` based on the particulars given by the user.

Format: `edit in/<INDEX_NUMBER (of student)> [nn/<NEWNAME> nin/<NEWINDEXNUMBER> nc/<NEWCLASS> s/<SEX> ageS/<STUDENT AGE>
imgS/<IMAGE> cca/<CCA> att/<ATTENDANCE> com/<COMMENTS> pnS/<STUDENT PHONE NUMBER> eS/<STUDENT EMAIL> a/<ADDRESS>
pn/<PARENT NAME> pnP/<PARENT PHONE NUMBER> rls/<RELATIONSHIP>]`

Examples:
* `student 1A edit in/03 cca/basketball`
* `student 1A edit in/03 cca/badminton ageS/23`

**Expected Outcome:**
* Edited student: TanAhCow; Student Class: 1A; Index Number: 03; Sex: M;
* Student Age: Insert student age here!; Image Path: Insert student image here!;
* Student Email: Insert student email here!; Student Phone: Insert student phone number here!; CCA: basketball
* Edited student: TanAhCow; Student Class: 1B; Index Number: 03; Sex: M;
* Student Age: 23; Image Path: Insert student image here!; Student Email: Insert student email here!;
* Student Phone: Insert student phone number here!; CCA: badminton

<a name = "findstudent"/>

### Locating persons by name:  `find`

Finds and generates all students with matching student name and class

Format: `find <INDEX_NUMBER>  `

Examples:
* `student 3B find 26`
* `student 3B find 27`

**Expected Outcome:**
* Student found: Russel Ong class:3B cca: swimming grade: [sci:A, maths:B] id:26 age:14 email:ro@outlook.com ph:85349633 attendance: 2023-01-01 [y] hw: ip [x] notes:extroverted nok: David Ong
* Student found: Joseph Tan class:3B cca: basketball grade: [sci:A, maths:C] id:27 age:14 email:jo@outlook.com ph:92103134 attendance: 2023-01-01 [x] hw: ip [x] notes:shy  nok: David Tan <br><br>

<a name = "deletestudent"/>

### Deleting student particulars: `delete`

Deleting student/ student information from the database

Format: `delete in/<INDEX_NUMBER>`

Examples:
* `student 1A delete in/2`

**Expected Outcome:**

Deleted Student: TanAhCow; Student Class: 1A; Index Number: 14; Sex: M; Student Age: Insert student age here!; Image Path: Insert student image here!; Student Email: Insert student email here!; Student Phone: Insert student phone number here!; CCA: Insert student CCA here!

Deleted Student: TanAhCow; Student Class: 1B; Index Number: 23; Sex: M; Student Age: Insert student age here!; Image Path: Insert student image here!; Student Email: Insert student email here!; Student Phone: Insert student phone number here!; CCA: Insert student CCA here!


<a name = "parent" />

## General Command for parent related features

* For all following features that are related to `parent`, start first by typing `parent`  before adding the respective command for the feature.

* Note that it is possible to have multiple students with the same parent and parents are identified via their phone number and *HENCE* `student class` is not used for identification.


<a name="addparent"/>

### Adding a parent: `add`

Adds a parent to the database

Format: `add n/<PARENT_NAME/NOK_NAME> pnP/<PHONE_NUMBER> [ageP/<AGE> imgP/<ABSOLUTE_PATH_TO_IMAGE> e/<EMAIL_ADDRESS> a/<RESIDENTIAL_ADDRESS>] `

Examples:
* `parent add n/TanAhNiu pnP/91234567`
* `parent add n/Tan Ah Niu pnP/91234567 ageP/30 imgP/C:// e/tanahcow@gmail.com a/Blk 456 Ang Mo Kio Avenue 6 #11-800 S(560456)` <br><br>


<a name = "listparent" />

### Listing all parents : `list`

Shows a list of all parent in the database

Format: `list`

Examples:
* `parent list` <br>
  Sample output: <parent name> <parent phone number> <parent email>
* `parent list` <br><br>

<a name = "editparent" />

### Edit Parent:  `edit`

Edits personal details of students

Format: `edit n/<PARENT_NAME/NOK_NAME> pnP/<PHONE_NUMBER> [nn/<NEW_NAME> npnP/<NEW_PHONE_NUMBER> ageP/<NEW_AGE> imgP/<NEW_IMAGE> e/<NEW_EMAIL_ADDRESS> a/<NEW_RESIDENTIAL_ADDRESS>]   `

Examples:
* `parent edit n/Tan Ah Niu pnP/91234567 npnP/65656565`
* `parent edit n/Tan Ah Niu pnP/91234567 nn/Tan Ah Seng npnP/91274444 ageP/31 imgP/C:// e/tanahcow@gmail.com a/Blk 245 Ang Mo Kio Avenue 1 #11-800 S(560245)`

**Expected Outcome:**
* `Edited Parent: Tan Ah Niu; Phone: 65656565`
* `Edited Parent: Tan Ah Niu; Parent Age: 31; Address: Blk 245 Ang Mo Kio Avenue 1 #11-800 S(560245); Image Path: C://; Parent Email: tanahcow@gmail.com; Parent Phone: 91234567; Parent/NOK of: Tan Ah Cow; Student Class: ...` <br><br>

<a name = "deleteparent" />

### Deleting parent particulars: `delete`

Deleting parent/ specified parent information from the database

Format: `delete n/<PARENT_NAME/NOK_NAME> pnP/<PHONE_NUMBER> [ageP/<AGE> imgP/<ABSOLUTE_PATH_TO_IMAGE> e/<EMAIL_ADDRESS> a/<RESIDENTIAL_ADDRESS>] `

Examples:
* `parent delete n/TanAhNiu pnP/91234567` <br>
  Deletes TanAhNiu from powerConnect
* `parent 1A 03 delete TanAhCow Mother` <br>
  Deletes TanAhCow’s relationship of Mother with <Index number of student>

Throws:
* WrongParticularException
  - The description field does not exist
  - Description is invalid (eg. age is not a number..)

User should follow the same format <br>
`Warning:` If no descriptions are given, the whole parent will be removed from the database <br><br>

<a name = "help"/>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help` <br><br>

<a name = "exit"/>

### Exiting the program : `exit`

Exits the program.

Format: `exit` <br><br>

### Saving the data

PowerConnect data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually. <br><br>

### Editing the data file

PowerConnect data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. <br><br>
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

<a name = "addfeatures"/>

### Additional Features

### Images 

In the same folder as your PowerConnect.jar file, create a new file called `images` if it does not exist. <br>

Place all your student images in this format: `images/student/<STUDENT_NAME><STUDENT_CLASS>.png` <br>

Place all your parent images in this format: `images/parent/<PARENT_NAME>.png` <br>

--------------------------------------------------------------------------------------------------------------------
<a name = "faq" /></a>

## FAQ

Feel free to ask any questions [here](https://docs.google.com/forms/d/e/1FAIpQLScpZ7Gg52KQ8LRsaq_6rXoPG4nYCClzmXKeRK6lyoYP1ZQV0w/viewform).

--------------------------------------------------------------------------------------------------------------------

**Q**: Where is the information stored?<br>
**A**: Data is stored locally in the ./data folder. The student and class information is stored in the file pcclass.json whereas the parents information is stored in parents.json

**Q**: What is CLI?<br>
**A**: Command Line Interface (CLI) is a text based user interface used to run the
program. Essentially you do not need a mouse to run this program at all!

**Q**: Do I need to pay for this product?<br>
**A**: No! We made a commitment to keep this program free for all users. Feel free to run and use our program, but remember to like, share and comment down below any feedback.

**Q**: Why is my command not working?<br>
**A**: PowerConnect is particular with the prefixes (/) and they need to be in the exact format as specified in the user guide. Don’t worry, with practice, it would be second nature to you.

--------------------------------------------------------------------------------------------------------------------
<a name = "summary" /> </a>


## Command Summary Student `student <CLASS>`

| Action      | Format, Examples                                                                                                                                                                                                    |
|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**     | `add <NAME> <INDEX_NUMBER> <SEX> <PARENT_NAME/NOK_NAME> [age/<AGE> img/<ABSOLUTE_PATH_TO_IMAGE> em/<EMAIL_ADDRESS> ph/<PHONE_NUMBER> cca/<CCA>]`                                                                    |
| **Grade**   | `grade <INDEX_NUMBER> test/<TEST_NAME> gde/<GRADE>`                                                                                                                                                                 |
| **Comment** | `comment <INDEX_NUMBER> note/<COMMENT>`                                                                                                                                                                             |
| **List**    | `list`                                                                                                                                                                                                              |
| **Edit**    | `edit <INDEX_NUMBER (of student)> [name/<NAME> class/<CLASS> cca/<CCA> id/<INDEX_NUMBER> img/<IMAGE> age/<AGE> em/<EMAIL> ph/<PHONE_NUM> test/<TEST> att/<ATTENDANCE> hw/<ASSIGNMENTS> note/<COMMENTS> nok/<NAME>]` |
| **Find**    | `find <INDEX_NUMBER> `                                                                                                                                                                                              |
| **Delete**  | `delete <INDEX_NUMBER> <GENDER> [a/<AGE> p/<ABSOLUTE_PATH_TO_IMAGE> c/<CCA> nok/<PARENT_NAME/NOK_NAME>]`                                                                                                            |

## Command Summary Parent `parent <CLASS>`

| Action     | Format, Examples                                                                                                                                  |
|------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**    | `add <INDEX_NUMBER (of student)> <(parent) NAME> <RELATIONSHIP> [a/<AGE> p/<ABSOLUTE_PATH_TO_IMAGE> ph/<PHONE_NUMBER> e/<EMAIL>] `                |
| **List**   | `list`                                                                                                                                            |
| **Delete** | `delete <INDEX_NUMBER (of student)> <(parent) NAME> <RELATIONSHIP WITH STUDENT> [a/<AGE> p/<ABSOLUTE_PATH_TO_IMAGE> ph/<PHONE_NUMBER> e/<EMAIL>]` |
