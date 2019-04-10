# Ellas vs Maxims

[![Total alerts](https://img.shields.io/lgtm/alerts/g/maximwebb/ellas-vs-maxims.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/maximwebb/ellas-vs-maxims/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/maximwebb/ellas-vs-maxims.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/maximwebb/ellas-vs-maxims/context:java)

Welcome to Ellas vs Maxims, a parody of Plants vs Zombies.

Setup Guide
------------
- Once you've made a GitHub account, ask Maxim or another one of the devs to add you to the repository.

- Download GitHub Desktop from here: https://desktop.github.com/

- Download Java 11 from here: https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html, and run the setup. If you're on Windows, choose "jdk-11.0.2_windows-x64_bin.exe". If you already have a version of Java (but not v11) don't bother with this step. To check if java is already installed, go to command prompt and run "java -version".

- Download IntelliJ Community (you can use another IDE, but this guide assumes you're using IntelliJ). https://www.jetbrains.com/idea/download/#section=windows

- Open GitHub Desktop and sign in, then go to File > Clone Repository > Choose maximwebb/ellas-vs-maxims. If it doesn't show up in the list, select the URL tab and enter this https://github.com/maximwebb/ellas-vs-maxims.git. Select the folder you'd like to save the project in then click Clone.

- Open up IntelliJ and go to File > Open > C:/PATH_TO_DIRECTORY/ellas-vs-maxims .

- You will need to configure the project SDK. Press Ctrl + Alt + Shift + S to open project settings, select Project on the left, and ensure the Project SDK & language level are set to your Java version. Also make sure that Project compiler output is set to C:/PATH_TO_DIRECTORY/ellas-vs-maxims/out

- On the Project structure on the left, right click on the src directory > Mark Directory As... > Sources Root

- Right click on the resources directory > Mark Directory As... > Resources Root

- Go to Launcher.java and click the green play button next to the class declaration, then click Run Launcher.main().

- If you've done everything correctly, you should now be playing Ellas vs. Maxims! Make sure to check the Development rules below if contributing - have fun!

Development Rules
---------------

- If you are adding minor changes, please do not commit until the feature is complete and the code compiles.

- If adding major changes, please create a separate branch to avoid merge conflicts.

- Stick to the coding style used so far (tabs, curly braces on same line as if/for/while loops etc.)

- Keep different classes to different files (keep everything in the src directory)
