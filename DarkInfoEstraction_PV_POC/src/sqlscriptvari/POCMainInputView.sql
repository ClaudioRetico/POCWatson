CREATE VIEW "DASH13540"."POC_MAININPUTVIEW" (CASE_ID, TEXT, LUNG) AS
SELECT
        "Case ID",
        "Note for answer to client",
        LENGTH("Note for answer to client") AS lung
    FROM
        PA_PV_COMPLETE comp
    WHERE EXISTS( select * 
                  from "DASH13540"."BaseID" bas
                  where bas."Case ID"= comp."Case ID");

