# Packer
Packer solution is using well-known algorithm with time complexity O(nm) of knapsack problem. The only difference is that the values of weight are floating point numbers. It is assumed that weight values can have only 2 digits after a comma. The output is a formatted string, each line is an answer to one line in an input file. A line contains indexes of things which should be put in the package, these indexes are sorted in ascendng order and separated with a comma.
# Installation
In order to use packer as a java library the packer-0.1.0.jar file should be installed into local maven repository with a command such as :
```sh
mvn install:install-file -Dfile=build\libs\packer-0.1.0.jar -DgroupId=com.mobiquityinc -DartifactId=packer -Dversion=0.1.0 -Dpackaging=jar
```
Sources' and javadocs' files are installed accordinally:
```sh
mvn install:install-file -Dfile=packer-0.1.0-sources.jar  -DgroupId=com.mobiquityinc -DartifactId=packer -Dversion=0.1.0 -Dpackaging=jar -Dclassifier=sources
```
```sh
mvn install:install-file -Dfile=packer-0.1.0-javadoc.jar  -DgroupId=com.mobiquityinc -DartifactId=packer -Dversion=0.1.0 -Dpackaging=jar -Dclassifier=javadoc
```
Using the library as a dependency is possible in maven:
```xml
    <dependency>
        <groupId>com.mobiquityinc</groupId>
        <artifactId>packer</artifactId>
        <version>0.1.0</version>
        <scope>compile</scope>
    </dependency>
```
in gradle:
1. Add a link to the folder where jar files are located
```json
repositories {
    flatDir {
        dirs 'libs'
    }
}
```
2. Define a compile dependency
```json
compile "com.mobiquityinc:packer:0.1.0"
```
