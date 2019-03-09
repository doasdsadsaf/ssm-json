package json.demo.controller;

import json.demo.utils.UrlFilesToZip;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by 或 on 2018/7/1.
 */
@Controller
@RequestMapping("/down")
public class DownController {
    private static final Logger logger = LoggerFactory.getLogger(DownController.class);
    @RequestMapping("/downExcel")
    public void downExcel(HttpServletResponse response) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet( "表1" );
        Row row = sheet.createRow( 0 );
        row.createCell( 0 ).setCellValue( "姓名" );
        Cell cell = row.createCell( 1 );
        cell.setCellValue( "飞天" );
        response.setContentType( "application/vnd.ms-excel" );
        response.setHeader( "Content-disposition", "attachment;filename=student.xls" );
        try {
            OutputStream ouputStream = response.getOutputStream();
            wb.write( ouputStream );
            ouputStream.flush();
            ouputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @RequestMapping("/downExl")
        public void downExl(HttpServletResponse response){
            Workbook wb = new HSSFWorkbook(  );
            Sheet sheet = wb.createSheet("表5");
            Row row = sheet.createRow( 0 );
            row.createCell( 0 ).setCellValue( "姓" );
            Cell cell = row.createCell( 1 );
            cell.setCellValue( "飞" );
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=aaa.xls");
            try {
                OutputStream ouputStream = response.getOutputStream();
                wb.write(ouputStream);
                ouputStream.flush();
                ouputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @RequestMapping("/filesdown")
    public void filesdown(HttpServletResponse response){
        List<String> urls = new ArrayList<String>();
        urls.add( "http://localhost:8080/down/downExcel" );
        urls.add( "http://localhost:8080/down/downExl" );
        try {
            String filename = new String("xx.zip".getBytes("UTF-8"), "ISO8859-1");//控制文件名编码
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            UrlFilesToZip s = new UrlFilesToZip();
            int idx = 1;
            for (String oneFile : urls) {
                zos.putNextEntry(new ZipEntry("profile" + idx +".xls"));
                byte[] bytes = s.getImageFromURL(oneFile);
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
                idx++;
            }
            zos.close();
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
            OutputStream os = response.getOutputStream();
            os.write(bos.toByteArray());
            os.close();
        } catch (FileNotFoundException ex) {
            logger.error("Exception", ex);
        } catch (Exception ex) {
            logger.error("Exception", ex);
        }
    }

}



