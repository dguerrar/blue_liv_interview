#### Built & tested with Java 1.8 & maven 3.23.

The maven script (pom.xml) build the app + run junit tests + tun de code coverage test

```
mvn -U clean install
```

Also, 2 jars are build: 1 with all dependencies included, 1 only with the project java code.

For searching with People ID:
``` 
java -jar  blueliv-0.0.1-jar-with-dependencies.jar -f c:\temp\blueliv_test.txt -i 54808168L
```
For searching by City Name:
```
java -jar  blueliv-0.0.1-jar-with-dependencies.jar -f c:\temp\blueliv_test.txt -c "LAS VEGAS"
```
Note that doble quotes are needed for cities with a blank space like "LAS VEGAS". 

In order to review the code coverage analysis,  a html report with the code coverage can be found on the target/site folder.

#### DEV NOTES:

I wanted to use Java 1.8 Streams API in the searching method but I had little time to finish it, I used the traditional  Apache Common IO library in order to streaming the file. This was quick for me.

I dev some teams that cover a big part of the code. There are no tests for the main. With a little refactor, it can be done, but for now I do not have time.

Logger: I only put a few loggers in order to show the functonality. 

The program expects that the data file have always all the fields: Name + City + ID. If not, the line is skipped.

**I undertand that the code test was intended to show my knowledge of the language and the technolgies used, so I comment in tha section the posible issues and architecture details.**




## Abstract
We've got a public leak file with information that we need to integrate with our systems. The list represents places and people at different times, but we've got 2 different formats mixed in the same file.

To do that we provide you the following input, in order to create an application that takes a command and generates a suitable output

## Disclaimer: names and ID's are completely randomly generated with an online tool. Any possible match it's just a coincidence.

## Format details
Each line starts with F or D.
If F, this is a "format" line and two formats can be provided (1 or 2).
If D, this is a "data" line whose format is defined by the closest above format line.
If "F1" is specified, you can expect these fields separated with a comma:
D defining a data line
Name and surname
City
ID formatted as "12345678Z"
If "F2" is specified, you can expect these fields separated with space-semicolon-space:
D defining a data line
Name and surname
City
ID formatted as "12345678-Z"

## Commands to support
```
java -jar application.jar {FILE} CITY {CITY_NAME}
```
Will print the list of names and ID's belonging to people that have been in that city

```
java -jar application.jar {FILE} ID {ID_VALUE} (ID format example for input: 12345678Z) 
```
Will print the list of cities that this person has been to.
Output examples
```
java -jar application.jar input.txt CITY CARTAGENA  
```
must output an unordered unrepeated list of people and IDs that have been to 
CARTAGENA.

```
Mitchell Newton,25384390A
Rhonda Hopkins,54315871Z
Alexander Arnold,21743514G
Susan Holland,04810023X
Jake Salazar,38399984N
```
```
java -jar application.jar ID 54808168L 
```
must output an unordered unrepeated list of cities that Shelley Payne have been to.
```
MADRID
BARCELONA
OVIEDO
```

### Suggestions
* Code with the best quality, reusability, and maintainability. Provide a production-ready solution
* TDD
* It will be tested with big input files

```
F1
D Erica Burns,BARCELONA,93654902Y
D Lucy Mcgee,LONDON,51011156P
D Mitchell Newton,SAN FRANCISCO,25384390A
D Margarita Richards,LAS VEGAS,09877359D
D Rhonda Hopkins,SAN FRANCISCO,54315871Z
D Antonia Harper,LAS VEGAS,27466628M
D Hilda Caldwell,LONDON,61682270L
D Alexander Arnold,SAN FRANCISCO,21743514G
D Cheryl Hawkins,LAS VEGAS,76878166E
D Renee Anderson,BARCELONA,44340637H
F2
D Mitchell Newton ; LAS VEGAS ; 25384390-A
D Margarita Richards ; NEW YORK ; 09877359-D
D Rhonda Hopkins ; BARCELONA ; 54315871-Z
D Taylor Matthews ; LISBOA ; 58202263-G
D Shelley Payne ; MADRID ; 54808168-L
D Johnathan Cooper ; PARIS ; 10863096-N
F1
D Lowell Miles,BARCELONA,04217040J
D Russell Pope,BARCELONA,69429384C
D Shelley Payne,BARCELONA,54808168L
D Johnathan Cooper,BARCELONA,10863096N
D Myra Maldonado,LAS VEGAS,32445934H
D Irene Owen,LONDON,15015516N
D Susan Holland,SAN FRANCISCO,04810023X
D Rodolfo West,LAS VEGAS,74176315G
D Peter Daniel,BARCELONA,58204706D
F2
D Russell Pope ; CARTAGENA ; 69429384-C
D Shelley Payne ; OVIEDO ; 54808168-L
D Johnathan Cooper ; SANTANDER ; 10863096-N
D Myra Maldonado ; MARSELLA ; 32445934-H
D Glenn Bryan ; LISBON ; 90844421-X
D Neal Love ; SEVILLA ; 52498689-Q
D Taylor Matthews ; LONDRES ; 58202263-G
F1
D Marta Mendez,LAS VEGAS,17200667W
D Glenn Bryan,LAS VEGAS,90844421X
D Neal Love,LAS VEGAS,52498689Q
D Taylor Matthews,LAS VEGAS,58202263G
D Tommie Lindsey,LAS VEGAS,12020245P
D Ruben Daniels,BARCELONA,84604786E
D Emilio Warner,BARCELONA,23803975X
D Mark Quinn,LAS VEGAS,82098573G
D Dwight Roy,LONDON,87179151C
D Jake Salazar,SAN FRANCISCO,38399984N
D Edna Soto,LAS VEGAS,66991455E
```
