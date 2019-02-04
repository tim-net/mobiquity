# Packer
Packer solution is using well-known algorithm with time complexity O(nm) of knapsack problem. The only difference is that the values of weight are floating point numbers. It is assumed that weight values can have only 2 digits after a comma. The output is a formatted string, each line is an answer to one line in an input file. A line contains indexes of things which should be put in the package, these indexes are sorted in ascendng order and separated with a comma.
The approach to solving the problem is based on dynamic programming. First, we define a matrix which number of columns is the maximal weight possible in the package, rows represent things. Values in cells of the matrix are to be filled with sum of things' costs possible to be packed into the package with current cell's weight. Thus in fact the problem of big knapsack is divided to multiple knapsack problems which number is equal to the maximal weight.   Iterating through columns we check if current item can be packed into this current package. If it does we check which cost is bigger - if we do not pack current item getting the value of what was packed with previous thing or if we pack current item and maximum cost of what left, i.e. current item weight is 6, maximum weight is 10, we are currently at the 8th column, thus we check what is better to pack the maximum cost of what was packed with previous things(look into upper level of rows) or our thing of certain cost plus what was maximum cost at the column 4 (10 - 6 = 4) in previous row. In such way we find the maximum possible cost of things at the least cell. Next we should get things which we counted so far. Starting from the end of the matrix we go to upper rows and check if the sum has been changed at this level, if it is we found a thing. The requirement of the assignement demanded that if we have several things with identical cost we should put a thing with lesser weight. It is solved by sorting the things by weight before traversing the matrix - a thing with lesser weight will be counted before a thing with bigger weight, so other things with the same cost will be ignored.
In javadocs of classes I denoted where I have applied design patterns and which ones. In summary, there is the application of the abstract factory for purpose of having different kinds of input in the future (such as a plain string, network resource etc.) and the pattern template for purpose of having different formats of input, for example we can have different separators between groups of data, different notation of groups etc.

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
