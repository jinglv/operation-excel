package com.poi.demo;

import cn.hutool.core.date.DateTime;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author jingLv
 * @date 2020/11/06
 */
public class ExcelCellType {

    public static void main(String[] args) {
        // 定义文件路径
        String path = "/Users/apple/JavaProject/operation-excel/";

        // 获取文件流
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path + "type.xlsx");
            // 1. 创建工作簿，将文件流导入
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            // 2. 获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            // Excel中第一行都是标题，先读取标题
            Row rowTitle = sheet.getRow(0);
            // 获取Excel的标题
            if (null != rowTitle) {
                // 如果标题不为空的话
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNumber = 0; cellNumber < cellCount; cellNumber++) {
                    Cell cell = rowTitle.getCell(cellNumber);
                    if (null != cell) {
                        CellType cellType = cell.getCellType();
                        String cellValue = cell.getStringCellValue();
                        System.out.print(cellValue + "||");
                    }
                }
                // 空行
                System.out.println();
            }
            // 获取表中的内容
            int rowCount = sheet.getPhysicalNumberOfRows();
            // 下标从1开始，排除行标题
            for (int rowNumber = 1; rowNumber < rowCount; rowNumber++) {
                Row rowData = sheet.getRow(rowNumber);
                if (null != rowData) {
                    // 读取列
                    int cellCount = Objects.requireNonNull(rowTitle).getPhysicalNumberOfCells();
                    for (int cellNumber = 0; cellNumber < cellCount; cellNumber++) {
                        Cell cell = rowData.getCell(cellNumber);
                        if (null != cell) {
                            CellType cellType = cell.getCellType();
                            String cellValue = "";
                            switch (cellType) {
                                // 字符串
                                case STRING:
                                    cellValue = cell.getStringCellValue();
                                    break;
                                // 布尔
                                case BOOLEAN:
                                    cellValue = String.valueOf(cell.getStringCellValue());
                                    break;
                                // 数字（日期、普通数字）
                                case NUMERIC:
                                    // 日期
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        System.out.print("【日期】");
                                        Date date = cell.getDateCellValue();
                                        cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                    } else {
                                        // 不是日期格式，防止数字过长！
                                        System.out.print("【转换为字符串输出】");
                                        cell.setCellType(CellType.STRING);
                                        cellValue = cell.toString();
                                    }
                                    break;
                                // 空
                                case BLANK:
                                    System.out.print("【BLANK】");
                                    break;
                                case ERROR:
                                    System.out.print("【数据类型错误】");
                                    break;
                            }
                            System.out.println(cellValue);
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
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
