package skadistats.clarity.wire.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.DotaUserMessages;
import skadistats.clarity.wire.s1.proto.S1DotaUserMessages;
import skadistats.clarity.wire.s1.proto.S1UserMessages;

import java.util.HashMap;
import java.util.Map;

public class UserMessagePackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> USERMSG;
    static {
        USERMSG = new HashMap<>();
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_AchievementEvent_VALUE, S1UserMessages.CUserMsg_AchievementEvent.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CloseCaption_VALUE, S1UserMessages.CUserMsg_CloseCaption.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S1UserMessages.CUserMsg_CloseCaption.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CurrentTimescale_VALUE, S1UserMessages.CUserMsg_CurrentTimescale.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_DesiredTimescale_VALUE, S1UserMessages.CUserMsg_DesiredTimescale.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Fade_VALUE, S1UserMessages.CUserMsg_Fade.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_GameTitle_VALUE, S1UserMessages.CUserMsg_GameTitle.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Geiger_VALUE, S1UserMessages.CUserMsg_Geiger.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HintText_VALUE, S1UserMessages.CUserMsg_HintText.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HudMsg_VALUE, S1UserMessages.CUserMsg_HudMsg.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HudText_VALUE, S1UserMessages.CUserMsg_HudText.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_KeyHintText_VALUE, S1UserMessages.CUserMsg_KeyHintText.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_MessageText_VALUE, S1UserMessages.CUserMsg_MessageText.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_RequestState_VALUE, S1UserMessages.CUserMsg_RequestState.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_ResetHUD_VALUE, S1UserMessages.CUserMsg_ResetHUD.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Rumble_VALUE, S1UserMessages.CUserMsg_Rumble.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayText_VALUE, S1UserMessages.CUserMsg_SayText.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayText2_VALUE, S1UserMessages.CUserMsg_SayText2.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayTextChannel_VALUE, S1UserMessages.CUserMsg_SayTextChannel.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Shake_VALUE, S1UserMessages.CUserMsg_Shake.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_ShakeDir_VALUE, S1UserMessages.CUserMsg_ShakeDir.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_StatsCrawlMsg_VALUE, S1UserMessages.CUserMsg_StatsCrawlMsg.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_StatsSkipState_VALUE, S1UserMessages.CUserMsg_StatsSkipState.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_TextMsg_VALUE, S1UserMessages.CUserMsg_TextMsg.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Tilt_VALUE, S1UserMessages.CUserMsg_Tilt.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Train_VALUE, S1UserMessages.CUserMsg_Train.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VGUIMenu_VALUE, S1UserMessages.CUserMsg_VGUIMenu.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VoiceMask_VALUE, S1UserMessages.CUserMsg_VoiceMask.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VoiceSubtitle_VALUE, S1UserMessages.CUserMsg_VoiceSubtitle.class);
        USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SendAudio_VALUE, S1UserMessages.CUserMsg_SendAudio.class);
        
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AddUnitToSelection_VALUE, DotaUserMessages.CDOTAUserMsg_AIDebugLine.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AIDebugLine_VALUE, DotaUserMessages.CDOTAUserMsg_AIDebugLine.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ChatEvent.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatHeroPositions_VALUE, DotaUserMessages.CDOTAUserMsg_CombatHeroPositions.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogData_VALUE, null);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogShowDeath_VALUE, DotaUserMessages.CDOTAUserMsg_CombatLogShowDeath.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CreateLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_CreateLinearProjectile.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_DestroyLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_DestroyLinearProjectile.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_DodgeTrackingProjectiles_VALUE, DotaUserMessages.CDOTAUserMsg_DodgeTrackingProjectiles.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightColor_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightColor.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightDirection_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightDirection.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_InvalidCommand_VALUE, DotaUserMessages.CDOTAUserMsg_InvalidCommand.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_LocationPing_VALUE, DotaUserMessages.CDOTAUserMsg_LocationPing.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MapLine_VALUE, DotaUserMessages.CDOTAUserMsg_MapLine.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniKillCamInfo_VALUE, DotaUserMessages.CDOTAUserMsg_MiniKillCamInfo.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapDebugPoint_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapDebugPoint.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapEvent_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapEvent.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_NevermoreRequiem_VALUE, DotaUserMessages.CDOTAUserMsg_NevermoreRequiem.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_OverheadEvent_VALUE, DotaUserMessages.CDOTAUserMsg_OverheadEvent.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SetNextAutobuyItem_VALUE, DotaUserMessages.CDOTAUserMsg_SetNextAutobuyItem.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SharedCooldown_VALUE, DotaUserMessages.CDOTAUserMsg_SharedCooldown.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerClick_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerClick.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialTipInfo_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialTipInfo.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_UnitEvent_VALUE, DotaUserMessages.CDOTAUserMsg_UnitEvent.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BotChat_VALUE, DotaUserMessages.CDOTAUserMsg_BotChat.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HudError_VALUE, DotaUserMessages.CDOTAUserMsg_HudError.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemPurchased_VALUE, DotaUserMessages.CDOTAUserMsg_ItemPurchased.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_Ping_VALUE, DotaUserMessages.CDOTAUserMsg_Ping.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemFound_VALUE, DotaUserMessages.CDOTAUserMsg_ItemFound.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CharacterSpeakConcept_VALUE, null); // MISSING
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SwapVerify_VALUE, DotaUserMessages.CDOTAUserMsg_SwapVerify.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_WorldLine_VALUE, DotaUserMessages.CDOTAUserMsg_WorldLine.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TournamentDrop_VALUE, null); // MISSING
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ItemAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HalloweenDrops_VALUE, DotaUserMessages.CDOTAUserMsg_HalloweenDrops.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatWheel_VALUE, DotaUserMessages.CDOTAUserMsg_ChatWheel.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ReceivedXmasGift_VALUE, DotaUserMessages.CDOTAUserMsg_ReceivedXmasGift.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateSharedContent_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateSharedContent.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialRequestExp_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialRequestExp.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialPingMinimap_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialPingMinimap.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GamerulesStateChanged_VALUE, DotaUserMessages.CDOTAUserMsg_GamerulesStateChanged.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowSurvey_VALUE, DotaUserMessages.CDOTAUserMsg_ShowSurvey.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFade_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFade.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AddQuestLogEntry_VALUE, DotaUserMessages.CDOTAUserMsg_AddQuestLogEntry.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendStatPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendStatPopup.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFinish_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFinish.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendRoshanPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendRoshanPopup.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendGenericToolTip_VALUE, DotaUserMessages.CDOTAUserMsg_SendGenericToolTip.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendFinalGold_VALUE, DotaUserMessages.CDOTAUserMsg_SendFinalGold.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomMsg_VALUE, DotaUserMessages.CDOTAUserMsg_CustomMsg.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CoachHUDPing_VALUE, DotaUserMessages.CDOTAUserMsg_CoachHUDPing.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ClientLoadGridNav_VALUE, DotaUserMessages.CDOTAUserMsg_ClientLoadGridNav.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilityPing_VALUE, DotaUserMessages.CDOTAUserMsg_AbilityPing.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowGenericPopup_VALUE, DotaUserMessages.CDOTAUserMsg_ShowGenericPopup.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteStart_VALUE, DotaUserMessages.CDOTAUserMsg_VoteStart.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteUpdate_VALUE, DotaUserMessages.CDOTAUserMsg_VoteUpdate.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteEnd_VALUE, DotaUserMessages.CDOTAUserMsg_VoteEnd.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BoosterState_VALUE, DotaUserMessages.CDOTAUserMsg_BoosterState.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_WillPurchaseAlert_VALUE, DotaUserMessages.CDOTAUserMsg_WillPurchaseAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialMinimapPosition_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialMinimapPosition.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_PlayerMMR_VALUE, DotaUserMessages.CDOTAUserMsg_PlayerMMR.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilitySteal_VALUE, DotaUserMessages.CDOTAUserMsg_AbilitySteal.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CourierKilledAlert_VALUE, DotaUserMessages.CDOTAUserMsg_CourierKilledAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_EnemyItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EnemyItemAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsMatchDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsMatchDetails.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniTaunt_VALUE, DotaUserMessages.CDOTAUserMsg_MiniTaunt.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BuyBackStateAlert_VALUE, DotaUserMessages.CDOTAUserMsg_BuyBackStateAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_QuickBuyAlert_VALUE, DotaUserMessages.CDOTAUserMsg_QuickBuyAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsHeroDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsHeroMinuteDetails.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_PredictionResult_VALUE, DotaUserMessages.CDOTAUserMsg_PredictionResult.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ModifierAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ModifierAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HPManaAlert_VALUE, DotaUserMessages.CDOTAUserMsg_HPManaAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlyphAlert_VALUE, DotaUserMessages.CDOTAUserMsg_GlyphAlert.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BeastChat_VALUE, DotaUserMessages.CDOTAUserMsg_BeastChat.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerUnitOrders_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerUnitOrders.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CompendiumState_VALUE, DotaUserMessages.CDOTAUserMsg_CompendiumState.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionAbility_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionAbility.class);
        USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionEvent.class);
    }

    public static boolean isKnownClass(Class<? extends GeneratedMessage> clazz) {
        return USERMSG.containsValue(clazz);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return USERMSG.get(kind);
    }

}
