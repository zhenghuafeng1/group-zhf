package zhf;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        //HashMap<String,String>map=new HashMap<>();
        //List<String> list=new ArrayList<>();
        //list.add("sss");
        //list.add("aa");
        //list.add("dd");
        //map.put("${text}$", list.toString());
        //copyAndReplaceByMap2("F:\\test1.js","F:\\test2.js",map);

        //ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        //map.put("1_1", "zheng");
        //map.put("2_2", "hua");
        //map.put("3_3", "feng");
        //map=replaceKeys(map);
        //System.out.println(map);

        //System.out.println(getMonthInYear(1,"month"));
        //System.out.println(getDateInMonth());

        //ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        //List<String> names=new ArrayList<>();
        //names.add("ddd");
        //names.add("aaa");
        //names.add("ccc");
        //map.put("test",names.toString());
        //System.out.println(map);
        //List<String> list=new ArrayList<>();
        //list.add("string1");
        //list.add("string2");
        //list.add("string3");
        //
        //list.forEach(e->{
        //    try{
        //        if(Objects.equals(e,"string2")){
        //            int i=1/0;
        //        }
        //        System.out.println(e);
        //    }catch (Exception ex){
        //        ex.printStackTrace();
        //    }
        //});

        //StringBuffer string =new StringBuffer();
        //string.append("aaabbbcccdddeeefff#num#");
        //String string2="sssssssssss";
        //string2=string2+string.toString().replaceAll("#num#","1");
        //System.out.println(string2);

        //System.out.println(Calendar.getInstance().get(Calendar.MONTH)+1);

        //String name="03f9dbe4-b4db-4af1-8bd7-ff9febf616bd-2022-06-22.png";
        //System.out.println(name.substring(0,name.indexOf(".png")));
        //System.out.println( LocalDate.now().toString());

        HashMap<String,String> map=new HashMap<>();

        LocalDate bgnDate=LocalDate.parse("2022-06-07");
        LocalDate endDate=LocalDate.parse("2022-06-08");
        List<LocalDate> dateList=getDayInMonth(bgnDate,endDate);
        dateList.forEach(date->{
            map.put(date.toString(),date.toString());
        });
        System.out.println(map);
    }

    public static List<LocalDate> getDayInMonth(LocalDate bgnDate,LocalDate endDate){
        List<LocalDate> dates = Stream.iterate(bgnDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(bgnDate, endDate))
                .collect(Collectors.toList());
        dates.remove(bgnDate);
        return dates;
    }

    public static List<LocalDate> getDayBetweenMonth(LocalDate bgnDate,LocalDate endDate){
        List<LocalDate> dates = Stream.iterate(bgnDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(bgnDate, endDate.plusDays(1)))
                .collect(Collectors.toList());
        return dates;
    }

    public static String copyAndReplaceByMap2(String inputPath, String outputPath, HashMap<String,String> hashMap) {
        String filePath = null;
        StringBuffer str = new StringBuffer();
        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicBoolean copyFlag = new AtomicBoolean(false);
        if (Objects.equals(inputPath, null) || Objects.equals(inputPath, "") || Objects.equals(outputPath, null) || Objects.equals(outputPath, "")) {
            return filePath;
        }
        try {
            //获取文件路径
            Path oldFile = Paths.get(inputPath);
            //读取文件内容
            List<String> inputlines = Files.readAllLines(oldFile);
            //存储文件内容
            List<String> outputLines = new ArrayList<>();
            StringBuffer copyStr=new StringBuffer();
            inputlines.forEach(l -> {

                if(l.contains("//multiBegin")){
                    flag.set(true);
                    copyStr.setLength(0);
                }else if(l.contains("//multiEnd")&&flag.get()){
                    flag.set(false);
                    copyFlag.set(true);
                }

                if(flag.get()){
                    copyStr.append("\r\n"+l);
                }
                if(copyFlag.get()){
                    l=l+copyStr.toString().replaceAll("}\\$","##");
                }

                outputLines.add(l);
                copyFlag.set(false);
            });
            //写内容到文件
            Files.write(Paths.get(new File(outputPath).getAbsolutePath()), outputLines);
        } catch (InvalidPathException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static List<LocalDate> getDateInMonth(){
        LocalDate startDate =  LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = startDate.minusMonths(1);
        List<LocalDate> dates = Stream.iterate(endDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(endDate, startDate))
                .collect(Collectors.toList());
        return dates;
    }

    public static List getMonthInYear(int nums,String dayType){
        List list = new ArrayList();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = null;
        switch (dayType){
            case "year":
                endDate=startDate.minusYears(nums);
                break;
            case "month":
                endDate=startDate.minusMonths(nums);
                break;
            case "day":
                endDate=startDate.minusDays(nums);
                break;
        }
        List<LocalDate> dates = Stream.iterate(endDate, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(endDate, startDate))
                .collect(Collectors.toList());
        dates.forEach(localDate -> {
            String format = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            list.add(format);
        });
        return list;
    }

    public static List<LocalDate> getMonthInYear2(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusYears(1);
        List<LocalDate> dates = Stream.iterate(endDate, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(endDate, startDate))
                .collect(Collectors.toList());
        return dates;
    }

    public static List<LocalDate>  getBetweenDate(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusMonths(1);
        List<LocalDate> dates = Stream.iterate(endDate, date -> date.minusDays(1))
                .limit(ChronoUnit.DAYS.between(endDate, startDate))
                .collect(Collectors.toList());
        return dates;
    }

    public static ConcurrentHashMap<String,String> replaceKeys(ConcurrentHashMap<String, String> map){
        Iterator<String> iterator=map.keySet().iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            map.put("${"+key+"}$",map.remove(key));
        }
        return map;
    }

    public static String copyAndReplaceByMap(String inputPath, String outputPath, HashMap<String,String> hashMap){
        String filePath=null;
        StringBuffer str=new StringBuffer();
        AtomicBoolean flag= new AtomicBoolean(false);
        if(Objects.equals(inputPath,null)||Objects.equals(inputPath,"")||Objects.equals(outputPath,null)||Objects.equals(outputPath,"")){
            return filePath;
        }
        try{
            //获取文件路径
            Path oldFile = Paths.get(inputPath);
            //读取文件内容
            List<String> inputlines = Files.readAllLines(oldFile);
            //存储文件内容
            List<String> outputLines = new ArrayList<>();

            inputlines.forEach(l->{
                //是否执行循环复制
                if(l.contains("//multiBegin")){
                    flag.set(true);
                    l=l+"\r\n";
                }else if(l.contains("//multiEnd")){
                    flag.set(false);
                }else if(l.contains("//multiEnable")){
                    l=l.replaceFirst("//"," ");
                }

                //获取需要循环复制的内容
                if(flag.get()){
                    str.append(l);
                }

                //循环增加内容
                int spNum=3;
                if(spNum>1&&str.length()>0&&!flag.get()){
                    for(int i=spNum;i>1;i--){
                        l=l+"\r\n"+str;
                    }
                    str.setLength(0);
                }

                l=replaceContext(l,hashMap,flag.get());
                outputLines.add(l);
            });
            //写内容到文件
            filePath=Files.write(Paths.get(new File(outputPath).getAbsolutePath()),outputLines).toString();
        }catch (InvalidPathException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return filePath;
    }

    public static String replaceContext(String str,HashMap<String, String> hashMap,boolean flag){
        if(Objects.equals(str,null)||Objects.equals(str,"")){
            return str;
        }
        for(Map.Entry<String,String> entry:hashMap.entrySet()){
            //循环复制
            //替换文件内容
            if(str.contains(entry.getKey())&&!flag) {
                str = str.replace(entry.getKey(),entry.getValue());
            }
        }
        return str;
    }
}
