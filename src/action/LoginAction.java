package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import util.Constants;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public String execute() {
		System.out.println(username);
		System.out.println(password);

		if (isInvalid(getUsername()))
			return INPUT;

		if (isInvalid(getPassword()))
			return INPUT;

		if ((this.getUsername().equals("admin1") || this.getUsername().equals("admin2"))&& this.getPassword().equals("123456")) {
			ActionContext.getContext().getSession().put(Constants.USER_SESSION, getUsername());
			ActionContext.getContext().getSession().put(Constants.PASS, getPassword());
			return "success";
		}
		return "error";
	}
}