package skadistats.clarity.wire.csgo;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.csgo.proto.CsGoNetMessages;
import skadistats.clarity.wire.s1.proto.S1NetMessages;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> OVERRIDES;
    static {
        OVERRIDES = new HashMap<>();

        /*  8 */ OVERRIDES.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, CsGoNetMessages.CSVCMsg_ServerInfo.class);
        /* 19 */ OVERRIDES.put(S1NetMessages.SVC_Messages.svc_FixAngle_VALUE, CsGoNetMessages.CSVCMsg_FixAngle.class);
        /* 34 */ OVERRIDES.put(CsGoNetMessages.SVC_Messages_CsGo.svc_CmdKeyValues_VALUE, CsGoNetMessages.CSVCMsg_CmdKeyValues.class);
        /* 35 */ OVERRIDES.put(CsGoNetMessages.SVC_Messages_CsGo.svc_EncryptedData_VALUE, CsGoNetMessages.CSVCMsg_EncryptedData.class);
        /* 36 */ OVERRIDES.put(CsGoNetMessages.SVC_Messages_CsGo.svc_HltvReplay_VALUE, CsGoNetMessages.CSVCMsg_HltvReplay.class);

    }

    private static final Map<Integer, Class<? extends GeneratedMessage>> CLC;
    static {
        CLC = new HashMap<>();
        /*   0 */ CLC.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ CLC.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, NetworkBaseTypes.CNETMsg_Disconnect.class);

        /*   4 */ CLC.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ CLC.put(NetworkBaseTypes.NET_Messages.net_StringCmd_VALUE, NetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ CLC.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ CLC.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_ClientInfo_VALUE, CsGoNetMessages.CCLCMsg_ClientInfo.class);
        /*   9 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_Move_VALUE, CsGoNetMessages.CCLCMsg_Move.class);
        /*  10 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_VoiceData_VALUE, CsGoNetMessages.CCLCMsg_VoiceData.class);
        /*  11 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_BaselineAck_VALUE, CsGoNetMessages.CCLCMsg_BaselineAck.class);
        /*  12 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_ListenEvents_VALUE, CsGoNetMessages.CCLCMsg_ListenEvents.class);
        /*  13 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_RespondCvarValue_VALUE, CsGoNetMessages.CCLCMsg_RespondCvarValue.class);
        /*  14 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_FileCRCCheck_VALUE, CsGoNetMessages.CCLCMsg_FileCRCCheck.class);
        /*  15 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_LoadingProgress_VALUE, CsGoNetMessages.CCLCMsg_LoadingProgress.class);
        /*  16 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_SplitPlayerConnect_VALUE, CsGoNetMessages.CCLCMsg_SplitPlayerConnect.class);
//        /*  17 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_ClientMessage_VALUE, CsGoNetMessages.CCLCMsg_ClientMessage.class);
        /*  18 */ CLC.put(CsGoNetMessages.CLC_Messages.clc_CmdKeyValues_VALUE, CsGoNetMessages.CCLCMsg_CmdKeyValues.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        Class<? extends GeneratedMessage> cls = OVERRIDES.get(kind);
        if (cls == null) {
            cls = skadistats.clarity.wire.s1.EmbeddedPackets.classForKind(kind);
        }
        return cls;
    }

    public static Class<? extends GeneratedMessage> clientToServerForKind(int kind) {
        return CLC.get(kind);
    }

}
