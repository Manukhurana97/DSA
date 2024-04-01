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







```

addConditionToSelectedRows(): void {
    const selection: Selection | null = window.getSelection();
    if (selection && selection.rangeCount > 0) {
        const range: Range = selection.getRangeAt(0);
        const table: HTMLTableElement | null = range.commonAncestorContainer.closest('table');
        
        if (table) {
            const selectedRows: HTMLTableRowElement[] = [];
            const trs: NodeListOf<HTMLTableRowElement> = table.querySelectorAll('tr');
            trs.forEach((tr) => {
                const rects = selection.getRangeAt(0).getClientRects();
                const trRect = tr.getBoundingClientRect();
                for (let i = 0; i < rects.length; i++) {
                    if (rects[i].top >= trRect.top && rects[i].bottom <= trRect.bottom) {
                        selectedRows.push(tr);
                        break;
                    }
                }
            });
            
            if (selectedRows.length > 0) {
                const key: string | undefined = prompt("Enter the condition key:");
                if (key) {
                    const condition: string = `#if(${key} + ${key} & ${key} + ${key} [**)\n`;
                    const elseIfCondition: string = `#elseif(${key} + ${key} & ${key} + ${key} [***)\n`;
                    const endCondition: string = '#end\n';
                    
                    selectedRows.forEach((tr) => {
                        const tableClone: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                        tableClone.innerHTML = elseIfCondition + tr.innerHTML + endCondition;
                        tr.insertAdjacentHTML('beforebegin', condition);
                        tr.parentNode.insertBefore(tableClone, tr.nextSibling);
                    });
                }
            } else {
                console.log("No rows selected.");
            }
        } else {
            console.log("No table found.");
        }
    } else {
        console.log("No selection made.");
    }
}
```








