package skadistats.clarity.wire.csgo.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.csgo.s1.proto.CSGOS1MessageId;
import skadistats.clarity.wire.csgo.s1.proto.CSGOS1NetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetworkBaseTypes;
import skadistats.clarity.wire.shared.s1.proto.S1NetMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C_RECV;
    static {
        K2C_RECV = new KindToClassMessageRegistry(30);
        /*   0 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_NOP_VALUE, CommonNetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_Disconnect_VALUE, CommonNetworkBaseTypes.CNETMsg_Disconnect.class);

        /*   4 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_Tick_VALUE, CommonNetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_StringCmd_VALUE, CommonNetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_SetConVar_VALUE, CommonNetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_SignonState_VALUE, CommonNetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_ServerInfo_VALUE, CSGOS1NetMessages.CSVCMsg_ServerInfo.class);
        /*   9 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        /*  10 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_ClassInfo_VALUE, CommonNetMessages.CSVCMsg_ClassInfo.class);
        /*  12 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        /*  13 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_UpdateStringTable_VALUE, CommonNetMessages.CSVCMsg_UpdateStringTable.class);
        /*  14 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_VoiceInit_VALUE, CommonNetMessages.CSVCMsg_VoiceInit.class);
        /*  15 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_VoiceData_VALUE, CSGOS1NetMessages.CSVCMsg_VoiceData.class);
        /*  16 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_Print_VALUE, CommonNetMessages.CSVCMsg_Print.class);
        /*  17 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_Sounds_VALUE, CommonNetMessages.CSVCMsg_Sounds.class);
        /*  18 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_SetView_VALUE, CommonNetMessages.CSVCMsg_SetView.class);
        /*  19 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_FixAngle_VALUE, CSGOS1NetMessages.CSVCMsg_FixAngle.class);
        /*  21 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_BSPDecal_VALUE, CommonNetMessages.CSVCMsg_BSPDecal.class);
        /*  23 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_UserMessage_VALUE, CommonNetworkBaseTypes.CSVCMsg_UserMessage.class);
        /*  25 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_GameEvent_VALUE, CommonNetworkBaseTypes.CSVCMsg_GameEvent.class);
        /*  26 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_PacketEntities_VALUE, CommonNetMessages.CSVCMsg_PacketEntities.class);
        /*  27 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        /*  28 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_Prefetch_VALUE, CommonNetMessages.CSVCMsg_Prefetch.class);
        /*  30 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_GameEventList_VALUE, CommonNetMessages.CSVCMsg_GameEventList.class);
        /*  31 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_GetCvarValue_VALUE, CSGOS1NetMessages.CSVCMsg_GetCvarValue.class);
        /*  34 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_CmdKeyValues_VALUE, CSGOS1NetMessages.CSVCMsg_CmdKeyValues.class);
        /*  35 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_EncryptedData_VALUE, CSGOS1NetMessages.CSVCMsg_EncryptedData.class);
        /*  36 */ K2C_RECV.put(CSGOS1MessageId.SVC_Messages.svc_HltvReplay_VALUE, CSGOS1NetMessages.CSVCMsg_HltvReplay.class);
        /* 100 */ K2C_RECV.put(CSGOS1MessageId.NET_Messages.net_PlayerAvatarData_VALUE, CSGOS1NetMessages.CNETMsg_PlayerAvatarData.class);
    }

    private static final KindToClassMessageRegistry K2C_SENT;
    static {
        K2C_SENT = new KindToClassMessageRegistry(20);
        /*   0 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_NOP_VALUE, CommonNetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_Disconnect_VALUE, CommonNetworkBaseTypes.CNETMsg_Disconnect.class);

        /*   4 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_Tick_VALUE, CommonNetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_StringCmd_VALUE, CommonNetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_SetConVar_VALUE, CommonNetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C_SENT.put(CSGOS1MessageId.NET_Messages.net_SignonState_VALUE, CommonNetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_ClientInfo_VALUE, CommonNetMessages.CCLCMsg_ClientInfo.class);
        /*   9 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_Move_VALUE, CommonNetMessages.CCLCMsg_Move.class);
        /*  10 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_VoiceData_VALUE, CSGOS1NetMessages.CCLCMsg_VoiceData.class);
        /*  11 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_BaselineAck_VALUE, CommonNetMessages.CCLCMsg_BaselineAck.class);
        /*  12 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_ListenEvents_VALUE, CommonNetMessages.CCLCMsg_ListenEvents.class);
        /*  13 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_RespondCvarValue_VALUE, CommonNetMessages.CCLCMsg_RespondCvarValue.class);
        /*  14 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_FileCRCCheck_VALUE, CSGOS1NetMessages.CCLCMsg_FileCRCCheck.class);
        /*  15 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_LoadingProgress_VALUE, CommonNetMessages.CCLCMsg_LoadingProgress.class);
        /*  16 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_SplitPlayerConnect_VALUE, CSGOS1NetMessages.CCLCMsg_SplitPlayerConnect.class);

//      /*  17 */ K2C_SERVER.put(CSGOS1NetMessages.CLC_Messages.clc_ClientMessage_VALUE, CSGOS1NetMessages.CCLCMsg_ClientMessage.class);

        /*  18 */ K2C_SENT.put(CSGOS1MessageId.CLC_Messages.clc_CmdKeyValues_VALUE, CommonNetMessages.CCLCMsg_CmdKeyValues.class);
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
