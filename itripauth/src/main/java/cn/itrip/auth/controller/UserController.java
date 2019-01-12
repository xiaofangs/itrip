package cn.itrip.auth.controller;

import cn.itrip.common.MD5;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import cn.itrip.auth.service.UserService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.userinfo.ItripUserVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;

/**
 * 用户管理控制器
 * @author hduser
 *
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
	
	/**
	 * 使用邮箱注册 
	 * @param userVO
	 * @return
	 */	
	@RequestMapping(value="/doregister",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	Dto doRegister(@RequestBody ItripUserVO userVO) {
		if(!validEmail(userVO.getUserCode())){
			return  DtoUtil.returnFail("请填入正确的邮箱",ErrorCode.AUTH_ILLEGAL_USERCODE);
		}
		String key ="activation:"+userVO.getUserCode();
		ItripUser user=new ItripUser();
		user.setUserCode(userVO.getUserCode());
		user.setUserPassword(userVO.getUserPassword());
		user.setUserName(userVO.getUserName());
		ItripUser users=userService.SelectByUserCode(user.getUserCode());
		if(users!=null){
			return DtoUtil.returnFail("用户已存在",ErrorCode.AUTH_USER_ALREADY_EXISTS);
		}else{
			user.setUserPassword(MD5.getMd5(user.getUserPassword(),32));
			userService.ItriptxCreateUser(user);
			return DtoUtil.returnSuccess();
		}
	}
	
	/**
	 * 使用手机注册
	 * @param userVO
	 * @return
	 */	
	@RequestMapping(value="/registerbyphone",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Dto registerByPhone(			
			@RequestBody ItripUserVO userVO){
		 if(!validPhone(userVO.getUserCode())){
		 	return  DtoUtil.returnFail("请填入正确的手机号码",ErrorCode.AUTH_ILLEGAL_USERCODE);
		 }
		String key ="activation:"+userVO.getUserCode();
        ItripUser user=new ItripUser();
        user.setUserCode(userVO.getUserCode());
        user.setUserPassword(userVO.getUserPassword());
        user.setUserName(userVO.getUserName());
        ItripUser users=userService.SelectByUserCode(user.getUserCode());
        if(users!=null){
            return DtoUtil.returnFail("用户已存在",ErrorCode.AUTH_USER_ALREADY_EXISTS);
		}else{
        	user.setUserPassword(MD5.getMd5(user.getUserPassword(),32));
		    userService.itriptxCreateByPhone(user);
		    return DtoUtil.returnSuccess();
        }

	}

	/**
	 * 检查用户是否已注册
	 * @param name
	 * @return
	 */	
	@RequestMapping(value="/ckusr",method=RequestMethod.GET,produces= "application/json")
	public @ResponseBody
	Dto checkUser(@RequestParam String name) {
		return null;
	}
	
	
	@RequestMapping(value="/activate",method=RequestMethod.PUT,produces= "application/json")
	public @ResponseBody Dto activate(			
			@RequestParam String user,			
			@RequestParam String code){
		boolean boo=userService.activate(user, code);
		try {
			if(boo){
				return DtoUtil.returnSuccess("激活成功");
			}else{
				return DtoUtil.returnSuccess("激活失败");
			}
		}catch (Exception e){
			e.printStackTrace();
			return DtoUtil.returnSuccess("激活失败",ErrorCode.AUTH_UNKNOWN);
		}

	} 
	
	
	@RequestMapping(value="/validatephone",method=RequestMethod.PUT,produces= "application/json")
	public @ResponseBody Dto validatePhone(			
			@RequestParam String user,			
			@RequestParam String code){
		boolean boo=userService.validateByPhone(user, code);
       try {
		   if(boo){
			   return DtoUtil.returnSuccess("验证成功");
		   }else{
			   return DtoUtil.returnSuccess("验证失败");
		   }
	   }catch (Exception e){
       	e.printStackTrace();
       	return DtoUtil.returnSuccess("验证失败",ErrorCode.AUTH_UNKNOWN);
	   }


	}
	
	
	/**			 *
	 * 合法E-mail地址：     
	 * 1. 必须包含一个并且只有一个符号“@”    
	 * 2. 第一个字符不得是“@”或者“.”
	 * 3. 不允许出现“@.”或者.@   
	 * 4. 结尾不得是字符“@”或者“.”    
	 * 5. 允许“@”前的字符中出现“＋” 
	 * 6. 不允许“＋”在最前面，或者“＋@” 
	 */
	private boolean validEmail(String email){
		
		String regex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"  ;			
		return Pattern.compile(regex).matcher(email).find();			
	}
	/**
	 * 验证是否合法的手机号
	 * @param phone
	 * @return
	 */
	private boolean validPhone(String phone) {
		String regex="^1[3578]{1}\\d{9}$";
		return Pattern.compile(regex).matcher(phone).find();
	}
}
