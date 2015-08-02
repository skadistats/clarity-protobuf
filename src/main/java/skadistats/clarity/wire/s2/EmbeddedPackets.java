package skadistats.clarity.wire.s2;

import com.google.protobuf.GeneratedMessage;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> EMBED;
    static {
        EMBED = new HashMap<>();
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return EMBED.get(kind);
    }

}
