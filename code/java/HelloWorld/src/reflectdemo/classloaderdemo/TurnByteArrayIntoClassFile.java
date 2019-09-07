package reflectdemo.classloaderdemo;

import java.io.*;

/**
 * @author xiaolei
 * 将字节数组转化为类文件
 */
public class TurnByteArrayIntoClassFile extends ClassLoader {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        TurnByteArrayIntoClassFile tb = new TurnByteArrayIntoClassFile();
        Class<?> cl = tb.getMyClass("/Users/xiaolei/Desktop/k.class");
        System.out.println(cl.newInstance());
    }
    public Class<?> getMyClass(String className) throws
            ClassNotFoundException, IOException {
        // 储存指定路径文件的字节信息
        byte[] byteArray = this.getFileData(className);
        // 加载类文件数据, 类名, byte数组名, 起始位置, 数组长度
        return super.defineClass("k", byteArray, 0, byteArray.length);
    }

    private byte[] getFileData(String className) throws IOException {

        byte[] ret = null;
        // 定义类文件的加载路径
        File file = new File(className);
        // 实例化输入流对象
        InputStream input = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 定义每次分块读取数据的长度
        byte[] data = new byte[1024];
        // 保存每次读取进来的字节个数
        int len = 0;
        while ((len = input.read(data)) != -1) {
            bos.write(data, 0, len);
        }
        // 将内存数据保存到返回数据中
        ret = bos.toByteArray();
        bos.close();
        input.close();
        return ret;
    }
}
