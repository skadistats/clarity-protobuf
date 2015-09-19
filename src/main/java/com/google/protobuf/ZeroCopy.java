package com.google.protobuf;

public final class ZeroCopy {

    public static ByteString wrap(final byte[] array) {
        return new LiteralByteString(array);
    }

    public static ByteString wrapBounded(final byte[] array, int offset, int length) {
        return new BoundedByteString(array, offset, length);
    }

    public static byte[] extract(final ByteString buf) {
        if (buf instanceof LiteralByteString) {
            return ((LiteralByteString) buf).bytes;
        }
        throw new UnsupportedOperationException("Need a LiteralByteString, got a " + buf.getClass().getName());
    }

}