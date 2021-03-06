## Real Estate Finder 

### Running the Project:
1. Clone the repository and open with IntelliJ
2. IntelliJ may not correctly open the project on the first run, but we found the following fix makes the most sense:
   1. After opening, specify the SDK (version 11 +, language level = SDK Default ) and make sure the java folders are marked as sources root and test root respectively.  
   2. Quit IntelliJ (cmd + q or alt - f4) and open it again.
   3. Open the [UserTest](src/test/java/UserTest.java) file, hover on the import statement for JUnit and add it to the class path. 
   4. Hover on the User reference, and select add dependency main.
3. Run `InitDatabaseUser`, `InitDatabaseRealEstateAgent`, and `InitDatabaseProperty`.
4. Compile and run the `RunCLI` class to see the command line interface.
5. Compile and run the `GUI` class to see the graphical user interface and its Swing implementation.
6. Access our CRC cards on Google Slides with [this link](https://docs.google.com/presentation/d/1Mu9Qdts7k7ZLW-95XuRka-Ors4-egG93xTJBwq6y4vs/edit?usp=sharing).   
7. Access our Phase 2 progress report on Google Slides with [this link](https://docs.google.com/presentation/d/1hI_tAqg_NsFf8c4jHdNGhKa5mgej16xgbZ7qWHWf-Rg/).
10. Access our Design Document with [this link](https://docs.google.com/document/d/1ORXrvka8cJgjdwfaZGMPgx_wBiLA-3c3-NhZXgj-_WA/edit?usp=sharing).
