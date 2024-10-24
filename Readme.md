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

import os
import re

# Function to extract inline styles and generate class names
def extract_inline_styles(html_content):
    inline_style_pattern = re.compile(r'(<.*?)(style="(.*?)")(.*?>)')
    class_counter = 1
    styles_dict = {}

    def replace_inline_style(match):
        nonlocal class_counter
        before_style = match.group(1)
        style = match.group(3)
        after_style = match.group(4)

        # Check if there is an existing class attribute
        class_match = re.search(r'class="(.*?)"', before_style)
        if class_match:
            existing_classes = class_match.group(1)
            new_class = f"extracted-style-{class_counter}"
            updated_tag = before_style.replace(existing_classes, existing_classes + f" {new_class}") + after_style
        else:
            new_class = f"extracted-style-{class_counter}"
            updated_tag = before_style + f' class="{new_class}"' + after_style

        # Store the style with the generated class
        styles_dict[new_class] = style
        class_counter += 1
        return updated_tag

    updated_html_content = inline_style_pattern.sub(replace_inline_style, html_content)
    return updated_html_content, styles_dict

# Function to generate the CSS content based on extracted styles
def generate_css_content(styles_dict):
    css_content = ""
    for class_name, style in styles_dict.items():
        css_content += f".{class_name} {{\n    {style}\n}}\n"
    return css_content

# Function to process HTML and update the CSS
def process_files(html_file_path, css_file_path):
    with open(html_file_path, 'r') as html_file:
        html_content = html_file.read()

    # Extract inline styles and update HTML
    updated_html_content, styles_dict = extract_inline_styles(html_content)

    # Write the updated HTML content back to the HTML file
    with open(html_file_path, 'w') as html_file:
        html_file.write(updated_html_content)

    # Generate CSS content
    css_content = generate_css_content(styles_dict)

    # Append the extracted CSS to the existing CSS file
    with open(css_file_path, 'a') as css_file:
        css_file.write(css_content)

# Example usage
html_file_path = 'path/to/your/component.html'
css_file_path = 'path/to/your/component.css'
process_files(html_file_path, css_file_path)



```

