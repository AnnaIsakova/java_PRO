package copying_in_several_threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Ootka on 05-Dec-16.
 */
public class CopyThread extends Thread {
    private static int bufferLength = 1024*4;
    private RandomAccessFile randomAccessFile;
    private byte[] buffer = new byte[bufferLength];
    private int counter;

    CopyThread(File file) throws FileNotFoundException {
        randomAccessFile = new RandomAccessFile(file, "r");
    }

    @Override
    public void run() {
        try {
            counter = randomAccessFile.read(buffer);
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getCounter() {
        return counter;
    }

    public static int getBufferLength() {
        return bufferLength;
    }
}
