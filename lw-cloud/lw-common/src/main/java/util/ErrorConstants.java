package util;
/**
 * api接口返回异常错误码定义
 * 
 * @author  章隆敏
 * @version  [1.0, 2017年1月6日]
 * @since  [pcloud/2.0]
 */
public class ErrorConstants {
	/** 系统异常 */
	public static final int SYS_EXCEPTION_999 = 999;
	/** 参数错误 */
	public static final int PARAMETER_ERROR_1000 = 1000;
	public static final int LOGIN_USERNAME_ERROR=1002;
	public static final int LOGIN_PASSWORD_ERROR=1003;
	/** 原密码错误 */
	public static final int ACCOUNT_OLD_PASSWORD_ERROR_1004 = 1004;
	/** 短信调用过于频繁*/
	public static final int OPT_BUSY_USED_1005 = 1005;
	/** 账号未激活，请先绑定 */
	public static final int ACCOUNT_NO_BIND_1006 = 1006;
	/** 手机号或密码错误 */
	public static final int ACCOUNT_PHONE_OR_PASSWORD_ERROR_1007=1007;
	/** 账号不存在 */
	public static final int ACCOUNT_NOT_EXIST_1008 = 1008;
	/** 账号已经激活 */
	public static final int ACCOUNT_ALREADY_BIND_1009 = 1009;
	/** 用户信息已失效，请重新登录 */
	public static final int RELOGIN_IS_NEED_1010 = 1010;
	/** 该账号已在别的终端登录，请重新登录 */
	public static final int RELOGIN_IS_NEED_1011 = 1011;
	
	
	/** 订单已取消 */
	public static final int CLIENT_NOCANCLE = 2001;
	/** inbound已确认 */
	public static final int CLIENT_NOIBC = 2002;
	/** outbound已执行 */
	public static final int CLIENT_NOOBD = 2003;
	/** outbound已确认 */
	public static final int CLIENT_NOOBC = 2004;
	/** 订单已开始 */
	public static final int CLIENT_BEGIN = 2005;
	
	
	
}
