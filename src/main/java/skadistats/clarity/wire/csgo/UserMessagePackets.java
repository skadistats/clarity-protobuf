package skadistats.clarity.wire.csgo;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.csgo.proto.CsGoUserMessages;

import java.util.HashMap;
import java.util.Map;

public class UserMessagePackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> USERMSG;
    static {
        USERMSG = new HashMap<>();

        /*  1 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VGUIMenu_VALUE, CsGoUserMessages.CCSUsrMsg_VGUIMenu.class);
        /*  2 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Geiger_VALUE, CsGoUserMessages.CCSUsrMsg_Geiger.class);
        /*  3 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Train_VALUE, CsGoUserMessages.CCSUsrMsg_Train.class);
        /*  4 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HudText_VALUE, CsGoUserMessages.CCSUsrMsg_HudText.class);
        /*  5 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SayText_VALUE, CsGoUserMessages.CCSUsrMsg_SayText.class);
        /*  6 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SayText2_VALUE, CsGoUserMessages.CCSUsrMsg_SayText2.class);
        /*  7 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_TextMsg_VALUE, CsGoUserMessages.CCSUsrMsg_TextMsg.class);
        /*  8 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HudMsg_VALUE, CsGoUserMessages.CCSUsrMsg_HudMsg.class);
        /*  9 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ResetHud_VALUE, CsGoUserMessages.CCSUsrMsg_ResetHud.class);
        /* 10 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_GameTitle_VALUE, CsGoUserMessages.CCSUsrMsg_GameTitle.class);
        /* 12 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Shake_VALUE, CsGoUserMessages.CCSUsrMsg_Shake.class);
        /* 13 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Fade_VALUE, CsGoUserMessages.CCSUsrMsg_Fade.class);
        /* 14 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Rumble_VALUE, CsGoUserMessages.CCSUsrMsg_Rumble.class);
        /* 15 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CloseCaption_VALUE, CsGoUserMessages.CCSUsrMsg_CloseCaption.class);
        /* 16 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CloseCaptionDirect_VALUE, CsGoUserMessages.CCSUsrMsg_CloseCaptionDirect.class);
        /* 17 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendAudio_VALUE, CsGoUserMessages.CCSUsrMsg_SendAudio.class);
        /* 18 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RawAudio_VALUE, CsGoUserMessages.CCSUsrMsg_RawAudio.class);
        /* 19 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoiceMask_VALUE, CsGoUserMessages.CCSUsrMsg_VoiceMask.class);
        /* 20 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RequestState_VALUE, CsGoUserMessages.CCSUsrMsg_RequestState.class);
        /* 21 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_Damage_VALUE, CsGoUserMessages.CCSUsrMsg_Damage.class);
        /* 22 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RadioText_VALUE, CsGoUserMessages.CCSUsrMsg_RadioText.class);
        /* 23 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_HintText_VALUE, CsGoUserMessages.CCSUsrMsg_HintText.class);
        /* 24 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_KeyHintText_VALUE, CsGoUserMessages.CCSUsrMsg_KeyHintText.class);
        /* 25 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ProcessSpottedEntityUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_ProcessSpottedEntityUpdate.class);
        /* 26 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ReloadEffect_VALUE, CsGoUserMessages.CCSUsrMsg_ReloadEffect.class);
        /* 27 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AdjustMoney_VALUE, CsGoUserMessages.CCSUsrMsg_AdjustMoney.class);
        /* 28 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_UpdateTeamMoney_VALUE, null);
        /* 29 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_StopSpectatorMode_VALUE, CsGoUserMessages.CCSUsrMsg_StopSpectatorMode.class);
        /* 30 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_KillCam_VALUE, CsGoUserMessages.CCSUsrMsg_KillCam.class);
        /* 31 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DesiredTimescale_VALUE, CsGoUserMessages.CCSUsrMsg_DesiredTimescale.class);
        /* 32 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CurrentTimescale_VALUE, CsGoUserMessages.CCSUsrMsg_CurrentTimescale.class);
        /* 33 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AchievementEvent_VALUE, CsGoUserMessages.CCSUsrMsg_AchievementEvent.class);
        /* 34 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MatchEndConditions_VALUE, CsGoUserMessages.CCSUsrMsg_MatchEndConditions.class);
        /* 35 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DisconnectToLobby_VALUE, CsGoUserMessages.CCSUsrMsg_DisconnectToLobby.class);
        /* 36 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_PlayerStatsUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_PlayerStatsUpdate.class);
        /* 37 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_DisplayInventory_VALUE, CsGoUserMessages.CCSUsrMsg_DisplayInventory.class);
        /* 38 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_WarmupHasEnded_VALUE, CsGoUserMessages.CCSUsrMsg_WarmupHasEnded.class);
        /* 39 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ClientInfo_VALUE, CsGoUserMessages.CCSUsrMsg_ClientInfo.class);
        /* 40 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XRankGet_VALUE, CsGoUserMessages.CCSUsrMsg_XRankGet.class);
        /* 41 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XRankUpd_VALUE, CsGoUserMessages.CCSUsrMsg_XRankUpd.class);
        /* 45 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_CallVoteFailed_VALUE, CsGoUserMessages.CCSUsrMsg_CallVoteFailed.class);
        /* 46 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteStart_VALUE, CsGoUserMessages.CCSUsrMsg_VoteStart.class);
        /* 47 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VotePass_VALUE, CsGoUserMessages.CCSUsrMsg_VotePass.class);
        /* 48 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteFailed_VALUE, CsGoUserMessages.CCSUsrMsg_VoteFailed.class);
        /* 49 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_VoteSetup_VALUE, CsGoUserMessages.CCSUsrMsg_VoteSetup.class);
        /* 50 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ServerRankRevealAll_VALUE, CsGoUserMessages.CCSUsrMsg_ServerRankRevealAll.class);
        /* 51 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendLastKillerDamageToClient_VALUE, CsGoUserMessages.CCSUsrMsg_SendLastKillerDamageToClient.class);
        /* 52 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ServerRankUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_ServerRankUpdate.class);
        /* 53 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ItemPickup_VALUE, CsGoUserMessages.CCSUsrMsg_ItemPickup.class);
        /* 54 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ShowMenu_VALUE, CsGoUserMessages.CCSUsrMsg_ShowMenu.class);
        /* 55 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_BarTime_VALUE, CsGoUserMessages.CCSUsrMsg_BarTime.class);
        /* 56 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_AmmoDenied_VALUE, CsGoUserMessages.CCSUsrMsg_AmmoDenied.class);
        /* 57 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MarkAchievement_VALUE, CsGoUserMessages.CCSUsrMsg_MarkAchievement.class);
        /* 58 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_MatchStatsUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_MatchStatsUpdate.class);
        /* 59 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ItemDrop_VALUE, CsGoUserMessages.CCSUsrMsg_ItemDrop.class);
        /* 60 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_GlowPropTurnOff_VALUE, CsGoUserMessages.CCSUsrMsg_GlowPropTurnOff.class);
        /* 61 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendPlayerItemDrops_VALUE, CsGoUserMessages.CCSUsrMsg_SendPlayerItemDrops.class);
        /* 62 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_RoundBackupFilenames_VALUE, CsGoUserMessages.CCSUsrMsg_RoundBackupFilenames.class);
        /* 63 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_SendPlayerItemFound_VALUE, CsGoUserMessages.CCSUsrMsg_SendPlayerItemFound.class);
        /* 64 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_ReportHit_VALUE, CsGoUserMessages.CCSUsrMsg_ReportHit.class);
        /* 65 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_XpUpdate_VALUE, CsGoUserMessages.CCSUsrMsg_XpUpdate.class);
        /* 66 */ USERMSG.put(CsGoUserMessages.ECstrike15UserMessages.CS_UM_QuestProgress_VALUE, CsGoUserMessages.CCSUsrMsg_QuestProgress.class);

    }

    public static boolean isKnownClass(Class<? extends GeneratedMessage> clazz) {
        return USERMSG.containsValue(clazz);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return USERMSG.get(kind);
    }

}
