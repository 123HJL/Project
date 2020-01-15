package com.hjl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 自定义身份验证类（用于重写WebSecurityConfigurerAdapter默认配置）
 * @Configuration     表示这是一个配置类
 * @EnableWebSecurity    允许security
 * configure()     该方法重写了父类的方法，用于添加用户与角色
 * */
@Configuration
@EnableWebSecurity
public class AuthConfig  extends WebSecurityConfigurerAdapter{
	/** 
     * 重写该方法，添加自定义用户
     * */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//inMemoryAuthentication 从内存中获取 
		//密码进行加密
		 auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		 .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN","USER")
		 .and()
		 .withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER");
		  
	} 
	
	 /**
     * 重写该方法，设定用户访问权限
     * 用户身份可以访问 订单相关API
     * */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")    // 管理员权限
        .antMatchers("/user/**").hasRole("USER")    //用户权限
        .antMatchers("/").hasRole("USER")    //用户权限
        .and()
        .formLogin()
        .loginPage("/login") //跳转登录页面的控制器，该地址要保证和表单提交登录页面的地址一致！（如：通过/login访问的登录页面 这里也是/login ）
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .csrf().disable(); //暂时禁用CSRF，否则无法提交表单
         
    }
	
	 

}
