CREATE TABLE "DASH13540"."POC_ResultNOLEARNING" (
		"Case ID" INTEGER,
		"PrimaKeyword" VARCHAR(50),
		"SecondaKeyword" VARCHAR(50),
		"TerzaKeyword" VARCHAR(50),
		"RelevancePrimaKeyword" FLOAT,
		"RelevanceSecondaKeyword" FLOAT,		
		"RelevanceTerzaKeyword" FLOAT,
		"PrimaCategory" VARCHAR(150),
		"SecondaCategory" VARCHAR(150),
	    "TerzaCategory" VARCHAR(150),
	    "RelevancePrimaCategory" FLOAT,
	    "RelevanceSecondaCategory" FLOAT,	    
	    "RelevanceTerzaaCategory" FLOAT,	
	    "DocumentSentiment" FLOAT,
	    "MillisecElaborazioneWatson" INTEGER
)
	DATA CAPTURE NONE;
	
CREATE TABLE "DASH13540"."POC_ResultSILEARNING" (
		"Case ID" INTEGER,
		"PrimaKeyword" VARCHAR(50),
		"SecondaKeyword" VARCHAR(50),
		"TerzaKeyword" VARCHAR(50),
		"RelevancePrimaKeyword" FLOAT,
		"RelevanceSecondaKeyword" FLOAT,		
		"RelevanceTerzaKeyword" FLOAT,
		"PrimaCategory" VARCHAR(150),
		"SecondaCategory" VARCHAR(150),
	    "TerzaCategory" VARCHAR(150),
	    "RelevancePrimaCategory" FLOAT,
	    "RelevanceSecondaCategory" FLOAT,	    
	    "RelevanceTerzaaCategory" FLOAT,	
	    "DocumentSentiment" FLOAT,
	    "PrimaEntita" VARCHAR(50),
		"SecondaEntita" VARCHAR(50),
		"TerzaEntita" VARCHAR(50),
	    "SottotipoPrimaEntita" VARCHAR(50),
		"SottotipoSecondaEntita" VARCHAR(50),
		"SottotipoTerzaEntita" VARCHAR(50),
	    "ConteggioPrimaEntita" INTEGER,
		"ConteggioSecondaEntita" INTEGER,
		"ConteggioTerzaEntita" INTEGER,
		"Relazioni" VARCHAR(5000),
	    "MillisecElaborazioneWatson" INTEGER
)
	DATA CAPTURE NONE;

