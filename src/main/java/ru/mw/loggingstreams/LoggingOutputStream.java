package ru.mw.loggingstreams;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by nixan on 11.12.13.
 */
public class LoggingOutputStream extends OutputStream {

    private final OutputStream mOutputStream;
    private final OutputStream mLoggingStream;

    /**
     * Class that provides on-fly logging for the data that goes through the OutputStream
     *
     * @param outputStream  wrapped stream
     * @param loggingStream stream for logging
     */
    public LoggingOutputStream(OutputStream outputStream, OutputStream loggingStream) {
        mOutputStream = outputStream;
        mLoggingStream = loggingStream;
    }

    @Override
    public void write(int i) throws IOException {
        mOutputStream.write(i);
        mLoggingStream.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        mOutputStream.write(bytes);
        mLoggingStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i2) throws IOException {
        mOutputStream.write(bytes, i, i2);
        mLoggingStream.write(bytes, i, i2);
    }

    @Override
    public void close() throws IOException {
        mOutputStream.close();
        mLoggingStream.write("\n".getBytes());
    }


    @Override
    public void flush() throws IOException {
        mOutputStream.flush();
        mLoggingStream.flush();
    }
}
