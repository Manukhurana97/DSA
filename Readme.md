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

def divide_into_chunks(image_string, chunk_size):
    return [image_string[i:i + chunk_size] for i in range(0, len(image_string), chunk_size)]

def create_update_scripts(table, update_date_column, template_column, old_image, new_image, chunk_size=4000):
    old_image_chunks = divide_into_chunks(old_image, chunk_size)
    new_image_chunks = divide_into_chunks(new_image, chunk_size)

    update_scripts = []
    for old_chunk, new_chunk in zip(old_image_chunks, new_image_chunks):
        script = (f"UPDATE {table} SET {update_date_column} = SYSDATE, "
                  f"{template_column} = REPLACE({template_column}, '{old_chunk}', '{new_chunk}');")
        update_scripts.append(script)
    
    return update_scripts

# Example usage
old_image = "your_old_image_string_here"
new_image = "your_new_image_string_here"
table = "ALERTS_COMMUNICATION_DATA"
update_date_column = "UPDATE_DATE"
template_column = "EMAIL_TEMPLATE"

update_scripts = create_update_scripts(table, update_date_column, template_column, old_image, new_image)
for script in update_scripts:
    print(script)


```

