package com.SoulMen.business.createManager.service.Impl;

import com.SoulMen.business.createManager.service.createService;
import com.SoulMen.utils.HttpPostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CreateServiceImpl implements createService {
    @Autowired
    com.SoulMen.business.createManager.dao.createDao createDao;
    @Value("${sqlfactory.sql_system}")
    private String SQLFACTORYHEAD;
    @Override
    public void createTable(MultipartFile MultipartFile) throws IOException {
        HttpPostUtil HttpPostUtil=new HttpPostUtil();
        String SecTxt=HttpPostUtil.uploadFile(SQLFACTORYHEAD+"toSQL/getCreateSql",MultipartFile);

        for (int i=0;i<5;i++) {
            if (!SecTxt.contains("500")) {
                createDao.createTable(SecTxt);
                break;
            } else {
                SecTxt = HttpPostUtil.uploadFile(SQLFACTORYHEAD+"toSQL/getCreateSql", MultipartFile);
            }
        }
    }
    @Override
    public void insertTable(MultipartFile MultipartFile) throws IOException {
        HttpPostUtil HttpPostUtil=new HttpPostUtil();
        String SecTxt=HttpPostUtil.uploadFile(SQLFACTORYHEAD+"toSQL/getInsertSql",MultipartFile);
        for (int i=0;i<5;i++) {
            if (!SecTxt.contains("500")) {
                createDao.insertTable(SecTxt);
                break;
            } else {
                SecTxt = HttpPostUtil.uploadFile(SQLFACTORYHEAD+"toSQL/getInsertSql", MultipartFile);
            }

        }
    }
}
