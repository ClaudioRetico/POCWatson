SELECT "Case ID" AS ID,
       REPLACE(REPLACE("Note for answer to client", '  ',' '),'____________________',' ') AS TEXT
FROM (
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 0 AND 100
                      FETCH FIRST 10 ROWS ONLY)
UNION ALL     
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 101 AND 200
                      FETCH FIRST 10 ROWS ONLY)
UNION ALL                      
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 201 AND 300
                      FETCH FIRST 10 ROWS ONLY) 
UNION ALL
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 301 AND 400
                      FETCH FIRST 10 ROWS ONLY)    
UNION ALL                      
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 400 AND 500
                      FETCH FIRST 10 ROWS ONLY))                    