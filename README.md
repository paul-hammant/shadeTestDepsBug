Bug report: https://issues.apache.org/jira/browse/MSHADE-402

`mvn install` should put apache-commons-csv.jar contents inside `number-adder-1.0-SNAPSHOT-tests.jar` 
because of the shade plugin as specified. Particularly `<shadeTestJar>true</shadeTestJar>`


```
$ ls -al target/
total 48
drwxrwxr-x 9 paul paul 4096 Jan 17 11:44 .
drwxrwxr-x 7 paul paul 4096 Jan 17 11:44 ..
drwxrwxr-x 3 paul paul 4096 Jan 17 11:44 classes
drwxrwxr-x 3 paul paul 4096 Jan 17 11:44 generated-sources
drwxrwxr-x 3 paul paul 4096 Jan 17 11:44 generated-test-sources
drwxrwxr-x 2 paul paul 4096 Jan 17 11:44 maven-archiver
drwxrwxr-x 3 paul paul 4096 Jan 17 11:44 maven-status
-rw-rw-r-- 1 paul paul 2455 Jan 17 11:44 number-adder-1.0-SNAPSHOT.jar
-rw-rw-r-- 1 paul paul   22 Jan 17 11:44 number-adder-1.0-SNAPSHOT-tests.jar
-rw-rw-r-- 1 paul paul 2275 Jan 17 11:44 original-number-adder-1.0-SNAPSHOT.jar
drwxrwxr-x 2 paul paul 4096 Jan 17 11:44 surefire-reports
drwxrwxr-x 3 paul paul 4096 Jan 17 11:44 test-classes

```

If you take out `<scope>test</scope>` from the apache-commons-csv dep, it goes in just fine, 
but Apache-CSV is only used by the tests in this solution. A solution made just for a bug report. 