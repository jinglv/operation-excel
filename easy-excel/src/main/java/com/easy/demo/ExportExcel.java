package com.easy.demo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.easy.entity.Card;
import com.easy.entity.Order;
import com.easy.entity.User;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 导出excel
 *
 * @author jingLv
 * @date 2021/01/19
 */
public class ExportExcel {

    public static void main(String[] args) throws IOException {
        //获取数据
        List<User> users = getUsers();
        // 导出excel
        // 参数：exportParams 导出配置对象， 参数2：导出的类型， 参数3：导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        // 将excel写入指定位置
        FileOutputStream outputStream = new FileOutputStream("/Users/apple/JavaProject/operation-excel/ExportExcel.xls");
        workbook.write(outputStream);
        // 关闭流
        outputStream.close();
        workbook.close();
    }

    /**
     * 定义导出数据
     *
     * @return
     */
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("阿花number" + i);
            user.setAge(10 + i);
            user.setBir(new Date());
            if (i % 2 == 0) {
                user.setStatus("0");
                user.setHabits(Arrays.asList("打篮球", "看书", "看片"));
            } else {
                user.setStatus("1");
                user.setHabits(Arrays.asList("喝酒", "抽烟", "烫头"));
            }
            // Card赋值
            Card card = new Card();
            card.setIdCard("123456789");
            card.setAddress("北京朝阳区");
            user.setCard(card);
            // 订单赋值
            List<Order> orders = new ArrayList<>();
            orders.add(new Order("12", "超短裙"));
            orders.add(new Order("13", "连衣裙"));
            orders.add(new Order("14", "短裤"));
            user.setOrders(orders);
            // 图片复制绝对路径
            user.setPhoto("/Users/apple/Documents/关键字01.png");
            users.add(user);
        }
        return users;
    }
}
