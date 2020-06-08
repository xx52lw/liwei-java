package util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 */
@Service
@Lazy(false)
public class IdGen{

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
/*	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}*/
	

	 /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
          for(int i=1; i<=4-randLength; i++)
              fourRandom = "0" + fourRandom  ;
      }
        return fourRandom;
    }


	/**
	 * @methodName
	 * @description 随机产生六位随机数
	 * @return
	 * @author cris
	 * @date 2019/3/18 0018 上午 10:37
	 */
	public static String sexRandom(){
		Random random = new Random();
		String sexRandom = random.nextInt(1000000) + "";
		int randLength = sexRandom.length();
		if(randLength<6){
			for(int i=1; i<=6-randLength; i++)
				sexRandom = "0" + sexRandom  ;
		}
		return sexRandom;
	}

	/**
	 * @methodName
	 * @description 生成 订单号
	 * @return
	 * @author cris
	 * @date 2019/3/18 0018 上午 10:37
	 */
	public static String getOrderNum(){
		LocalDateTime date = LocalDateTime.now();
		String yyyyMMddHHmmssSSS = date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
		String orderNum = yyyyMMddHHmmssSSS + sexRandom();
		return orderNum;
	}
}
