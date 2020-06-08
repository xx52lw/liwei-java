package util.word;

import java.util.*;

/**
 * Create by IntelliJ Idea 2018.2
 *
 * @author: qyp
 * Date: 2019-10-26 17:34
 */
public class DynWordUtilsTest2 {

    /**
     * 说明 普通占位符位${field}格式
     * 表格中的占位符为${tbAddRow:tb1}  tb1为唯一标识符
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {

        // 模板全的路径
        String templatePaht = "D:\\ccdc\\1111.docx";
        // 输出位置
        String outPath = "D:\\ccdc\\221.docx";

        Map<String, Object> paramMap = new HashMap<>(16);
        // 普通的占位符示例 参数数据结构 {str,str}
        paramMap.put("year", "2019");
        paramMap.put("dad7ef57221c4f80b6f990a044ff38adScore", "2010");
        paramMap.put("endYear", "2020");
        paramMap.put("currentYear", "2019");
        paramMap.put("currentMonth", "10");
        paramMap.put("currentDate", "26");
        paramMap.put("name", "黑色玫瑰");

        // 段落中的动态段示例 [str], 支持动态行中添加图片
        List<Object> list1 = new ArrayList<>(Arrays.asList("2、list1_11111", "3、list1_2222"));
        paramMap.put("dad7ef57221c4f80b6f990a044ff38adkf", list1);

        List<String> list2 = new ArrayList<>(Arrays.asList("2、list2_11111", "3、list2_2222"));
        paramMap.put("dad7ef57221c4f80b6f990a044ff38adjf", list2);

        DynWordUtils.process(paramMap, templatePaht, outPath);
    }

    public void testImage() {

        Map<String, Object> paramMap = new HashMap<>(16);
        String templatePaht = "E:\\Java4IDEA\\comm_test\\commutil\\src\\main\\resources\\wordtemplate\\11.docx";
        String outPath = "e:\\3.docx";
        ImageEntity imgEntity1 = new ImageEntity();
        imgEntity1.setHeight(500);
        imgEntity1.setWidth(400);
        imgEntity1.setUrl("E:\\Java4IDEA\\comm_test\\commutil\\src\\main\\resources\\wordtemplate\\image1.jpg");
        imgEntity1.setTypeId(ImageUtils.ImageType.JPG);

        paramMap.put("image:img1", imgEntity1);
        DynWordUtils.process(paramMap, templatePaht, outPath);
    }
}
