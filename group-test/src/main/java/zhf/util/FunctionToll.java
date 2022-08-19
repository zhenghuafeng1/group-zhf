package zhf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Autor zhenghf
 * @Date 2022/7/14
 * @ClassName 工具包
 * @Customer
 **/
public class FunctionToll {

    /**
     * 获取前13个月份
     * @return
     * @throws ParseException
     */
    private static List<String> getMonthBetween(){
        ArrayList<String> result = new ArrayList<String>();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            //获取去年同期
            min.setTime(sdf.parse(String.valueOf(LocalDate.now().minusMonths(13))));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            //获取上个月份
            max.setTime(sdf.parse(String.valueOf(LocalDate.now().minusMonths(1))));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取指定日期之间所有日期（包含指定日期）
     * @param startTime 开始日期
     * @param endTime 截止日期
     * @return
     */
    public static List<String> getBetweenDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }



}
