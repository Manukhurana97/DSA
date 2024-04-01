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


function addConditionInBothColumns(): void {
    const selection = window.getSelection();
    if (selection?.anchorNode) {
        const range = selection.getRangeAt(0);
        if (range?.startContainer?.parentElement) {
            const tr = range.startContainer.parentElement.closest("tr");
            if (tr) {
                const tds = tr.cells;
                const key1: string | undefined = tds[0].querySelector("p")?.textContent?.trim();
                const key2: string | undefined = tds[1].querySelector("p")?.textContent?.trim();
                const keys: string = (key1 && key1 !== "") && (key2 && key2 !== "") ? "both" : (key1 || key2) ? "either" : "none";
                
                const table = tr.closest("table");
                if (table?.parentNode) {
                    const startCondition: string = `<!-- #if(${keys} && ${keys} !== "") -->\n`;
                    const elseIfCondition: string = `<!-- #elseif(${keys} && ${keys} !== "") -->\n`;
                    const endCondition: string = `<!-- #end -->\n`;
                    
                    const tableClone: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                    const tableCount: number = (keys === "both") ? 4 : 1;
                    
                    for (let i = 0; i < tableCount; i++) {
                        const condition: string = (i === 0) ? startCondition : (i === tableCount - 1) ? endCondition : elseIfCondition;
                        const tableCloneInnerHtml: string = condition + table.innerHTML;
                        const tableCloneTemp: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                        tableCloneTemp.innerHTML = tableCloneInnerHtml;
                        table.parentNode.insertBefore(tableCloneTemp, table.nextSibling);
                    }
                }
            }
        }
    }
}

    







function addConditionInBothColumns(): void {
    const selection = window.getSelection();
    if (selection?.anchorNode) {
        const range = selection.getRangeAt(0);
        if (range?.startContainer?.parentElement) {
            const tr = range.startContainer.parentElement.closest("tr");
            if (tr) {
                const selectedRows = Array.from(tr.closest("table")?.querySelectorAll("tr.selected") || []);
                const selectedRowCount = selectedRows.length;
                const tds = tr.cells;
                const key1: string | undefined = tds[0].querySelector("p")?.textContent?.trim();
                const key2: string | undefined = tds[1].querySelector("p")?.textContent?.trim();
                const keys: string = (key1 && key1 !== "") && (key2 && key2 !== "") ? "both" : (key1 || key2) ? "either" : "none";
                
                const table = tr.closest("table");
                if (table?.parentNode) {
                    const startCondition: string = `<!-- #if(${keys} && ${keys} !== "") -->\n`;
                    const elseIfCondition: string = `<!-- #elseif(${keys} && ${keys} !== "") -->\n`;
                    const endCondition: string = `<!-- #end -->\n`;
                    
                    const tableClone: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                    const tableCount: number = Math.pow(2, selectedRowCount);
                    
                    for (let i = 0; i < tableCount; i++) {
                        const condition: string = (i === 0) ? startCondition : (i === tableCount - 1) ? endCondition : elseIfCondition;
                        const tableCloneInnerHtml: string = condition + table.innerHTML;
                        const tableCloneTemp: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                        tableCloneTemp.innerHTML = tableCloneInnerHtml;
                        table.parentNode.insertBefore(tableCloneTemp, table.nextSibling);
                    }
                }
            }
        }
    }
}





function addConditionInBothColumns(): void {
    const selection: Selection | null = window.getSelection();
    if (selection?.anchorNode) {
        const range: Range = selection.getRangeAt(0);
        if (range?.startContainer?.parentElement) {
            const tr: HTMLTableRowElement | null = range.startContainer.parentElement.closest('tr');
            if (tr) {
                const tds: HTMLCollectionOf<HTMLTableCellElement> = tr.cells;
                if (tds.length === 2) {
                    const key: string | undefined = tds[1].querySelector('p')?.textContent?.trim();
                    if (key) {
                        const condition: string = `<div>\n<pre>\n#if(${key} && ${key} !== '')\n</pre></div>`;
                        const elseIfCondition: string = `<div>\n<pre>\n#elseif(${key} && ${key} === '')\n</pre></div>`;
                        const endCondition: string = "#end";
                        const table: HTMLTableElement | null = tr.closest('table');
                        if (table && table.parentNode) {
                            const existingCondition: HTMLElement | null = table.previousElementSibling as HTMLElement;
                            if (existingCondition && existingCondition.tagName === "DIV" && existingCondition.querySelector('pre')) {
                                table.parentNode.insertBefore(table.cloneNode(true), table.nextSibling);
                            } else {
                                const tableClone: HTMLTableElement = table.cloneNode(true) as HTMLTableElement;
                                tableClone.innerHTML = condition + elseIfCondition + table.innerHTML + endCondition;
                                table.parentNode.insertBefore(tableClone, table.nextSibling);
                            }
                        }
                    }
                }
            }
        }
    }
}




```

