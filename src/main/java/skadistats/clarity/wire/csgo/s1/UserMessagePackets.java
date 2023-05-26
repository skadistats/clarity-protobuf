package skadistats.clarity.wire.csgo.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.csgo.s1.proto.CSGOS1MessageId;
import skadistats.clarity.wire.csgo.s1.proto.CSGOS1UserMessages;

public class UserMessagePackets {

    private static final KindToClassMessageRegistry K2C;
    static {
        K2C = new KindToClassMessageRegistry(70);

        /*  1 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VGUIMenu_VALUE, CSGOS1UserMessages.CCSUsrMsg_VGUIMenu.class);
        /*  2 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Geiger_VALUE, CSGOS1UserMessages.CCSUsrMsg_Geiger.class);
        /*  3 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Train_VALUE, CSGOS1UserMessages.CCSUsrMsg_Train.class);
        /*  4 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_HudText_VALUE, CSGOS1UserMessages.CCSUsrMsg_HudText.class);
        /*  5 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SayText_VALUE, CSGOS1UserMessages.CCSUsrMsg_SayText.class);
        /*  6 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SayText2_VALUE, CSGOS1UserMessages.CCSUsrMsg_SayText2.class);
        /*  7 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_TextMsg_VALUE, CSGOS1UserMessages.CCSUsrMsg_TextMsg.class);
        /*  8 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_HudMsg_VALUE, CSGOS1UserMessages.CCSUsrMsg_HudMsg.class);
        /*  9 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ResetHud_VALUE, CSGOS1UserMessages.CCSUsrMsg_ResetHud.class);
        /* 10 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_GameTitle_VALUE, CSGOS1UserMessages.CCSUsrMsg_GameTitle.class);
        /* 12 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Shake_VALUE, CSGOS1UserMessages.CCSUsrMsg_Shake.class);
        /* 13 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Fade_VALUE, CSGOS1UserMessages.CCSUsrMsg_Fade.class);
        /* 14 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Rumble_VALUE, CSGOS1UserMessages.CCSUsrMsg_Rumble.class);
        /* 15 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_CloseCaption_VALUE, CSGOS1UserMessages.CCSUsrMsg_CloseCaption.class);
        /* 16 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_CloseCaptionDirect_VALUE, CSGOS1UserMessages.CCSUsrMsg_CloseCaptionDirect.class);
        /* 17 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SendAudio_VALUE, CSGOS1UserMessages.CCSUsrMsg_SendAudio.class);
        /* 18 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_RawAudio_VALUE, CSGOS1UserMessages.CCSUsrMsg_RawAudio.class);
        /* 19 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VoiceMask_VALUE, CSGOS1UserMessages.CCSUsrMsg_VoiceMask.class);
        /* 20 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_RequestState_VALUE, CSGOS1UserMessages.CCSUsrMsg_RequestState.class);
        /* 21 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_Damage_VALUE, CSGOS1UserMessages.CCSUsrMsg_Damage.class);
        /* 22 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_RadioText_VALUE, CSGOS1UserMessages.CCSUsrMsg_RadioText.class);
        /* 23 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_HintText_VALUE, CSGOS1UserMessages.CCSUsrMsg_HintText.class);
        /* 24 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_KeyHintText_VALUE, CSGOS1UserMessages.CCSUsrMsg_KeyHintText.class);
        /* 25 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ProcessSpottedEntityUpdate_VALUE, CSGOS1UserMessages.CCSUsrMsg_ProcessSpottedEntityUpdate.class);
        /* 26 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ReloadEffect_VALUE, CSGOS1UserMessages.CCSUsrMsg_ReloadEffect.class);
        /* 27 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_AdjustMoney_VALUE, CSGOS1UserMessages.CCSUsrMsg_AdjustMoney.class);
        /* 28 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_UpdateTeamMoney_VALUE, null);
        /* 29 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_StopSpectatorMode_VALUE, CSGOS1UserMessages.CCSUsrMsg_StopSpectatorMode.class);
        /* 30 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_KillCam_VALUE, CSGOS1UserMessages.CCSUsrMsg_KillCam.class);
        /* 31 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_DesiredTimescale_VALUE, CSGOS1UserMessages.CCSUsrMsg_DesiredTimescale.class);
        /* 32 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_CurrentTimescale_VALUE, CSGOS1UserMessages.CCSUsrMsg_CurrentTimescale.class);
        /* 33 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_AchievementEvent_VALUE, CSGOS1UserMessages.CCSUsrMsg_AchievementEvent.class);
        /* 34 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_MatchEndConditions_VALUE, CSGOS1UserMessages.CCSUsrMsg_MatchEndConditions.class);
        /* 35 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_DisconnectToLobby_VALUE, CSGOS1UserMessages.CCSUsrMsg_DisconnectToLobby.class);
        /* 36 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_PlayerStatsUpdate_VALUE, CSGOS1UserMessages.CCSUsrMsg_PlayerStatsUpdate.class);
        /* 37 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_DisplayInventory_VALUE, CSGOS1UserMessages.CCSUsrMsg_DisplayInventory.class);
        /* 38 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_WarmupHasEnded_VALUE, CSGOS1UserMessages.CCSUsrMsg_WarmupHasEnded.class);
        /* 39 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ClientInfo_VALUE, CSGOS1UserMessages.CCSUsrMsg_ClientInfo.class);
        /* 40 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_XRankGet_VALUE, CSGOS1UserMessages.CCSUsrMsg_XRankGet.class);
        /* 41 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_XRankUpd_VALUE, CSGOS1UserMessages.CCSUsrMsg_XRankUpd.class);
        /* 45 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_CallVoteFailed_VALUE, CSGOS1UserMessages.CCSUsrMsg_CallVoteFailed.class);
        /* 46 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VoteStart_VALUE, CSGOS1UserMessages.CCSUsrMsg_VoteStart.class);
        /* 47 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VotePass_VALUE, CSGOS1UserMessages.CCSUsrMsg_VotePass.class);
        /* 48 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VoteFailed_VALUE, CSGOS1UserMessages.CCSUsrMsg_VoteFailed.class);
        /* 49 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_VoteSetup_VALUE, CSGOS1UserMessages.CCSUsrMsg_VoteSetup.class);
        /* 50 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ServerRankRevealAll_VALUE, CSGOS1UserMessages.CCSUsrMsg_ServerRankRevealAll.class);
        /* 51 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SendLastKillerDamageToClient_VALUE, CSGOS1UserMessages.CCSUsrMsg_SendLastKillerDamageToClient.class);
        /* 52 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ServerRankUpdate_VALUE, CSGOS1UserMessages.CCSUsrMsg_ServerRankUpdate.class);
        /* 53 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ItemPickup_VALUE, CSGOS1UserMessages.CCSUsrMsg_ItemPickup.class);
        /* 54 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ShowMenu_VALUE, CSGOS1UserMessages.CCSUsrMsg_ShowMenu.class);
        /* 55 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_BarTime_VALUE, CSGOS1UserMessages.CCSUsrMsg_BarTime.class);
        /* 56 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_AmmoDenied_VALUE, CSGOS1UserMessages.CCSUsrMsg_AmmoDenied.class);
        /* 57 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_MarkAchievement_VALUE, CSGOS1UserMessages.CCSUsrMsg_MarkAchievement.class);
        /* 58 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_MatchStatsUpdate_VALUE, CSGOS1UserMessages.CCSUsrMsg_MatchStatsUpdate.class);
        /* 59 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ItemDrop_VALUE, CSGOS1UserMessages.CCSUsrMsg_ItemDrop.class);
        /* 60 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_GlowPropTurnOff_VALUE, CSGOS1UserMessages.CCSUsrMsg_GlowPropTurnOff.class);
        /* 61 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SendPlayerItemDrops_VALUE, CSGOS1UserMessages.CCSUsrMsg_SendPlayerItemDrops.class);
        /* 62 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_RoundBackupFilenames_VALUE, CSGOS1UserMessages.CCSUsrMsg_RoundBackupFilenames.class);
        /* 63 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_SendPlayerItemFound_VALUE, CSGOS1UserMessages.CCSUsrMsg_SendPlayerItemFound.class);
        /* 64 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_ReportHit_VALUE, CSGOS1UserMessages.CCSUsrMsg_ReportHit.class);
        /* 65 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_XpUpdate_VALUE, CSGOS1UserMessages.CCSUsrMsg_XpUpdate.class);
        /* 66 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_QuestProgress_VALUE, CSGOS1UserMessages.CCSUsrMsg_QuestProgress.class);
        /* 69 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_WeaponSound_VALUE, CSGOS1UserMessages.CCSUsrMsg_WeaponSound.class);
        /* 75 */ K2C.put(CSGOS1MessageId.ECstrike15UserMessages.CS_UM_EndOfMatchAllPlayersData_VALUE, CSGOS1UserMessages.CCSUsrMsg_EndOfMatchAllPlayersData.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return K2C.classForKind(kind);
    }

    private static ClassToKindMessageRegistry C2K;

    public static boolean isKnownClass(Class<? extends GeneratedMessage> clazz) {
        if (C2K == null) {
            C2K = K2C.buildReverse();
        }
        return C2K.containsClass(clazz);
    }

}
