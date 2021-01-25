package com.poi.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 03 版本的 POI 操作读 Excel（案例）Demo
 *
 * @author jingLv
 * @date 2020/11/05
 */
public class ReadExcelFor03 {

    public static void main(String[] args) {
        // 定义文件路径
        String path = "/Users/apple/JavaProject/operation-excel/";

        // 1. 获取文件的流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path + "excel2003.xls");
            // 2. 创建工作簿，把获取的流传入
            Workbook workbook = new HSSFWorkbook(fileInputStream);
            // 3. 创建表
            Sheet sheet = workbook.getSheetAt(0);
            // 4. 创建行
            Row row1 = sheet.getRow(0);
            // 5. 创建单元格
            Cell cell1 = row1.getCell(0);
            // 6. 读取Excel内容
            System.out.println(cell1.getStringCellValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭流
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
