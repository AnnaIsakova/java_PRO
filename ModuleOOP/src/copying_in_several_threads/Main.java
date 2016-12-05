package copying_in_several_threads;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ootka on 05-Dec-16.
 */
//Копирование файла блоками (1 поток на блок).
//Написать программу копирования файла с выводом прогресса в % на
//консоль.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        copyFile("C:\\Users\\Ootka\\Desktop\\test1.txt", "C:\\Users\\Ootka\\Desktop\\dest1.txt");
    }

    public static void copyFile(String srcFile, String destFile)throws IOException, InterruptedException{
        File src = new File(srcFile);
        long length = src.length();
        File dest = new File(destFile);
        byte[] buffer = new byte[(int) length];

        CopyThread copyThread;
        List<CopyThread> list = new ArrayList<>();

        //заполнение списка потоками +
        //вычисление в условии цикла, сколько потоков понадобится для копирования файла с помощью буфера определенного размера
        for (int i = 0; i < length; i += CopyThread.getBufferLength()) {
            copyThread = new CopyThread(src);
            copyThread.getRandomAccessFile().seek(i);
            list.add(copyThread);
        }

        for (CopyThread thread : list) {
            thread.start();
        }

        //заполнение общего буффера, из которого будет производиться запись в файл + вывод прогресс-бара
        int destPos = 0;
        float[] progress = progressPerCent(list.size());
        int counterForProgress = 0;
        for (CopyThread thread : list) {
            thread.join();
            System.out.printf("%.2f", progress[counterForProgress]);
            System.out.println("%");
            counterForProgress++;
            Thread.sleep(1000);
            System.arraycopy(thread.getBuffer(), 0, buffer, destPos, thread.getCounter());
            destPos += thread.getCounter();
        }

        try (OutputStream outputStream = new FileOutputStream(dest)){
            outputStream.write(buffer);
        }
    }

    public static float[] progressPerCent(int dataSize){
        float result = 0;
        float percentPerIteration = 0;
        float[] progressBar = new float[dataSize];
        try {
            percentPerIteration = 100.0f / dataSize;
        } catch (ArithmeticException e){
            e.printStackTrace();
        }

        for (int i = 0; i < progressBar.length; i++) {
            if (result >= (percentPerIteration * (dataSize -1))) {
                result = 100;
                progressBar[i] = result;
            } else {
                result += percentPerIteration;
                progressBar[i] = result;
            }
        }
        return progressBar;
    }
}
