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

import { Renderer2 } from '@angular/core';

function preserveHtmlContent(htmlString: string, renderer: Renderer2): string {
    // Create a document fragment to preserve entire HTML structure
    const fragment = renderer.createDocumentFragment();

    // Create a temporary div to parse the HTML string
    const tempDiv = renderer.createElement('div');
    tempDiv.innerHTML = htmlString;

    // Append the child nodes of the temporary div to the document fragment
    Array.from(tempDiv.childNodes).forEach(childNode => {
        renderer.appendChild(fragment, childNode);
    });

    // Return the HTML content of the document fragment
    return fragment.innerHTML;
}

// Example usage:
const htmlString = '<html><head></head><body><h1>Title</h1><p>Paragraph</p><div style="position: relative"><br><table><tbody><tr><td>1</td></tr>#if($key && $key!=null)<tr><td>2</td></tr>#elseif($key && $key!=null)<tr><td>3</td></tr>#else<tr><td>4</td></tr>#end</tbody></table></div></body></html>';
const wysiwygOutput = preserveHtmlContent(htmlString, renderer2Instance);
console.log(wysiwygOutput); // Output the HTML content as is


```

