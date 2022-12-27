package com.myj.utils;

import com.myj.entity.ShbxGrjfxx;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils<T> {

    /**
     * 工作薄对象
     */
    private Workbook wb;

    /**
     * 实体对象
     */
    public Class<T> clazz;


    public ExcelUtils(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    /**
     * 输入流
     * @param is
     * @return
     */
    public List<T> importExcel(InputStream is) throws IOException {
        return importExcel(is,5);
    }

    /**
     *
     * @param is 输入流
     * @param titleNum 标题占用行数
     * @return
     */
    public List<T> importExcel(InputStream is,int titleNum) throws IOException {
        return importExcel(StringUtils.EMPTY,is,titleNum);
    }

    /**
     *
     * @param sheetName 表格索引名
     * @param is 输入流
     * @param titleNum 标题占用行数
     * @return
     */
    public List<T> importExcel(String sheetName, InputStream is, int titleNum) throws IOException {
        //创建工作簿对象(无需再判断是.xls还是.xlsx格式的文件)
        this.wb = WorkbookFactory.create(is);
        //创建list用来装数据
        List<T> list = new ArrayList<T>();
        //如果指定sheet名就读取指定sheet页，如果不指定默认读取第一个sheet页
        Sheet sheet = StringUtils.isNotEmpty(sheetName) ? wb.getSheet(sheetName) : wb.getSheet("0");
        if (sheet == null){
            throw new IOException("sheet文件不存在");
        }


        return list;
    }
}
