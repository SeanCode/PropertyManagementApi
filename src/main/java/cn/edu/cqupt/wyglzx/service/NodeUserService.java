package cn.edu.cqupt.wyglzx.service;

import cn.edu.cqupt.wyglzx.dao.NodeUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cc on 16/6/25.
 */
@Component
public class NodeUserService {

    @Autowired
    NodeUserDao nodeUserDao;

}
