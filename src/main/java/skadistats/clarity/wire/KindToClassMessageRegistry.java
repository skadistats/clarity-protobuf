package skadistats.clarity.wire;

import com.google.protobuf.GeneratedMessage;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class KindToClassMessageRegistry {

    private final Int2ObjectOpenHashMap<Class<? extends GeneratedMessage>> map;

    public KindToClassMessageRegistry(int expected) {
        map = new Int2ObjectOpenHashMap<>(expected, .5f);
    }

    private KindToClassMessageRegistry(KindToClassMessageRegistry other) {
        map = new Int2ObjectOpenHashMap<>(other.map, 0.5f);
    }

    public void put(int kind, Class<? extends GeneratedMessage> clazz) {
        map.put(kind, clazz);
    }

    public boolean containsKind(int kind) {
        return map.containsKey(kind);
    }

    public Class<? extends GeneratedMessage> classForKind(int kind) {
        return map.get(kind);
    }

    public ClassToKindMessageRegistry buildReverse() {
        ClassToKindMessageRegistry result = new ClassToKindMessageRegistry(map.size());
        map.forEach(result::put);
        return result;
    }

    public KindToClassMessageRegistry copy() {
        return new KindToClassMessageRegistry(this);
    }

}
