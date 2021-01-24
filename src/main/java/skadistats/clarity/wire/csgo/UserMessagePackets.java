package skadistats.clarity.wire.csgo;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.csgo.proto.CsGoUserMessages;

public class UserMessagePackets {

    private static final KindToClassMessageRegistry K2C;
    static {
        K2C = new KindToClassMessageRegistry(70);

        /*  1 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VGUIMenu_VALUE, CsGoUserMessages.CCSUsrMsg_VGUIMenu.class);
        /*  2 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Geiger_VALUE, CsGoUserMessages.CCSUsrMsg_Geiger.class);
        /*  3 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Train_VALUE, CsGoUserMessages.CCSUsrMsg_Train.class);
        /*  4 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HudText_VALUE, CsGoUserMessages.CCSUsrMsg_HudText.class);
        /*  5 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SayText_VALUE, CsGoUserMessages.CCSUsrMsg_SayText.class);
        /*  6 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SayText2_VALUE, CsGoUserMessages.CCSUsrMsg_SayText2.class);
        /*  7 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_TextMsg_VALUE, CsGoUserMessages.CCSUsrMsg_TextMsg.class);
        /*  8 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HudMsg_VALUE, CsGoUserMessages.CCSUsrMsg_HudMsg.class);
        /*  9 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ResetHud_VALUE, CsGoUserMessages.CCSUsrMsg_ResetHud.class);
        /* 10 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_GameTitle_VALUE, CsGoUserMessages.CCSUsrMsg_GameTitle.class);
        /* 12 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Shake_VALUE, CsGoUserMessages.CCSUsrMsg_Shake.class);
        /* 13 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Fade_VALUE, CsGoUserMessages.CCSUsrMsg_Fade.class);
        /* 14 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Rumble_VALUE, CsGoUserMessages.CCSUsrMsg_Rumble.class);
        /* 15 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CloseCaption_VALUE, CsGoUserMessages.CCSUsrMsg_CloseCaption.class);
        /* 16 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CloseCaptionDirect_VALUE, CsGoUserMessages.CCSUsrMsg_CloseCaptionDirect.class);
        /* 17 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendAudio_VALUE, CsGoUserMessages.CCSUsrMsg_SendAudio.class);
        /* 18 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RawAudio_VALUE, CsGoUserMessages.CCSUsrMsg_RawAudio.class);
        /* 19 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoiceMask_VALUE, CsGoUserMessages.CCSUsrMsg_VoiceMask.class);
        /* 20 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RequestState_VALUE, CsGoUserMessages.CCSUsrMsg_RequestState.class);
        /* 21 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Damage_VALUE, CsGoUserMessages.CCSUsrMsg_Damage.class);
        /* 22 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RadioText_VALUE, CsGoUserMessages.CCSUsrMsg_RadioText.class);
        /* 23 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HintText_VALUE, CsGoUserMessages.CCSUsrMsg_HintText.class);
        /* 24 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_KeyHintText_VALUE, CsGoUserMessages.CCSUsrMsg_KeyHintText.class);
        /* 25 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ProcessSpottedEntityUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_ProcessSpottedEntityUpdate.class);
        /* 26 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ReloadEffect_VALUE, CsGoUserMessages.CCSUsrMsg_ReloadEffect.class);
        /* 27 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AdjustMoney_VALUE, CsGoUserMessages.CCSUsrMsg_AdjustMoney.class);
        /* 28 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_UpdateTeamMoney_VALUE, null);
        /* 29 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_StopSpectatorMode_VALUE, CsGoUserMessages.CCSUsrMsg_StopSpectatorMode.class);
        /* 30 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_KillCam_VALUE, CsGoUserMessages.CCSUsrMsg_KillCam.class);
        /* 31 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DesiredTimescale_VALUE, CsGoUserMessages.CCSUsrMsg_DesiredTimescale.class);
        /* 32 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CurrentTimescale_VALUE, CsGoUserMessages.CCSUsrMsg_CurrentTimescale.class);
        /* 33 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AchievementEvent_VALUE, CsGoUserMessages.CCSUsrMsg_AchievementEvent.class);
        /* 34 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MatchEndConditions_VALUE, CsGoUserMessages.CCSUsrMsg_MatchEndConditions.class);
        /* 35 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DisconnectToLobby_VALUE, CsGoUserMessages.CCSUsrMsg_DisconnectToLobby.class);
        /* 36 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_PlayerStatsUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_PlayerStatsUpdate.class);
        /* 37 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DisplayInventory_VALUE, CsGoUserMessages.CCSUsrMsg_DisplayInventory.class);
        /* 38 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_WarmupHasEnded_VALUE, CsGoUserMessages.CCSUsrMsg_WarmupHasEnded.class);
        /* 39 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ClientInfo_VALUE, CsGoUserMessages.CCSUsrMsg_ClientInfo.class);
        /* 40 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XRankGet_VALUE, CsGoUserMessages.CCSUsrMsg_XRankGet.class);
        /* 41 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XRankUpd_VALUE, CsGoUserMessages.CCSUsrMsg_XRankUpd.class);
        /* 45 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CallVoteFailed_VALUE, CsGoUserMessages.CCSUsrMsg_CallVoteFailed.class);
        /* 46 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteStart_VALUE, CsGoUserMessages.CCSUsrMsg_VoteStart.class);
        /* 47 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VotePass_VALUE, CsGoUserMessages.CCSUsrMsg_VotePass.class);
        /* 48 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteFailed_VALUE, CsGoUserMessages.CCSUsrMsg_VoteFailed.class);
        /* 49 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteSetup_VALUE, CsGoUserMessages.CCSUsrMsg_VoteSetup.class);
        /* 50 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ServerRankRevealAll_VALUE, CsGoUserMessages.CCSUsrMsg_ServerRankRevealAll.class);
        /* 51 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendLastKillerDamageToClient_VALUE, CsGoUserMessages.CCSUsrMsg_SendLastKillerDamageToClient.class);
        /* 52 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ServerRankUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_ServerRankUpdate.class);
        /* 53 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ItemPickup_VALUE, CsGoUserMessages.CCSUsrMsg_ItemPickup.class);
        /* 54 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ShowMenu_VALUE, CsGoUserMessages.CCSUsrMsg_ShowMenu.class);
        /* 55 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_BarTime_VALUE, CsGoUserMessages.CCSUsrMsg_BarTime.class);
        /* 56 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AmmoDenied_VALUE, CsGoUserMessages.CCSUsrMsg_AmmoDenied.class);
        /* 57 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MarkAchievement_VALUE, CsGoUserMessages.CCSUsrMsg_MarkAchievement.class);
        /* 58 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MatchStatsUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_MatchStatsUpdate.class);
        /* 59 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ItemDrop_VALUE, CsGoUserMessages.CCSUsrMsg_ItemDrop.class);
        /* 60 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_GlowPropTurnOff_VALUE, CsGoUserMessages.CCSUsrMsg_GlowPropTurnOff.class);
        /* 61 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendPlayerItemDrops_VALUE, CsGoUserMessages.CCSUsrMsg_SendPlayerItemDrops.class);
        /* 62 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RoundBackupFilenames_VALUE, CsGoUserMessages.CCSUsrMsg_RoundBackupFilenames.class);
        /* 63 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendPlayerItemFound_VALUE, CsGoUserMessages.CCSUsrMsg_SendPlayerItemFound.class);
        /* 64 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ReportHit_VALUE, CsGoUserMessages.CCSUsrMsg_ReportHit.class);
        /* 65 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XpUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_XpUpdate.class);
        /* 66 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_QuestProgress_VALUE, CsGoUserMessages.CCSUsrMsg_QuestProgress.class);
        /* 69 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_WeaponSound_VALUE, CsGoUserMessages.CCSUsrMsg_WeaponSound.class);
        /* 75 */ K2C.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_EndOfMatchAllPlayersData_VALUE, CsGoUserMessages.CCSUsrMsg_EndOfMatchAllPlayersData.class);
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
