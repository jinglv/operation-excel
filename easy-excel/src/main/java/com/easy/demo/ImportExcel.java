package com.easy.demo;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.easy.entity.Student;

import java.io.File;
import java.util.List;

/**
 * @author jingLv
 * @date 2021/01/25
 */
public class ImportExcel {
    public static void main(String[] args) {
        //定义导入参数
        ImportParams importParams = new ImportParams();
        // 导入时校验数据模板,是不是正确的Excel
        importParams.setImportFields(new String[]{"生日"});
        //是否保存上传的excel
        importParams.setNeedSave(false);
        importParams.setSaveUrl("/Users/apple/JavaProject/operation-excel/easy-excel/image");
        //导出数据 餐数1:当如excel文件  参数2:导入对象的类型 参数3:导入参数配置
        List<Student> students = ExcelImportUtil.importExcel(new File("/Users/apple/JavaProject/operation-excel/ExportExcel.xls"), Student.class, importParams);
        students.forEach(System.out::println);
    }
}
