package course;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseMainTest {

    private final course_main courseMain = new course_main();

    @Test
    void testFindCourseProgrammingOneMonth() {
        String result = courseMain.findCourse("Программирование", "1 месяц");
        assertEquals("Основы программирования", result);
    }

    @Test
    void testFindCourseProgrammingThreeMonths() {
        String result = courseMain.findCourse("Программирование", "3 месяца");
        assertEquals("Веб-разработка", result);
    }

    @Test
    void testFindCourseProgrammingSixMonths() {
        String result = courseMain.findCourse("Программирование", "6 месяцев");
        assertEquals("Мобильная разработка", result);
    }

    @Test
    void testFindCourseHealthOneMonth() {
        String result = courseMain.findCourse("Здоровье и питание", "1 месяц");
        assertEquals("Диетология", result);
    }

    @Test
    void testFindCourseHealthThreeMonths() {
        String result = courseMain.findCourse("Здоровье и питание", "3 месяца");
        assertEquals("Фитнес для начинающих", result);
    }

    @Test
    void testFindCourseHealthSixMonths() {
        String result = courseMain.findCourse("Здоровье и питание", "6 месяцев");
        assertEquals("Здоровый образ жизни", result);
    }

    @Test
    void testFindCourseEmbroideryOneMonth() {
        String result = courseMain.findCourse("Вышивание", "1 месяц");
        assertEquals("Базовое вышивание", result);
    }

    @Test
    void testFindCourseEmbroideryThreeMonths() {
        String result = courseMain.findCourse("Вышивание", "3 месяца");
        assertEquals("Креативное рукоделие", result);
    }

    @Test
    void testFindCourseEmbroiderySixMonths() {
        String result = courseMain.findCourse("Вышивание", "6 месяцев");
        assertEquals("Вышивка крестиком", result);
    }

    @Test
    void testFindCourseInvalidDuration() {
        String result = courseMain.findCourse("Программирование", "12 месяцев");
        assertEquals("Курс не найден", result);
    }

    @Test
    void testFindCourseInvalidDirection() {
        String result = courseMain.findCourse("Рисование", "1 месяц");
        assertEquals("Курс найден", result);
    }
}
