SELECT "Case ID" AS ID,
       REPLACE(REPLACE("Note for answer to client", '  ',' '),'____________________',' ') AS TEXT
FROM (
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 1 AND 100
                      FETCH FIRST 30 ROWS ONLY)
UNION ALL     
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 101 AND 200
                      FETCH FIRST 30 ROWS ONLY)
UNION ALL                      
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 201 AND 300
                      FETCH FIRST 20 ROWS ONLY) 
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
                      FETCH FIRST 10 ROWS ONLY)
UNION ALL                      
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 1000 AND 1100
                      FETCH FIRST 15 ROWS ONLY)                      
UNION ALL                      
SELECT "Case ID","Note for answer to client"
FROM DASH13540."PA_PV_COMPLETE" 
WHERE "Case ID" IN (SELECT "Case ID" AS NBR
                      FROM DASH13540."PA_PV_COMPLETE"
                      WHERE LENGTH("Note for answer to client") BETWEEN 3000 AND 4000
                      FETCH FIRST 15 ROWS ONLY)                      
                      
                      )                    