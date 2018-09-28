package com.mmall.service;

import com.mmall.common.ServiceResponse;
import com.mmall.pojo.User;

import java.util.ServiceConfigurationError;

public interface IUserService {
    //登录功能
    ServiceResponse<User> login(String username, String password);
    //注册功能
    ServiceResponse<String> register(User user);
    //校验功能
    ServiceResponse<String> checkValid(String str, String type);
    //忘记密码
    ServiceResponse<String> forgetGetQuestion(String username);
    //检验问题答案
    ServiceResponse<String> checkAnswer(String username,String question,String answer);
    //重置密码
    ServiceResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);
    //登录状态下重置密码
    ServiceResponse<String> resetPassword(String passwordOld, String passwordNew,User user);
    //更新用户信息
    ServiceResponse<User> updateInformation(User user);
    //获取用户信息
    ServiceResponse<User> getInformation(Integer userId);


    //backend

    //校验是否为管理员
    ServiceResponse checkAdminRole(User user);
}
