package skadistats.clarity.wire.s2;

import com.google.protobuf.GeneratedMessage;

import java.util.HashMap;
import java.util.Map;

public class UserMessagePackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> USERMSG;
    static {
        USERMSG = new HashMap<>();
    }

    public static boolean isKnownClass(Class<? extends GeneratedMessage> clazz) {
        return USERMSG.containsValue(clazz);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return USERMSG.get(kind);
    }

}
