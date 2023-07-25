# PhoneBook
myTest

groups:
"positive",
"regress",
"negative"

suites:
reg
login
contact


-Ptarget=preprod


+ All Positive tests -chrome
./gradlew clean -Pbrowser=chrome -Dsuite=positive myTest

+ All Negative tests -firefox
./gradlew clean -Pbrowser=firefox -Dsuite=negative myTest

/// All Tests (Regress) -chrome
./gradlew clean -Pbrowser=chrome -Dsuite=regress -Dgroups=positive myTest

+ Registration Positive -chrome
./gradlew clean -Pbrowser=chrome -Dsuite=reg -Dgroups=positive myTest
+ Registration Negative -Firefox
./gradlew clean -Pbrowser=firefox -Dsuite=reg -Dgroups=negative myTest

+ Login Positive -Firefox
./gradlew clean -Pbrowser=firefox -Dsuite=login -Dgroups=positive myTest
+ Login Negative -Chrome
./gradlew clean -Pbrowser=chrome -Dsuite=login -Dgroups=negative myTest

+ Add contacts 
  ./gradlew clean -Pbrowser=chrome -Dsuite=addcontact myTest

+ Add/Delete All contacts Smoke Tests 
./gradlew clean -Pbrowser=chrome -Dsuite=contact -Dgroups=smoke myTest



