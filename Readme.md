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








----------------------------------------------------------------------------------------------------------------
# Alert-Self Service-tool

Welcome to the Alert-Self-Service-tool project. This sophisticated tool empowers users to define alerts based on precise criteria and communication preferences. The project consists of distinct modules working cohesively to provide an efficient self-service experience.

## Table of Contents

- [Introduction](#introduction)
- [Modules](#modules)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Backend](#self-service-backend)
  - [UI](#self-service-ui)
  - [Data Migration](#self-service-data-migration)
- [Deployment](#deployment)

## Introduction

The Alert- Self Service-tool is a comprehensive solution that allows users to establish alerts utilizing mnemonics, categories, types, and specific criteria. Users have the flexibility to designate their preferred communication channels, such as email, SMS, or on-screen notifications. This modular project is meticulously designed to streamline the management of alerts.

## Modules

1. **Self Service Backend**
  - Developed using Spring Boot in conjunction with Oracle.
  - Powered by Spring Boot version 2.6.6 and Java 11.

2. **Self Service UI**
  - Crafted with Angular 12 and Node 16.5.
  - Provides an intuitive, user-centric interface for creating and managing alerts.
  - To access the UI, use the following URL: `test.com/ui/home`.

3. **Self Service Data Migration**
  - Constructed using Spring Boot and Oracle technologies.
  - Leverages Spring Boot version 2.6.6 and Java 11.
  - Facilitates seamless data migration tasks related to the alert system.

4. **Deployment**
  - Once you push the code to Git, it will automatically be available after a successful pipeline run. The deployment to the designated region will be managed by the automated pipeline.

## Prerequisites

Before embarking on the setup process, ensure that the following prerequisites are met:

- Java 11
- Node.js 16.5
- Oracle Database (required for Backend and Data Migration modules)
- Angular CLI (essential for the UI module)

## Getting Started

To establish and run the project's modules, follow these steps:

### Self Service Backend

1. Specify the VM arguments as follows: `---`
2. Set the Active profile to: `dev`
3. Execute the application within your Integrated Development Environment (IDE).

### Self Service UI

1. Download Node.js version 16.5.0 and Angular version 12.
2. Open the "Self Service UI" module and initiate `npm install` to install essential node modules.
3. Configure settings within the Util Service.
4. Modify the Run configuration: Set the Command to `run`, Scripts to `start`, and execute the configuration.
5. This action initializes the server, initially presenting a blank interface.
6. To access the UI, log in to the admin tool via URL: `test.com`.
7. After a successful login, access `test.com/api/session` to retrieve the session ID.
8. Visit `localhost:4200/ui/validate/{userid}/{sessionId}` to access the home page.

### Self Service Data Migration

1. Set the VM arguments to: `---`
2. Specify the Active profile as: `dev`
3. Initiate the application from your Integrated Development Environment (IDE).

---

Please feel free to personalize and enhance the provided template to align with your project's specific nuances and requirements.
