package com.SoulMen.utils;


import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Excel工具类
 * Created by scumbag on 2020/10/9.
 */
public class PoiUtil {

    /**
     * 将一个map组成的list转成实体类bean组成的list
     * @param file 数据路径MultipartFile
     * @param keyList 每一个位置对应的字段
     * @param clazz 需要将这些map转成哪个实体类对象
     * @return
     */
    public static <T> List<T> readExcel(MultipartFile file,String[] keyList,Class<T> clazz) throws IOException {
            List<String[]>  data=readExcel(file.getInputStream(),file.getOriginalFilename(),1,0);
        System.out.println(data.get(0));
        List<Map<String,Object>> data2=new ArrayList<>();
        for (int j=0;j<data.size();j++){
            Map<String,Object> data3=new HashMap<>();
            String[] a=data.get(j);
            for (int i = 0;i<keyList.length;i++){
                data3.put(keyList[i],a[i]);
            }
            data2.add(data3);
        }
        Field[] field = clazz.getDeclaredFields();
        List<T> list=new ArrayList<T>();
        String type="";
        for(Map map:data2){
            try {
                T obj=clazz.newInstance();//创建bean的实例对象
                for(Object o:map.keySet()){//遍历map的key
                            for(Method m:clazz.getMethods()){//遍历bean的类中的方法，找到set方法进行赋值x
                            if(m.getName().toLowerCase().equals("set"+o.toString().toLowerCase())){
                            for(Field a:field){
                                if(o.equals(a.getName())){
                                    type=a.getType().toString();
                                }
                            }
                            if (type.equals("class java.lang.String")) {
                                String i= (String) map.get(o);
                                m.invoke(obj, i);
                            }
                            if (type.equals("class java.lang.Integer")) {
                                Integer i=Integer.valueOf((String) map.get(o)).intValue();
                                m.invoke(obj, i);
                            }
                            if (type.equals("class java.lang.Long")) {
                               Long i=Long.valueOf((String) map.get(o)).longValue();
                                m.invoke(obj, i);
                            }
                            if (type.equals("class java.lang.Short")) {
                               Short i=Short.valueOf((String) map.get(o)).shortValue();
                                m.invoke(obj, i);
                            }
                            if (type.equals("class java.lang.Double")) {
                                Double i=Double.valueOf((String) map.get(o)).doubleValue();
                                m.invoke(obj, i);
                            }
                            if (type.equals("class java.lang.Boolean")) {
                                Boolean i=Boolean.valueOf((String) map.get(o)).booleanValue();
                                m.invoke(obj, i);
                            }

                        }
                    }
                }
                list.add(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    /**
     *
     * 方法描述: 读取Excel数据 <br/>
     * @param file file文件
     * @param starRow 开始行数(一般第一行是标题)
     * @param starCell 开始单元格
     * @return success or defeat
     */
    public static List<String[]> readExcel(InputStream file, String fileName, int starRow, int starCell) {
        Workbook wb = null;
        //判断文件类型 03或是07
        try {
            if (isExcel2007(fileName)) {
                wb = new XSSFWorkbook(file);
            }
            if (isExcel2003(fileName)) {
                wb = new HSSFWorkbook(file);
            }
        } catch (Exception e) {
            logger.error("解析excel文档流有误。", e);
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            List<String[]> list = new ArrayList<>();
            //选择sheet文件
            Sheet sheet = wb.getSheetAt(0);

            //获得最大行数
            int lastRowNum = sheet.getLastRowNum();
            //System.out.println("最大row行数是："+lastRowNum);
            for (int i = starRow; i <= lastRowNum; i++) {
                //获取第i行的数据
                Row row = sheet.getRow(i);
                //获取第i行的最大cell格
                int lastCellNum = row.getLastCellNum();
                //System.out.println("第"+(i+1)+"行最大cell格数是："+lastCellNum);
                //创建保存数据的String 数组对象
                String[] obj = new String[lastCellNum];
                for (int j = starCell; j < lastCellNum; j++) {
                    Cell cell = row.getCell(j);
                    //获取当前cell表格的值,并放入obj
                    obj[j] = getMyCellType(cell);
                }
                list.add(obj);
            }
            wb.close();
            logger.info("读取excel，成功将其转成Object数组");
            return list;
        } catch (Exception e) {
            logger.error("解析excel文档流有误。", e);
            return null;
        }
    }

    /**
     * 方法描述: Excel导出 <br/>
     * @param columnNames  到导出的对象属性名
     * @param keyList   要导出的对象自己起的输赢对应的名字---（必须与属性名顺序相同）
     * @param objList  要导出的对象集合
     * @param fileName  导出文件名称
     * @throws Exception
     */
    public static void downLoadExcel(String[] columnNames, String[] keyList, List<?> objList, String fileName,HttpServletResponse response){
        if (objList.size() > 1000000){
            List<List<?>> lists = fixedGrouping(objList, 1000000);
            for (int i = 0; i < lists.size(); i++) {
                downLoadExcelManySheet(columnNames,keyList,lists,fileName,0,response);
            }
        }else {
            downLoadExcelSingleSheet(columnNames,keyList,objList,fileName,response);
        }
    }

    private static void downLoadExcelManySheet(String[] columnNames, String[] keyList, List<List<?>> objList, String fileName,int num,HttpServletResponse response) {
        Workbook wb = null;
        //判断文件类型 03或是07
        if (isExcel2007(fileName)) {
            wb = new SXSSFWorkbook();
        }
        if (isExcel2003(fileName)) {
            wb = new HSSFWorkbook();
        }
        //创建sheet
        for (int a = 0; a < objList.size(); a++) {
            List<?> objects = objList.get(a);
            Sheet sheet = wb.createSheet("sheet" + a);
            //创建第一行，存放key
            Row row = sheet.createRow(0);
            for (int i = 0; i < keyList.length; i++) {
                row.createCell(i).setCellValue(keyList[i]);
            }
            //先创建object空对象
            Object project = null;
            for (int i = 0; i < objects.size(); i++) {
                Row row1 = sheet.createRow(i+1);
                for (int j = 0; j < columnNames.length; j++) {
                    //创建obj实例
                    project = objects.get(i);
                    row1.createCell(j).setCellValue(getValueByName(columnNames[j],project)+"");
                }
            }
        }
        //将文件响应到电脑
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            ServletOutputStream out = response.getOutputStream();
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downLoadExcelSingleSheet(String[] columnNames, String[] keyList, List<?> objList, String fileName,HttpServletResponse response) {
        Workbook wb = null;
        //判断文件类型 03或是07
        if (isExcel2007(fileName)) {
            wb = new SXSSFWorkbook();
        }
        if (isExcel2003(fileName)) {
            wb = new HSSFWorkbook();
        }
        //创建sheet
        Sheet sheet = wb.createSheet();

        //创建第一行，存放key
        Row row = sheet.createRow(0);
        for (int i = 0; i < keyList.length; i++) {
            row.createCell(i).setCellValue(keyList[i]);
        }
        //先创建object空对象
        Object project = null;
        for (int i = 0; i < objList.size(); i++) {
            Row row1 = sheet.createRow(i+1);
            for (int j = 0; j < columnNames.length; j++) {
                //创建obj实例
                project = objList.get(i);
                row1.createCell(j).setCellValue(getValueByName(columnNames[j],project)+"");
            }
        }
        setSizeColumn(sheet,columnNames.length);
        //将文件响应到电脑
        try {

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            ServletOutputStream out = response.getOutputStream();
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //利用反射获得对象的值
    private static Object getValueByName(String fieldName, Object obj){
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = obj.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(obj, new Object[] {});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //获得cell的值
    private static String getMyCellType(Cell cell){
        String value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                //如果为时间格式的内容
                if (DateUtil.isCellDateFormatted(cell)) {
                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    value=sdf.format(DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                    break;
                } else {
                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                value = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                value = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                value = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }
        return value;
    }


    // 关闭文件流
    private static void close(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
    //关闭流
    private static void close(InputStream file) {
        if (file != null) {
            try {
                file.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }


    //验证手机号格式是或正确
    private static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean isMatch = false;
        //制定验证条件
        String regex1 = "^[1][3,4,5,7,8][0-9]{9}$";
        String regex2 = "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";
        p = Pattern.compile(regex2);
        m = p.matcher(str);
        isMatch = m.matches();
        return isMatch;
    }

    /**
     * 将一组数据固定分组，每组n个元素
     *
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @return
     */
    private static List<List<?>> fixedGrouping(List<?> source, Integer n) {
        if (null == source || source.size() == 0 || n <= 0)
            return null;
        List<List<?>> result = new ArrayList<>();
        int remainder = source.size() % n;
        int size = (source.size() / n);
        for (int i = 0; i < size; i++) {
            List<?> subset = null;
            subset = source.subList(i * n, (i + 1) * n);
            result.add(subset);
        }
        if (remainder > 0) {
            List<?> subset = null;
            subset = source.subList(size * n, size * n + remainder);
            result.add(subset);
        }
        return result;
    }

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    private static String suffix_xls = ".xls";

    private static String suffix_xlsx = ".xlsx";

    // 判断是否是03的excel:xls
    private static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // 判断是否是07的excel:xlsx
    private static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    // 根据后缀名判断excel是否合法
    private static boolean isCorrectExcel(String filePath) {
        if (isExcel2003(filePath) || isExcel2003(filePath)) {
            return true;
        } else {
            return false;
        }
    }
    private static void setSizeColumn(Sheet sheet, int columnLength) {
        for (int columnNum = 0; columnNum <= columnLength; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum()+1; rowNum++) {
                Row currentRow; // 当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow =  sheet.createRow(rowNum);
                } else {
                    currentRow =  sheet.getRow(rowNum);
                }
                if (currentRow.getCell(columnNum) != null) {
                    Cell currentCell = currentRow.getCell(columnNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }

                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }
    // 自适应宽度(中文支持)
    private static void setSizeColumn2(Sheet sheet) {
        for (int columnNum = 0; columnNum <= 8; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = (HSSFRow) sheet.createRow(rowNum);
                } else {
                    currentRow = (HSSFRow) sheet.getRow(rowNum);
                }

                if (currentRow.getCell(columnNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(columnNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }


}