package skadistats.clarity.wire.csgo;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.csgo.proto.CsGoNetMessages;
import skadistats.clarity.wire.s1.proto.S1NetMessages;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> OVERRIDES;
    static {
        OVERRIDES = new HashMap<>();

        /*  8 */ OVERRIDES.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, CsGoNetMessages.CSVCMsg_ServerInfo.class);
        /* 34 */ OVERRIDES.put(CsGoNetMessages.SVC_Messages_CsGo.svc_CmdKeyValues_VALUE, CsGoNetMessages.CSVCMsg_CmdKeyValues.class);

    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        Class<? extends GeneratedMessage> cls = OVERRIDES.get(kind);
        if (cls == null) {
            cls = skadistats.clarity.wire.s1.EmbeddedPackets.classForKind(kind);
        }
        return cls;
    }

}
