package ru.mw.loggingstreams;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by nixan on 11.12.13.
 */
public class LoggingOutputStream extends OutputStream {

    private final OutputStream mOutputStream;
    private final OutputStream mLoggingStream;

    public LoggingOutputStream(OutputStream outputStream, OutputStream loggingStream) {
        mOutputStream = outputStream;
        mLoggingStream = loggingStream;
    }

    public LoggingOutputStream(OutputStream outputStream) {
        this(outputStream, null);
    }

    private boolean isLoggingEnabled() {
        return mLoggingStream != null;
    }

    @Override
    public void write(int i) throws IOException {
        mOutputStream.write(i);
        if (isLoggingEnabled())
            mLoggingStream.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        mOutputStream.write(bytes);
        if (isLoggingEnabled())
            mLoggingStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i2) throws IOException {
        mOutputStream.write(bytes, i, i2);
        if (isLoggingEnabled())
            mLoggingStream.write(bytes, i, i2);
    }

    @Override
    public void close() throws IOException {
        mOutputStream.close();
        mLoggingStream.close();
    }

    @Override
    public void flush() throws IOException {
        mOutputStream.flush();
        mLoggingStream.flush();
    }
}
