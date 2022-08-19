package zhf.abstractFactoryPattern;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) throws ParseException {
        //AbstractFactory factory=FactoryBuild.getFactory("shape");
        //Shape shape1=factory.getsShape("square");
        //shape1.draw();
        //
        //Shape shape2=factory.getsShape("circle");
        //shape2.draw();
        //
        //AbstractFactory factory2=FactoryBuild.getFactory("color");
        //Color color1=factory2.getColor("red");
        //color1.fill();
        //
        //Color color2=factory2.getColor("blue");
        //color2.fill();

        //System.out.println(getLast12Months(3));

        //long currentTime =System.currentTimeMillis();
        //
        //long createTime = new SimpleDateFormat("yyyyMMddHHmmss").parse("20220704144900").getTime();
        //
        //long diff=(currentTime-createTime)/1000/60;
        //
        //System.out.println("当前系统时间为："+currentTime+"下单时间为："+createTime+"两个时间差为："+diff);
        //System.out.println(getMonthInYear());
        BigDecimal maxTemperature=new BigDecimal(90);
        BigDecimal HUMIDITY_MAX=new BigDecimal(60);

    }

    private static List<String> getMonthBetween() throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
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
        return result;
    }

    public static List<String> getMonthBetweenDate(Date startDate,Date endDate){
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化，调整为自己需要的格式
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
//    给calendar设置开始时间
        min.setTime(startDate);
//    set方法设置年月日 年为开始时间的年份 后面同理
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
//    给calendar设置结束时间
        max.setTime(endDate);
//    set方法设置年月日 年为结束时间的年份 后面同理，最后面的1和2不要改
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
//    创建一个临时的变量，代表当前的时间
        Calendar curr = min;
//    如果当前的时间在结束时间之前，循环知道超过结束时间就结束，返回结果集合
        while (curr.before(max)) {
//        将这个当前的时间格式化之后保存到result集合
            result.add(sdf.format(curr.getTime()));
//        将当前的时间加上1个月
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static List getMonthInYear(){
        List list = new ArrayList();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusYears(1);
        List<LocalDate> dates = Stream.iterate(endDate, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(endDate, startDate))
                .collect(Collectors.toList());
        dates.forEach(localDate -> {
            String format = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            list.add(format);
        });
        return list;
    }

    public static String getLast12Months(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }

    public static String getDatePoor(String end, String now) {

        try {
            //Date currentTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(end);
            //Date createTime=new SimpleDateFormat("yyyyMMddHHmmss").parse(now);

            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            long currentTime =System.currentTimeMillis();

            long createTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(end).getTime();

            long diff=(currentTime-createTime)/1000/60;

            System.out.println("当前系统时间为："+currentTime+"下单时间为："+createTime+"两个时间差为："+diff);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
