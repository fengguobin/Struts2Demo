package interceptotr

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import util.Constants;

public class LoginInterceptor extends AbstractInterceptor {  
	  
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get(Constants.USER_SESSION);  
  
        // 如果没有登陆，或者登陆所有的用户名不是admin1，都返回重新登陆  
  
        if (user != null && user.equals("admin1")) {  
            System.out.println("test");  
            return invocation.invoke();  
        }  
  
        ctx.put("tip", "你还没有登录");  
        System.out.println("你不是admin1"); 
        return Action.LOGIN;  
  
    }  
  
}  