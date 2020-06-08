package util;

import java.util.Random;

public class RandomUtils {
    
    static char[] letterSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
            'K', 'L', 'M', 'N', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
             'Y', 'Z'};
    
    static char[] numberSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	/**
	 * 产生0～max的随机整数 包括0 不包括max
	 * 
	 * @param max
	 *            随机数的上限
	 * @return
	 */
	public static int getRandom(int max) {
		return new Random().nextInt(max);
	}

	/**
	 * 产生 min～max的随机整数 包括 min 但不包括 max
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandom(int min, int max) {
		int r = getRandom(max - min);
		return r + min;
	}

	/**
	 * 产生0～max的随机整数 包括0 不包括max
	 * 
	 * @param max
	 *            随机数的上限
	 * @return
	 */
	public static long getRandomLong(long max) {
		long randNum = (long) (Math.random() * max);// + minId;
		return randNum;
	}

	/**
	 * 产生 min～max的随机整数 包括 min 但不包括 max
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static long getRandomLong(long min, long max) {
		long r = getRandomLong(max - min);
		return r + min;
	}

	/**
	 * 随机获取图片
	 * 
	 * @param num
	 * @return
	 */
	public static long getSQLRandom(Long num) {
		Long newNum = getRandomLong(num);
		String numStr = newNum + "";
		if (numStr.length() < 8) {
			return newNum;
		}
		int randLen = getRandom(8, numStr.length());
		return Long.valueOf(numStr.substring(0, randLen));
	}

	/**
	 * 产生size位的随机整数
	 * 
	 * @param size
	 *            字符串的长度
	 * @return
	 */
	public static String getRandomString(int size) {

		StringBuilder build = new StringBuilder();
		for (int i = 0; i < size; i++) {
			build.append(new Random().nextInt(10));
		}
		return build.toString();
	}
	
	/**
     * 生成随机的字母大小写+数字的的字符串
     * 
     * @param len
     *         随机字符串长度
     * @return 随机字符串
     */
    public static String getRandomLetter(int len) {
        Random random = new Random();
        String merchantnum = "";
        // 随机生成0-9a-zA-Z三位混淆码
        while (merchantnum.length() < len) {
            int e;
            e = random.nextInt(75) + 48;
            if ((e <= 57 && e >= 48) || (e <= 122 && e >= 97)) {
                merchantnum += (char) e;
            }
        }
        return merchantnum;
    }
}
