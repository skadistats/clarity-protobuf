package skadistats.clarity.wire.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.s1.proto.Netmessages;
import skadistats.clarity.wire.s1.proto.Networkbasetypes;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> EMBED;
    static {
        EMBED = new HashMap<>();
        EMBED.put(Networkbasetypes.NET_Messages.net_SetConVar_VALUE, Networkbasetypes.CNETMsg_SetConVar.class);
        EMBED.put(Networkbasetypes.NET_Messages.net_SignonState_VALUE, Networkbasetypes.CNETMsg_SignonState.class);
        EMBED.put(Networkbasetypes.NET_Messages.net_Tick_VALUE, Networkbasetypes.CNETMsg_Tick.class);
        EMBED.put(Netmessages.SVC_Messages.svc_ClassInfo_VALUE, Netmessages.CSVCMsg_ClassInfo.class);
        EMBED.put(Netmessages.SVC_Messages.svc_CreateStringTable_VALUE, Netmessages.CSVCMsg_CreateStringTable.class);
        EMBED.put(Netmessages.SVC_Messages.svc_GameEvent_VALUE, Networkbasetypes.CSVCMsg_GameEvent.class);
        EMBED.put(Netmessages.SVC_Messages.svc_GameEventList_VALUE, Netmessages.CSVCMsg_GameEventList.class);
        EMBED.put(Netmessages.SVC_Messages.svc_Menu_VALUE, Netmessages.CSVCMsg_Menu.class);
        EMBED.put(Netmessages.SVC_Messages.svc_PacketEntities_VALUE, Netmessages.CSVCMsg_PacketEntities.class);
        EMBED.put(Netmessages.SVC_Messages.svc_SendTable_VALUE, Netmessages.CSVCMsg_SendTable.class);
        EMBED.put(Netmessages.SVC_Messages.svc_ServerInfo_VALUE, Netmessages.CSVCMsg_ServerInfo.class);
        EMBED.put(Netmessages.SVC_Messages.svc_SetView_VALUE, Netmessages.CSVCMsg_SetView.class);
        EMBED.put(Netmessages.SVC_Messages.svc_Sounds_VALUE, Netmessages.CSVCMsg_Sounds.class);
        EMBED.put(Netmessages.SVC_Messages.svc_TempEntities_VALUE, Netmessages.CSVCMsg_TempEntities.class);
        EMBED.put(Netmessages.SVC_Messages.svc_UpdateStringTable_VALUE, Netmessages.CSVCMsg_UpdateStringTable.class);
        EMBED.put(Netmessages.SVC_Messages.svc_UserMessage_VALUE, Networkbasetypes.CSVCMsg_UserMessage.class);
        EMBED.put(Netmessages.SVC_Messages.svc_VoiceInit_VALUE, Netmessages.CSVCMsg_VoiceInit.class);
        EMBED.put(Netmessages.SVC_Messages.svc_VoiceData_VALUE, Netmessages.CSVCMsg_VoiceData.class);

        EMBED.put(Netmessages.SVC_Messages.svc_Print_VALUE, Netmessages.CSVCMsg_Print.class);
        EMBED.put(Netmessages.SVC_Messages.svc_FullFrameSplit_VALUE, Netmessages.CSVCMsg_FullFrameSplit.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return EMBED.get(kind);
    }

}
