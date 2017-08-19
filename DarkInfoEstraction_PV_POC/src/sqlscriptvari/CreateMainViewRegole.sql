CREATE
    VIEW "DASH13540"."POC_MAININPUTVIEW_SI_REGOLE"(
        CASE_ID,
        TEXT,
        LUNG
    ) AS SELECT
        "Case ID",
        "Note for answer to client",
        LENGTH("Note for answer to client") AS lung
    FROM
        PA_PV_COMPLETE comp
    WHERE
        EXISTS(
            SELECT
                *
            FROM
                "DASH13540"."POC_ResultNOLEARNING" elab
            WHERE
                elab."Case ID" = comp."Case ID"
        )
     AND NOT EXISTS(
            SELECT
                *
            FROM
                "DASH13540"."POC_ResultSIREGOLE" elab1
            WHERE
                elab1."Case ID" = comp."Case ID"
        );
