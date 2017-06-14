package com.hkp.stream;

import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestPrintStream
{
    public static void main(String[] args)
    {
        final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 }; // abced
        try {
            // 创建文件“file.txt”的File对象
            File file = new File("file.txt");
            // 创建文件对应FileOutputStream
            //PrintStream out = new PrintStream(new FileOutputStream(file));
            PrintStream out = new PrintStream(file);
            // 将“字节数组arr”全部写入到输出流中
            out.write(arr);
            out.println();
            out.println("hello world");
            out.println();
            out.write(0x41);
            out.println();
            out.print(0x41);
            out.println();
            out.append('B');
            // 关闭输出流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
