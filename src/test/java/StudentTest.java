import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp(){
        student = new Student("John Doe", 1);
    }

    @Test
    public void testStudentConstructorSetsNameAndId() {
        assertEquals("John Doe", student.getName());
        assertEquals(1, student.getId());
    }

    @Test
    public void testStudentStartsWithNoGrades() {
        assertEquals(new ArrayList<Integer>(), student.getGrades());
    }

    @Test
    public void testAddGradeChangesGrades() {
        student.addGrade(90);
        ArrayList<Integer> expectedGrades = new ArrayList<>();
        expectedGrades.add(90);
        assertEquals(expectedGrades, student.getGrades());
    }

    @Test
    public void testGetGradeAverageCalculatesCorrectAverage() {
        student.addGrade(100);
        student.addGrade(75);
        assertEquals(87.5, student.getGradeAverage(), 0.001);
    }
}
