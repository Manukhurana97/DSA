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


function addConditionInBothColumns() {
    const selection = window.getSelection();
    if (selection?.anchorNode) {
        const range = selection.getRangeAt(0);
        if (range?.startContainer?.parentElement) {
            const tr = range.startContainer.parentElement.closest("tr");
            if (tr) {
                const tds = tr.cells;
                const keys = Array.from(tds, cell => cell.querySelector("p")?.textContent?.trim()).filter(Boolean);
                
                if (keys.length > 0) {
                    const tableCount = Math.pow(2, keys.length);
                    
                    for (let i = 0; i < tableCount; i++) {
                        const condition = generateCondition(keys, i);
                        const table = tr.closest("table");
                        if (table?.parentNode) {
                            const tableClone = table.cloneNode(true);
                            tableClone.innerHTML = condition + table.innerHTML;
                            table.parentNode.insertBefore(tableClone, table.nextSibling);
                        }
                    }
                }
            }
        }
    }
}

function generateCondition(keys, index) {
    let condition = "<!-- If no key has data -->\n";
    const selectedKeys = [];

    for (let i = 0; i < keys.length; i++) {
        if ((index >> i) & 1) {
            selectedKeys.push(keys[i]);
        }
    }

    if (selectedKeys.length > 0) {
        condition = `<!-- If key(s) selected: ${selectedKeys.join(", ")} -->\n`;
    }

    return condition + selectedKeys.join("\n");
}



        
```








