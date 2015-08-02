package skadistats.clarity.wire;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Packet {

    private static final Map<Class<? extends GeneratedMessage>, Method> PARSE_METHODS = new HashMap<Class<? extends GeneratedMessage>, Method>() {
        private static final long serialVersionUID = -6842762498712492043L;
        @SuppressWarnings("unchecked")
        @Override
        public Method get(Object key) {
            Method m = super.get(key);
            if (m == null) {
                try {
                    Class<? extends GeneratedMessage> keyAsClass = (Class<? extends GeneratedMessage>) key;
                    m = keyAsClass.getMethod("parseFrom", ByteString.class);
                    put(keyAsClass, m);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return m;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T extends GeneratedMessage> T parse(Class<T> clazz, ByteString data) {
        try {
            return (T) PARSE_METHODS.get(clazz).invoke(null, data);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
    
}
