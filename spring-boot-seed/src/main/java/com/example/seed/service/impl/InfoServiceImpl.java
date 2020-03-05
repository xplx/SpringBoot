package com.example.seed.service.impl;

import com.example.seed.mapper.InfoMapper;
import com.example.seed.model.entity.Info;
import com.example.seed.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.template.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;


/**
*
* @author wuxiaopeng
* @date 2020/03/05
*/
@Service
@Transactional
public class InfoServiceImpl extends AbstractService<Info> implements InfoService {
    @Autowired
    private InfoMapper userInfoMapper;

}
