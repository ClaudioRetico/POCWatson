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
	    "MillisecElaborazioneWatson" INTEGER
)
	DATA CAPTURE NONE;

