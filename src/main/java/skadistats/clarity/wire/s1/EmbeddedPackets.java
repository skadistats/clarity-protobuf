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
        EMBED.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        EMBED.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);
        EMBED.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_ClassInfo_VALUE, S1NetMessages.CSVCMsg_ClassInfo.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_GameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_GameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_Menu_VALUE, S1NetMessages.CSVCMsg_Menu.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, S1NetMessages.CSVCMsg_ServerInfo.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_SetView_VALUE, S1NetMessages.CSVCMsg_SetView.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_Sounds_VALUE, S1NetMessages.CSVCMsg_Sounds.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, S1NetMessages.CSVCMsg_UpdateStringTable.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_UserMessage_VALUE, NetworkBaseTypes.CSVCMsg_UserMessage.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_VoiceInit_VALUE, S1NetMessages.CSVCMsg_VoiceInit.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_VoiceData_VALUE, S1NetMessages.CSVCMsg_VoiceData.class);

        EMBED.put(S1NetMessages.SVC_Messages.svc_Print_VALUE, S1NetMessages.CSVCMsg_Print.class);
        EMBED.put(S1NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, S1NetMessages.CSVCMsg_FullFrameSplit.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return EMBED.get(kind);
    }

}
