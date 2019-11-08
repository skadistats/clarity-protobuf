package skadistats.clarity.wire;

import com.google.protobuf.GeneratedMessage;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

public class ClassToKindMessageRegistry {

    private final Object2IntOpenHashMap<Class<? extends GeneratedMessage>> map;

    public ClassToKindMessageRegistry(int expected) {
        map = new Object2IntOpenHashMap<>(expected, .5f);
    }

    public void put(int kind, Class<? extends GeneratedMessage> clazz) {
        map.put(clazz, kind);
    }

    public boolean containsClass(Class<? extends GeneratedMessage> clazz) {
        return map.containsKey(clazz);
    }

    public Integer kindForClass(Class<? extends GeneratedMessage> clazz) {
        int kind = map.getOrDefault(clazz, -1);
        return kind != -1 ? kind : null;
    }

}
