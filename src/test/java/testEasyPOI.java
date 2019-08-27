import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.GrilFriend;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.baizhi.entrence;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = entrence.class)
public class testEasyPOI {
    @Test
    public void test() throws IOException {
        Student student1 = new Student("1", "一", 18, 60);
        Student student2 = new Student("2", "二", 19, 60);
        Student student3 = new Student("3", "三", 20, 60);
        Student student4 = new Student("3", "三", 20, 60);
        GrilFriend grilFriend = new GrilFriend("小花");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        Teacher teacher1 = new Teacher("张三", list, grilFriend);
        Teacher teacher2 = new Teacher("李四", list, grilFriend);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("标题", "表名", "表名"), Teacher.class, teacherList);

        workbook.write(new FileOutputStream(new File("D:/easy.xls")));
    }

    @Test
    public void testIn() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(2);
        importParams.setTitleRows(2);
        List<Teacher> list = ExcelImportUtil.importExcel(new FileInputStream(new File("D:/easy.xls")), Teacher.class, importParams);
        System.out.println(list);
    }
}
