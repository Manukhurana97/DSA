# DSA



## Material

Recursion: https://youtu.be/Mr9MVpSoTGk, https://www.youtube.com/playlist?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
1. **Arrays**: https://www.youtube.com/playlist?list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p
2. **String**  : 
3. **Stack**: Aditya verma : https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
4. **Binary Search**: Aditya verma: https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
5. **Heap**: Aditya verma : https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
6. **Hashmap**: Anuj Bhaiya : https://www.youtube.com/results?search_query=anuj+bhaiya++hashing
7. **Graph**: Take u forward (playlist)
8. **Tree**:  Take u forward (Playlist)
9. **DP**: Aditya verma : https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&ab_channel=AdityaVerma  (playlist)
10. **ALGO Refrence**: https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&ab_channel=AbdulBari
11. **Binary Search**: https://www.youtube.com/watch?v=GU7DpgHINWQ



## Practice


Practice channel: https://www.youtube.com/c/NeetCode/playlists
DP Practice:
- Top 20 Questions: https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/
- Practice Qns on Dp section-wise on leetcode:  https://leetcode.com/discuss/general-discussion/662866/DP-for-Beginners-Problems-or-Patterns-or-Sample-Solutions,                                                         https://leetcode.com/discuss/general-discussion/1050391/must-do-dynamic-programming-problems-category-wise
  https://leetcode.com/discuss/general-discussion/458695/Dynamic-Programming-Patterns


**Further**: https://docs.google.com/document/d/1TK2_ij3oBDy_cqRuXVf3EEWBrLCmoQ7vRiW_zwKrX4A/edit

Help: https://algo.monster/flowchart







SELECT
    sq1.requestId,
    sq1.requestStatus,
    sq1.requesterId,
    sq1.requesterName,
    sq1.delegateld,
    sq1.delegateName,
    sq1.mnemonic,
    sq1.appName,
    sq1.createDate,
    sq1.reviewerld,
    sq1.reviewerName,
    sq1.updateDate,
    sq1.version,
    sq1.remarks,
    sq1.isRollback,
    sq1.rfc_number,
    sq1.next_regionId,
    sq2.deployedVersion,
    at.TYPE_CODE,
    at.TYPE_NAME
FROM
    (SELECT
        aow.request_id AS requestId,
        aow.request_status AS requestStatus,
        aso.app_mnemonic AS mnemonic,
        aso.app_name AS appName,
        aso.create_date AS createDate,
        aow.requester_id AS requesterId,
        aow.REQUESTER_FULL_NAME AS requesterName,
        aow.DELEGATE_ID AS delegateld,
        aow.DELEGATE_FULL_NAME AS delegateName,
        aow.reviewer_id AS reviewerId,
        aow.REVIEWER_FULL_NAME AS reviewerName,
        aow.update_date AS updateDate,
        aow.VERSION AS version,
        aow.REMARKS AS remarks,
        aow.ISROLLBACK AS isRollback,
        aow.RFC_NUMBER AS rfc_number,
        aow.NEXT_REGION_ID AS next_regionId,
        ROW_NUMBER() OVER (PARTITION BY aow.request_id ORDER BY aow.workflow_id DESC) AS ROW_NUMBER
    FROM
        alerts_onboarding_workflow aow
    INNER JOIN
        alerts_ss_onboarding aso ON aow.request_id = aso.request_id
    ) sq1
LEFT JOIN
    (SELECT
        REQUEST_ID,
        workflow_id,
        VERSION AS deployedVersion,
        ROW_NUMBER() OVER (PARTITION BY REQUEST_ID ORDER BY workflow_id DESC) AS ROW_NUMBER1
    FROM
        ALERTS_ONBOARDING_WORKFLOW
    WHERE
        request_status = 'DEPLOYED'
    ) sq2 ON sq1.requestId = sq2.REQUEST_ID
LEFT JOIN
    ALERTS_TYPE at ON at.REQUEST_ID = sq1.requestId
WHERE
    sq1.ROW_NUMBER = 1;


