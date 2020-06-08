package util.excel;

import java.io.*;

public class ExcelFileOperate {
    /**
    * 复制文件
    * 
    * @param s
    * 源文件
    * @param t
    * 复制到的新文件
    */

    public static void fileChannelCopy(File s, File t) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(s),1024);
                out = new BufferedOutputStream(new FileOutputStream(t),1024);
                byte[] buffer = new byte[1024];
                int len; 
                while ((len=in.read(buffer))!=-1) {
                    out.write(buffer,0,len);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 读取excel模板，并复制到新文件中供写入和下载
     * @return
     */
    public static File createNewFile(File file, String modelpath, String newFilePoint){
        //读取模板，并赋值到新文件************************************************************
        //新的文件名
        String newFileName = newFilePoint +System.currentTimeMillis() + ".xls";
        //判断路径是否存在
        File dir = new File(modelpath + "/temp");
        if(!dir.exists()){
            dir.mkdirs();
        }
        //写入到新的excel 
        File newFile = new File(modelpath + "/temp", newFileName);
        try {
            newFile.createNewFile();
            //复制模板到新文件
            fileChannelCopy(file, newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 下载成功后删除
     * 
     * @param files
     */
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
