package skadistats.clarity.wire.dota.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.shared.common.proto.NetMessages;
import skadistats.clarity.wire.shared.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.dota.s1.proto.S1NetMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C;
    static {
        K2C = new KindToClassMessageRegistry(25);
        /*   0 */ K2C.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, NetworkBaseTypes.CNETMsg_Disconnect.class);

        /*   4 */ K2C.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C.put(NetworkBaseTypes.NET_Messages.net_StringCmd_VALUE, NetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, NetMessages.CSVCMsg_ServerInfo.class);
        /*   9 */ K2C.put(S1NetMessages.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        /*  10 */ K2C.put(S1NetMessages.SVC_Messages.svc_ClassInfo_VALUE, NetMessages.CSVCMsg_ClassInfo.class);
        /*  12 */ K2C.put(S1NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        /*  13 */ K2C.put(S1NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, NetMessages.CSVCMsg_UpdateStringTable.class);
        /*  14 */ K2C.put(S1NetMessages.SVC_Messages.svc_VoiceInit_VALUE, NetMessages.CSVCMsg_VoiceInit.class);
        /*  15 */ K2C.put(S1NetMessages.SVC_Messages.svc_VoiceData_VALUE, S1NetMessages.CSVCMsg_VoiceData.class);
        /*  16 */ K2C.put(S1NetMessages.SVC_Messages.svc_Print_VALUE, NetMessages.CSVCMsg_Print.class);
        /*  17 */ K2C.put(S1NetMessages.SVC_Messages.svc_Sounds_VALUE, NetMessages.CSVCMsg_Sounds.class);
        /*  18 */ K2C.put(S1NetMessages.SVC_Messages.svc_SetView_VALUE, NetMessages.CSVCMsg_SetView.class);
        /*  21 */ K2C.put(S1NetMessages.SVC_Messages.svc_BSPDecal_VALUE, NetMessages.CSVCMsg_BSPDecal.class);
        /*  23 */ K2C.put(S1NetMessages.SVC_Messages.svc_UserMessage_VALUE, NetworkBaseTypes.CSVCMsg_UserMessage.class);
        /*  25 */ K2C.put(S1NetMessages.SVC_Messages.svc_GameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        /*  26 */ K2C.put(S1NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        /*  27 */ K2C.put(S1NetMessages.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        /*  28 */ K2C.put(S1NetMessages.SVC_Messages.svc_Prefetch_VALUE, S1NetMessages.CSVCMsg_Prefetch.class);
        /*  30 */ K2C.put(S1NetMessages.SVC_Messages.svc_GameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        /*  33 */ K2C.put(S1NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, NetMessages.CSVCMsg_FullFrameSplit.class);

        /* 100 */ K2C.put(NetworkBaseTypes.NET_Messages.net_PlayerAvatarData_VALUE, NetworkBaseTypes.CNETMsg_PlayerAvatarData.class);
    }


    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return K2C.classForKind(kind);
    }

    private static ClassToKindMessageRegistry C2K;

    public static Integer kindForClass(Class<? extends GeneratedMessage> clazz) {
        if (C2K == null) {
            C2K = K2C.buildReverse();
        }
        return C2K.kindForClass(clazz);
    }

}
