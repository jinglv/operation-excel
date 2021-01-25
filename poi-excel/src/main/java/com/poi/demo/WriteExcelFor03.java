package com.poi.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 03 版本的 POI 操作写 Excel（案例）Demo
 *
 * @author jingLv
 * @date 2020/11/05
 */
public class WriteExcelFor03 {

    public static void main(String[] args) {
        // 定义输出路径
        String path = "/Users/apple/JavaProject/operation-excel/";

        // 1.创建工作簿
        Workbook workbook = new HSSFWorkbook();
        // 2.创建工作表
        Sheet sheet = workbook.createSheet("excel write test");
        // 3.创建工作行
        // 参数0 就代表Excel中的第一行
        Row row1 = sheet.createRow(0);
        // 4.创建工作单元格
        // 参数0 就代表Excel中的第一个单元格
        Cell cell1 = row1.createCell(0);
        // 填充Excel中的第一行的第一个单元格(0,0)
        cell1.setCellValue("name:Jack");

        // 填充Excel中的第一行的第二个单元格(0,1)
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("age:20");

        // 创建第二行 参数1 就代表Excel中的第二行
        Row row2 = sheet.createRow(1);
        // 第二行的第一个单元格，参数0 就代表Excel中的第一个单元格
        Cell cell21 = row2.createCell(0);
        // 填充Excel中的第一行的第一个单元格(0,0)
        cell21.setCellValue("name:May");

        // 填充Excel中的第一行的第二个单元格(0,1)
        Cell cell22 = row2.createCell(1);
        cell22.setCellValue("age:16");

        //上面已经把所需要的数据已经构建成功，这时候需要生成一张 Excel 数据表。其实生成表的话本质上是 IO 操作，IO 操作就需要流，所以说我们要构建一个流。输出到那个位置上
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path + "excel2003.xls");
            try {
                ((HSSFWorkbook) workbook).write(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("-----------POI 写入 Excel 成功");
    }
}
