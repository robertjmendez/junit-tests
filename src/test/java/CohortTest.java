import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class CohortTest {
    private Cohort cohort;
    private Student student1;
    private Student student2;

    @Before
    public void setUp(){
        cohort = new Cohort();
        student1 = new Student("John Doe", 1);
        student1.addGrade(80);
        student1.addGrade(90);
        student2 = new Student("Jane Doe", 2);
        student2.addGrade(85);
        student2.addGrade(95);
    }

    @Test
    public void testAddStudent() {
        cohort.addStudent(student1);
        assertTrue(cohort.getStudents().contains(student1));
    }

    @Test
    public void testGetStudents() {
        cohort.addStudent(student1);
        cohort.addStudent(student2);
        List<Student> students = cohort.getStudents();
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testGetAverage() {
        cohort.addStudent(student1);
        cohort.addStudent(student2);
        double expectedAverage = (student1.getGradeAverage() + student2.getGradeAverage()) / 2.0;
        assertEquals(expectedAverage, cohort.getCohortAverage(), 0.001);
    }
}

