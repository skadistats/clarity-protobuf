package skadistats.clarity.wire.csgo;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.common.proto.NetMessages;
import skadistats.clarity.wire.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.csgo.proto.CsGoNetMessages;
import skadistats.clarity.wire.s1.proto.S1NetMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C_RECV;
    static {
        K2C_RECV = new KindToClassMessageRegistry(30);
        /*   0 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, CsGoNetMessages.CNETMsg_Disconnect.class);

        /*   4 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_StringCmd_VALUE, NetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, CsGoNetMessages.CNETMsg_SetConVar.class);
        /*   7 */ K2C_RECV.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_ServerInfo_VALUE, CsGoNetMessages.CSVCMsg_ServerInfo.class);
        /*   9 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        /*  10 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_ClassInfo_VALUE, NetMessages.CSVCMsg_ClassInfo.class);
        /*  12 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        /*  13 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, NetMessages.CSVCMsg_UpdateStringTable.class);
        /*  14 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_VoiceInit_VALUE, NetMessages.CSVCMsg_VoiceInit.class);
        /*  15 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_VoiceData_VALUE, S1NetMessages.CSVCMsg_VoiceData.class);
        /*  16 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_Print_VALUE, NetMessages.CSVCMsg_Print.class);
        /*  17 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_Sounds_VALUE, NetMessages.CSVCMsg_Sounds.class);
        /*  18 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_SetView_VALUE, NetMessages.CSVCMsg_SetView.class);
        /*  19 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_FixAngle_VALUE, CsGoNetMessages.CSVCMsg_FixAngle.class);
        /*  21 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_BSPDecal_VALUE, NetMessages.CSVCMsg_BSPDecal.class);
        /*  23 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_UserMessage_VALUE, NetworkBaseTypes.CSVCMsg_UserMessage.class);
        /*  25 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_GameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        /*  26 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        /*  27 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        /*  28 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_Prefetch_VALUE, S1NetMessages.CSVCMsg_Prefetch.class);
        /*  30 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_GameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        /*  31 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_GetCvarValue_VALUE, NetMessages.CSVCMsg_GetCvarValue.class);
        /*  33 */ K2C_RECV.put(S1NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, NetMessages.CSVCMsg_FullFrameSplit.class);
        /*  34 */ K2C_RECV.put(CsGoNetMessages.SVC_Messages_CsGo.svc_CmdKeyValues_VALUE, CsGoNetMessages.CSVCMsg_CmdKeyValues.class);
        /*  35 */ K2C_RECV.put(CsGoNetMessages.SVC_Messages_CsGo.svc_EncryptedData_VALUE, CsGoNetMessages.CSVCMsg_EncryptedData.class);
        /*  36 */ K2C_RECV.put(CsGoNetMessages.SVC_Messages_CsGo.svc_HltvReplay_VALUE, CsGoNetMessages.CSVCMsg_HltvReplay.class);
    }

    private static final KindToClassMessageRegistry K2C_SENT;
    static {
        K2C_SENT = new KindToClassMessageRegistry(20);
        /*   0 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, CsGoNetMessages.CNETMsg_Disconnect.class);

        /*   4 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_StringCmd_VALUE, NetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, CsGoNetMessages.CNETMsg_SetConVar.class);
        /*   7 */ K2C_SENT.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_ClientInfo_VALUE, CsGoNetMessages.CCLCMsg_ClientInfo.class);
        /*   9 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_Move_VALUE, CsGoNetMessages.CCLCMsg_Move.class);
        /*  10 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_VoiceData_VALUE, CsGoNetMessages.CCLCMsg_VoiceData.class);
        /*  11 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_BaselineAck_VALUE, CsGoNetMessages.CCLCMsg_BaselineAck.class);
        /*  12 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_ListenEvents_VALUE, CsGoNetMessages.CCLCMsg_ListenEvents.class);
        /*  13 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_RespondCvarValue_VALUE, CsGoNetMessages.CCLCMsg_RespondCvarValue.class);
        /*  14 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_FileCRCCheck_VALUE, CsGoNetMessages.CCLCMsg_FileCRCCheck.class);
        /*  15 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_LoadingProgress_VALUE, CsGoNetMessages.CCLCMsg_LoadingProgress.class);
        /*  16 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_SplitPlayerConnect_VALUE, CsGoNetMessages.CCLCMsg_SplitPlayerConnect.class);

//        /*  17 */ K2C_SERVER.put(CsGoNetMessages.CLC_Messages.clc_ClientMessage_VALUE, CsGoNetMessages.CCLCMsg_ClientMessage.class);

        /*  18 */ K2C_SENT.put(CsGoNetMessages.CLC_Messages.clc_CmdKeyValues_VALUE, CsGoNetMessages.CCLCMsg_CmdKeyValues.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return K2C_RECV.classForKind(kind);
    }

    private static ClassToKindMessageRegistry C2K_RECV;

    public static Integer kindForClass(Class<? extends GeneratedMessage> clazz) {
        if (C2K_RECV == null) {
            C2K_RECV = K2C_RECV.buildReverse();
        }
        return C2K_RECV.kindForClass(clazz);
    }

    public static Class<? extends GeneratedMessage> sentClassForKind(int kind) {
        return K2C_SENT.classForKind(kind);
    }

    private static ClassToKindMessageRegistry C2K_SENT;

    public static Integer sentKindForClass(Class<? extends GeneratedMessage> clazz) {
        if (C2K_SENT == null) {
            C2K_SENT = K2C_SENT.buildReverse();
        }
        return C2K_SENT.kindForClass(clazz);
    }

}
