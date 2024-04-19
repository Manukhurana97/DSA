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

preserveHtmlContent(htmlString: string): string {
    // Create a temporary <html> element to parse the HTML string
    const tempHtml = document.createElement('html');

    // Use a regular expression to find and preserve specific attributes on the <html> tag
    const preservedHtmlString = htmlString.replace(/<html([^>]*)>/i, (match, p1) => {
        return `<html${p1}>`;
    });

    // Create a text node with the preserved HTML string
    const htmlTextNode = document.createTextNode(preservedHtmlString);
    tempHtml.appendChild(htmlTextNode);

    // Create a wrapper div to ensure that the HTML is properly rendered
    const wrapperDiv = document.createElement('div');
    wrapperDiv.appendChild(tempHtml.cloneNode(true));

    // Convert to WYSIWYG format by setting styles
    const bodyNode = wrapperDiv.querySelector('body');
    if (bodyNode) {
        bodyNode.style.fontFamily = 'Arial, sans-serif'; // Example font family
        bodyNode.style.fontSize = '16px'; // Example font size
        bodyNode.style.lineHeight = '1.5'; // Example line height
        // Add more style adjustments as needed
    }

    // Return the innerHTML of the wrapper div
    return wrapperDiv.innerHTML;
}




```

