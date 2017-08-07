CREATE VIEW "DASH13540"."POC_MAININPUTVIEW" ("Case ID", "Assurance Number", "M anagement Team", "Status", "Case Channel Type", "Case Creation Date", "Case Duration", "Case Resolution Date", "Resolution Team", "Owner User ID", "Case Company", "Case Product", "Case Product feature", "Case Cause", "Case Cause Detail A", "Case Cause Detail B", "Client Channel  Type", "Client First Name", "Client Last Name", "Client Phone", "Client Fiscal ID", "Clien VAT", "Client Address", "Client State", "Client Contact Zip Code", "Client Living Province", "Client Living Zip Code", "Note for answer to client", "CLIENT_PROVINCE", "CLIENT_REGION", lung) AS
SELECT
        "Case ID",
        "Assurance Number",
        "M anagement Team",
        "Status",
        "Case Channel Type",
        "Case Creation Date",
        "Case Duration",
        "Case Resolution Date",
        "Resolution Team",
        "Owner User ID",
        "Case Company",
        "Case Product",
        "Case Product feature",
        "Case Cause",
        "Case Cause Detail A",
        "Case Cause Detail B",
        "Client Channel  Type",
        "Client First Name",
        "Client Last Name",
        "Client Phone",
        "Client Fiscal ID",
        "Clien VAT",
        "Client Address",
        "Client State",
        "Client Contact Zip Code",
        "Client Living Province",
        "Client Living Zip Code",
        "Note for answer to client",
        "CLIENT_PROVINCE",
        "CLIENT_REGION",
        LENGTH("Note for answer to client") AS lung
    FROM
        PA_PV_COMPLETE comp
    LEFT JOIN COMUNI_POSTE_COMPLETO com ON
        com.CLIENT_FIRST_NAME = comp."Client First Name";

