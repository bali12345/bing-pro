package com.bing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.entity.UserInfo;
import com.bing.service.UserInfoService;
import com.bing.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 胡帅冰
* @description 针对表【user_info(商城用户)】的数据库操作Service实现
* @createDate 2023-06-23 12:07:27
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




