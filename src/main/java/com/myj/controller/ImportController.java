package com.myj.controller;

import com.myj.entity.ShbxGrjfxx;
import com.myj.entity.User;
import com.myj.service.ImportService;
import com.myj.utils.ExcelUtils;
import com.myj.utils.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMqConfig rabbitMqConfig;
    /**
     * 测试mybatis
     * @return
     */
    @RequestMapping("/testMybatis")
    public List<User> testMybatis(){
        return importService.testMybatis();
    }

    /**
     * 测试向交换机推送数据
     * @return
     */
    @RequestMapping("/testMq")
    public String sendDirectMessage(){
        List<User> users = importService.testMybatis();
        System.out.println(rabbitMqConfig.getImportExchange());
        rabbitTemplate.convertAndSend(rabbitMqConfig.getImportExchange(),rabbitMqConfig.getBjjRoutingKey(),users);
        return "ok";
    }

    /**
     * 导入社会保险excel
     */
    @RequestMapping("/importExcelShbx")
    public void importExcelShbx(MultipartFile file) throws IOException {
        ExcelUtils<ShbxGrjfxx> excelUtils = new ExcelUtils<ShbxGrjfxx>(ShbxGrjfxx.class);
        List<ShbxGrjfxx>  grjfxxList= excelUtils.importExcel(file.getInputStream());
    }



}
