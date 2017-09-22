package liwei.Thread;

import java.util.concurrent.Callable;

/**
 * callable 接口实现类，作为线程提交任务出现
 * 使用方法返回值
 * 
 * */

public class ThreadPoolCallable implements Callable<String>{
     public String call() throws Exception {
    	    return "abc";
    	 
     };
}
