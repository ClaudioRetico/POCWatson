SELECT DASH13540.PA_PV_COMPLETE."Case ID", DASH13540.PA_PV_COMPLETE."Status",
  DASH13540.PA_PV_COMPLETE."Case Channel Type", DASH13540.PA_PV_COMPLETE."Case Creation Date",
  DASH13540.PA_PV_COMPLETE."Case Duration", DASH13540.PA_PV_COMPLETE."Case Resolution Date",
  DASH13540.PA_PV_COMPLETE."Resolution Team", DASH13540.PA_PV_COMPLETE."Owner User ID",
  DASH13540.PA_PV_COMPLETE."M anagement Team", DASH13540.PA_PV_COMPLETE."Assurance Number",
  DASH13540.PA_PV_COMPLETE."Case Company", DASH13540.PA_PV_COMPLETE."Case Product",
  DASH13540.PA_PV_COMPLETE."Case Product feature", DASH13540.PA_PV_COMPLETE."Case Cause",
  DASH13540.PA_PV_COMPLETE."Case Cause Detail A", DASH13540.PA_PV_COMPLETE."Case Cause Detail B",
  DASH13540.PA_PV_COMPLETE."Client Channel  Type", DASH13540."POC_ResultSILEARNING"."PrimaKeyword",
  DASH13540."POC_ResultSILEARNING"."SecondaKeyword", DASH13540."POC_ResultSILEARNING"."TerzaKeyword",
  DASH13540."POC_ResultSILEARNING"."RelevancePrimaKeyword", DASH13540."POC_ResultSILEARNING"."RelevanceSecondaKeyword",
  DASH13540."POC_ResultSILEARNING"."RelevanceTerzaKeyword", DASH13540."POC_ResultSILEARNING"."PrimaCategory",
  DASH13540."POC_ResultSILEARNING"."SecondaCategory", DASH13540."POC_ResultSILEARNING"."TerzaCategory",
  DASH13540."POC_ResultSILEARNING"."RelevancePrimaCategory", DASH13540."POC_ResultSILEARNING"."RelevanceSecondaCategory",
  DASH13540."POC_ResultSILEARNING"."RelevanceTerzaaCategory",
  DASH13540."POC_ResultSILEARNING"."DocumentSentiment", DASH13540."POC_ResultSILEARNING"."PrimaEntita",
  DASH13540."POC_ResultSILEARNING"."SecondaEntita", DASH13540."POC_ResultSILEARNING"."TerzaEntita",
  DASH13540."POC_ResultSILEARNING"."SottotipoPrimaEntita", DASH13540."POC_ResultSILEARNING"."SottotipoSecondaEntita",
  DASH13540."POC_ResultSILEARNING"."SottotipoTerzaEntita", DASH13540."POC_ResultSILEARNING"."ConteggioPrimaEntita",
  DASH13540."POC_ResultSILEARNING"."ConteggioSecondaEntita", DASH13540."POC_ResultSILEARNING"."ConteggioTerzaEntita",
  DASH13540."POC_ResultSILEARNING"."Relazioni", DASH13540.PA_PV_COMPLETE."Note for answer to client",
  DASH13540."POC_ResultSILEARNING"."MillisecElaborazioneWatson"
  FROM
       DASH13540.PA_PV_COMPLETE JOIN DASH13540."POC_ResultSILEARNING" ON DASH13540.PA_PV_COMPLETE."Case ID" = DASH13540."POC_ResultSILEARNING"."Case ID"
  ORDER BY DASH13540.PA_PV_COMPLETE."Case ID" ASC
