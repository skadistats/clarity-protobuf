package skadistats.clarity.wire.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.NetMessages;
import skadistats.clarity.wire.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.s1.proto.S1NetMessages;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> EMBED;
    static {
        EMBED = new HashMap<>();

        /*  4 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*  6 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        /*  7 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);

        /*  8 */ EMBED.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, NetMessages.CSVCMsg_ServerInfo.class);
        /*  9 */ EMBED.put(S1NetMessages.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        /* 10 */ EMBED.put(S1NetMessages.SVC_Messages.svc_ClassInfo_VALUE, NetMessages.CSVCMsg_ClassInfo.class);
        /* 12 */ EMBED.put(S1NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        /* 13 */ EMBED.put(S1NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, NetMessages.CSVCMsg_UpdateStringTable.class);
        /* 14 */ EMBED.put(S1NetMessages.SVC_Messages.svc_VoiceInit_VALUE, NetMessages.CSVCMsg_VoiceInit.class);
        /* 15 */ EMBED.put(S1NetMessages.SVC_Messages.svc_VoiceData_VALUE, S1NetMessages.CSVCMsg_VoiceData.class);
        /* 16 */ EMBED.put(S1NetMessages.SVC_Messages.svc_Print_VALUE, NetMessages.CSVCMsg_Print.class);
        /* 17 */ EMBED.put(S1NetMessages.SVC_Messages.svc_Sounds_VALUE, NetMessages.CSVCMsg_Sounds.class);
        /* 18 */ EMBED.put(S1NetMessages.SVC_Messages.svc_SetView_VALUE, NetMessages.CSVCMsg_SetView.class);
        /* 23 */ EMBED.put(S1NetMessages.SVC_Messages.svc_UserMessage_VALUE, NetworkBaseTypes.CSVCMsg_UserMessage.class);
        /* 25 */ EMBED.put(S1NetMessages.SVC_Messages.svc_GameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        /* 26 */ EMBED.put(S1NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        /* 27 */ EMBED.put(S1NetMessages.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        /* 30 */ EMBED.put(S1NetMessages.SVC_Messages.svc_GameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        /* 33 */ EMBED.put(S1NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, NetMessages.CSVCMsg_FullFrameSplit.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return EMBED.get(kind);
    }

}
