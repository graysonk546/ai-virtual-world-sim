# mp2 Feedback

## Grade: 4.0

| Compilation | Timeout | Duration |
|:-----------:|:-------:|:--------:|
|Yes|No|14.3|

## Test Results
### ca.ubc.ece.cpen221.graphs.one.Task2Grader
| Test Status | Count |
| ----------- | ----- |
|tests|16|
|failures|6|
|skipped|0|
|errors|0|
#### Failed Tests
1. `testBFS[0] (org.junit.runners.model.TestTimedOutException: test timed out after 1 seconds)`
1. `testBFS[2] (java.lang.StackOverflowError)`
1. `testBFS[3] (java.lang.StackOverflowError)`
1. `testBFS[4] (org.junit.runners.model.TestTimedOutException: test timed out after 1 seconds)`
1. `testBFS[6] (java.lang.StackOverflowError)`
1. `testBFS[7] (java.lang.StackOverflowError)`
### ca.ubc.ece.cpen221.graphs.one.Task1Grader
| Test Status | Count |
| ----------- | ----- |
|tests|16|
|failures|1|
|skipped|0|
|errors|0|
#### Failed Tests
1. `testNeighbours[0] (java.lang.AssertionError: Not in lexicographic order expected:<[b, f]> but was:<[f, b]>)`
### ca.ubc.ece.cpen221.graphs.one.Task4Grader
| Test Status | Count |
| ----------- | ----- |
|tests|12|
|failures|6|
|skipped|0|
|errors|0|
#### Failed Tests
1. `testNoCIs (org.junit.ComparisonFailure: expected:<[]> but was:<[[3, 4, 5]
]>)`
1. `test_1_2 (java.lang.AssertionError: expected:<[1, 2]> but was:<[[]]>)`
1. `test_1_2_reverse (java.lang.AssertionError: expected:<[1, 2]> but was:<[[]]>)`
1. `testNoCIs_2 (org.junit.ComparisonFailure: expected:<[]> but was:<[[]
]>)`
1. `test_1_8_9 (java.lang.AssertionError: expected:<[1]> but was:<[[]]>)`
1. `test_1_2_4_5 (java.lang.AssertionError: expected:<[1, 2]> but was:<[[]]>)`
### ca.ubc.ece.cpen221.graphs.one.Task3Grader
| Test Status | Count |
| ----------- | ----- |
|tests|28|
|failures|1|
|skipped|0|
|errors|0|
#### Failed Tests
1. `testDiameter[7] (org.junit.runners.model.TestTimedOutException: test timed out after 1 seconds)`

## Comments
Some sloppy implementation getting in the way of really good work. Specs and so on are good.

+++

good code qualitity, testing, RI, and AF. only thing missing is no self-loops in RI
AdjacencyListGraph.java:33:	Avoid using implementation types like 'Hashtable'; use the interface instead

AdjacencyListGraph.java:33:	Consider replacing this Hashtable with the newer java.util.Map

AdjacencyListGraph.java:33:	Found non-transient, non-static member. Please mark as transient or provide accessors.

AdjacencyListGraph.java:40:	Overridable method 'checkRep' called during object construction

AdjacencyListGraph.java:57:	Potential violation of Law of Demeter (object not created locally)

AdjacencyListGraph.java:69:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:19:	Avoid using implementation types like 'ArrayList'; use the interface instead

AdjacencyMatrixGraph.java:20:	Avoid using implementation types like 'ArrayList'; use the interface instead

AdjacencyMatrixGraph.java:20:	Found non-transient, non-static member. Please mark as transient or provide accessors.

AdjacencyMatrixGraph.java:51:	Overridable method 'checkRep' called during object construction

AdjacencyMatrixGraph.java:76:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:88:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:94:	Found 'DU'-anomaly for variable 'vertexIndex' (lines '94'-'101').

AdjacencyMatrixGraph.java:96:	Avoid using Literals in Conditional Statements

AdjacencyMatrixGraph.java:96:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:133:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:135:	Potential violation of Law of Demeter (method chain calls)

AdjacencyMatrixGraph.java:135:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:8:	All methods are static.  Consider using a utility class instead. Alternatively, you could add a private constructor or make the class abstract to silence this warning.

Algorithms.java:26:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:27:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:47:	Avoid reassigning parameters such as 'min'

Algorithms.java:50:	Found 'DU'-anomaly for variable 'neighboursList' (lines '50'-'70').

Algorithms.java:55:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:56:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:58:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:59:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:93:	System.out.println is used

Algorithms.java:111:	Potential violation of Law of Demeter (object not created locally)

Algorithms.java:111:	Substitute calls to size() == 0 (or size() != 0, size() > 0, size() < 1) with calls to isEmpty()

Algorithms.java:184:	Substitute calls to size() == 0 (or size() != 0, size() > 0, size() < 1) with calls to isEmpty()

Algorithms.java:191:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:210:	Found 'DD'-anomaly for variable 'indicator' (lines '210'-'214').

Algorithms.java:213:	Potential violation of Law of Demeter (method chain calls)

Algorithms.java:214:	Found 'DD'-anomaly for variable 'indicator' (lines '214'-'214').

Algorithms.java:222:	Found 'DU'-anomaly for variable 'maxDistance' (lines '222'-'231').

Algorithms.java:247:	Found 'DU'-anomaly for variable 'aNeighbours' (lines '247'-'255').

Algorithms.java:248:	Found 'DU'-anomaly for variable 'bNeighbours' (lines '248'-'255').

Algorithms.java:273:	Potential violation of Law of Demeter (object not created locally)

Algorithms.java:273:	Potential violation of Law of Demeter (object not created locally)

TwitterAnalysis.java:15:	Found non-transient, non-static member. Please mark as transient or provide accessors.

TwitterAnalysis.java:25:	Ensure that resources like this FileReader object are closed after use

TwitterAnalysis.java:28:	Avoid assignments in operands

TwitterAnalysis.java:61:	System.out.println is used

TwitterAnalysis.java:73:	Found 'DD'-anomaly for variable 'v1' (lines '73'-'77').

TwitterAnalysis.java:74:	Found 'DD'-anomaly for variable 'v2' (lines '74'-'80').

TwitterAnalysis.java:76:	Potential violation of Law of Demeter (method chain calls)

TwitterAnalysis.java:77:	Found 'DD'-anomaly for variable 'v1' (lines '77'-'77').

TwitterAnalysis.java:79:	Potential violation of Law of Demeter (method chain calls)

TwitterAnalysis.java:80:	Found 'DD'-anomaly for variable 'v2' (lines '80'-'80').

TwitterAnalysis.java:103:	Found 'DD'-anomaly for variable 'v1' (lines '103'-'107').

TwitterAnalysis.java:104:	Found 'DD'-anomaly for variable 'v2' (lines '104'-'110').

TwitterAnalysis.java:106:	Potential violation of Law of Demeter (method chain calls)

TwitterAnalysis.java:107:	Found 'DD'-anomaly for variable 'v1' (lines '107'-'107').

TwitterAnalysis.java:109:	Potential violation of Law of Demeter (method chain calls)

TwitterAnalysis.java:110:	Found 'DD'-anomaly for variable 'v2' (lines '110'-'110').

TwitterAnalysis.java:136:	Found 'DU'-anomaly for variable 'graph' (lines '136'-'144').

TwitterAnalysis.java:138:	Position literals first in String comparisons

TwitterAnalysis.java:139:	System.out.println is used

TwitterAnalysis.java:141:	Position literals first in String comparisons

TwitterAnalysis.java:142:	System.out.println is used

LoosePackageCoupling	-	No packages or classes specified

## Test Coverage
### Algorithms
| Metric | Coverage |
| ------ | -------- |
|LINE_COVERED|104|
|LINE_MISSED|1|
|BRANCH_COVERED|62|
|BRANCH_MISSED|0|
### AdjacencyListGraph
| Metric | Coverage |
| ------ | -------- |
|LINE_COVERED|29|
|LINE_MISSED|9|
|BRANCH_COVERED|11|
|BRANCH_MISSED|13|
### TwitterAnalysis
| Metric | Coverage |
| ------ | -------- |
|LINE_COVERED|59|
|LINE_MISSED|2|
|BRANCH_COVERED|31|
|BRANCH_MISSED|1|
### AdjacencyMatrixGraph
| Metric | Coverage |
| ------ | -------- |
|LINE_COVERED|40|
|LINE_MISSED|14|
|BRANCH_COVERED|17|
|BRANCH_MISSED|27|

## Checkstyle Results
### `AdjacencyListGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 20 | None | `Type Javadoc comment is missing @author tag.` |
| 33 | 62 | `Name 'AdjacencyList' must match pattern '^_?[a-z][a-zA-Z0-9]*$|_?[A-Z]$'.` |
| 81 | 22 | `Name 'StringCopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 87 | 36 | `'{' is not preceded with whitespace.` |
| 88 | 36 | `'{' is not preceded with whitespace.` |
| 89 | 17 | `'if' is not followed by whitespace.` |
| 89 | 43 | `'{' is not preceded with whitespace.` |
| 99 | 52 | `'{' is not preceded with whitespace.` |
| 105 | 13 | `'assert' is not followed by whitespace.` |
| 108 | 17 | `'assert' is not followed by whitespace.` |
| 20 | None | `Type Javadoc comment is missing @author tag.` |
| 33 | 62 | `Name 'AdjacencyList' must match pattern '^_?[a-z][a-zA-Z0-9]*$|_?[A-Z]$'.` |
| 81 | 22 | `Name 'StringCopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 87 | 36 | `'{' is not preceded with whitespace.` |
| 88 | 36 | `'{' is not preceded with whitespace.` |
| 89 | 17 | `'if' is not followed by whitespace.` |
| 89 | 43 | `'{' is not preceded with whitespace.` |
| 99 | 52 | `'{' is not preceded with whitespace.` |
| 105 | 13 | `'assert' is not followed by whitespace.` |
| 108 | 17 | `'assert' is not followed by whitespace.` |
### `Algorithms.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 6 | None | `Using the '.*' form of import should be avoided - java.util.*.` |
| 11 | None | `Line is longer than 100 characters (found 106).` |
| 20 | 20 | `Expected @param tag for '<T>'.` |
| 26 | 41 | `',' is not followed by whitespace.` |
| 26 | 68 | `',' is not followed by whitespace.` |
| 26 | 74 | `',' is not followed by whitespace.` |
| 26 | 76 | `',' is not followed by whitespace.` |
| 26 | 78 | `',' is not followed by whitespace.` |
| 35 | None | `Line is longer than 100 characters (found 115).` |
| 39 | None | `Line is longer than 100 characters (found 116).` |
| 45 | None | `Line is longer than 100 characters (found 118).` |
| 47 | 52 | `',' is not followed by whitespace.` |
| 52 | 9 | `'if' is not followed by whitespace.` |
| 52 | 24 | `'{' is not preceded with whitespace.` |
| 55 | 9 | `'if' is not followed by whitespace.` |
| 55 | 46 | `'{' is not preceded with whitespace.` |
| 58 | 9 | `'if' is not followed by whitespace.` |
| 58 | 47 | `'{' is not preceded with whitespace.` |
| 63 | 9 | `'for' is not followed by whitespace.` |
| 63 | 42 | `'{' is not preceded with whitespace.` |
| 64 | 42 | `'+' is not followed by whitespace.` |
| 64 | 42 | `'+' is not preceded with whitespace.` |
| 64 | 44 | `',' is not followed by whitespace.` |
| 64 | 55 | `',' is not followed by whitespace.` |
| 64 | 61 | `'+' is not followed by whitespace.` |
| 64 | 61 | `'+' is not preceded with whitespace.` |
| 65 | 13 | `'if' is not followed by whitespace.` |
| 65 | 29 | `'{' is not preceded with whitespace.` |
| 86 | 20 | `Expected @param tag for '<T>'.` |
| 90 | 9 | `'for' is not followed by whitespace.` |
| 90 | 41 | `'{' is not preceded with whitespace.` |
| 91 | 29 | `Name 'DFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 108 | None | `Line is longer than 100 characters (found 109).` |
| 108 | 21 | `Expected @param tag for '<T>'.` |
| 108 | 29 | `Name 'DFSHelper' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 108 | 55 | `Name 'DFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 108 | 109 | `'{' is not preceded with whitespace.` |
| 111 | 36 | `'{' is not preceded with whitespace.` |
| 116 | 9 | `'for' is not followed by whitespace.` |
| 116 | 49 | `'{' is not preceded with whitespace.` |
| 117 | 47 | `'{' is not preceded with whitespace.` |
| 129 | 21 | `Expected @param tag for '<T>'.` |
| 129 | 78 | `'{' is not preceded with whitespace.` |
| 130 | 22 | `Name 'StringCopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 132 | 36 | `'{' is not preceded with whitespace.` |
| 137 | 36 | `'{' is not preceded with whitespace.` |
| 138 | 41 | `'{' is not preceded with whitespace.` |
| 139 | 17 | `'if' is not followed by whitespace.` |
| 139 | 43 | `'{' is not preceded with whitespace.` |
| 161 | 20 | `Expected @param tag for '<T>'.` |
| 164 | 9 | `'for' is not followed by whitespace.` |
| 164 | 41 | `'{' is not preceded with whitespace.` |
| 165 | 29 | `Name 'BFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 176 | None | `Line is longer than 100 characters (found 102).` |
| 183 | None | `Line is longer than 100 characters (found 118).` |
| 183 | 21 | `Expected @param tag for '<T>'.` |
| 183 | 29 | `Name 'BFSHelper' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 183 | 55 | `Name 'BFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 199 | None | `Line is longer than 100 characters (found 117).` |
| 212 | 9 | `'for' is not followed by whitespace.` |
| 212 | 40 | `'{' is not preceded with whitespace.` |
| 213 | 13 | `'if' is not followed by whitespace.` |
| 213 | 49 | `'{' is not preceded with whitespace.` |
| 216 | 13 | `'for' is not followed by whitespace.` |
| 216 | 44 | `'{' is not preceded with whitespace.` |
| 217 | 42 | `',' is not followed by whitespace.` |
| 217 | 44 | `',' is not followed by whitespace.` |
| 218 | 17 | `'if' is not followed by whitespace.` |
| 218 | 50 | `'{' is not preceded with whitespace.` |
| 221 | 17 | `'if' is not followed by whitespace.` |
| 221 | 77 | `'{' is not preceded with whitespace.` |
| 227 | 9 | `'if' is not followed by whitespace.` |
| 227 | 22 | `')' is preceded with whitespace.` |
| 227 | 23 | `'{' is not preceded with whitespace.` |
| 234 | None | `Line is longer than 100 characters (found 108).` |
| 244 | None | `Line is longer than 100 characters (found 102).` |
| 244 | 20 | `Expected @param tag for '<T>'.` |
| 258 | None | `Line is longer than 100 characters (found 108).` |
| 267 | None | `Line is longer than 100 characters (found 103).` |
| 267 | 20 | `Expected @param tag for '<T>'.` |
| 267 | 103 | `'{' is not preceded with whitespace.` |
| 271 | 9 | `'for' is not followed by whitespace.` |
| 271 | 41 | `'{' is not preceded with whitespace.` |
| 273 | 13 | `'if' is not followed by whitespace.` |
| 273 | 65 | `'{' is not preceded with whitespace.` |
| 6 | None | `Using the '.*' form of import should be avoided - java.util.*.` |
| 11 | None | `Line is longer than 100 characters (found 106).` |
| 20 | 20 | `Expected @param tag for '<T>'.` |
| 26 | 41 | `',' is not followed by whitespace.` |
| 26 | 68 | `',' is not followed by whitespace.` |
| 26 | 74 | `',' is not followed by whitespace.` |
| 26 | 76 | `',' is not followed by whitespace.` |
| 26 | 78 | `',' is not followed by whitespace.` |
| 35 | None | `Line is longer than 100 characters (found 115).` |
| 39 | None | `Line is longer than 100 characters (found 116).` |
| 45 | None | `Line is longer than 100 characters (found 118).` |
| 47 | 52 | `',' is not followed by whitespace.` |
| 52 | 9 | `'if' is not followed by whitespace.` |
| 52 | 24 | `'{' is not preceded with whitespace.` |
| 55 | 9 | `'if' is not followed by whitespace.` |
| 55 | 46 | `'{' is not preceded with whitespace.` |
| 58 | 9 | `'if' is not followed by whitespace.` |
| 58 | 47 | `'{' is not preceded with whitespace.` |
| 63 | 9 | `'for' is not followed by whitespace.` |
| 63 | 42 | `'{' is not preceded with whitespace.` |
| 64 | 42 | `'+' is not followed by whitespace.` |
| 64 | 42 | `'+' is not preceded with whitespace.` |
| 64 | 44 | `',' is not followed by whitespace.` |
| 64 | 55 | `',' is not followed by whitespace.` |
| 64 | 61 | `'+' is not followed by whitespace.` |
| 64 | 61 | `'+' is not preceded with whitespace.` |
| 65 | 13 | `'if' is not followed by whitespace.` |
| 65 | 29 | `'{' is not preceded with whitespace.` |
| 86 | 20 | `Expected @param tag for '<T>'.` |
| 90 | 9 | `'for' is not followed by whitespace.` |
| 90 | 41 | `'{' is not preceded with whitespace.` |
| 91 | 29 | `Name 'DFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 108 | None | `Line is longer than 100 characters (found 109).` |
| 108 | 21 | `Expected @param tag for '<T>'.` |
| 108 | 29 | `Name 'DFSHelper' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 108 | 55 | `Name 'DFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 108 | 109 | `'{' is not preceded with whitespace.` |
| 111 | 36 | `'{' is not preceded with whitespace.` |
| 116 | 9 | `'for' is not followed by whitespace.` |
| 116 | 49 | `'{' is not preceded with whitespace.` |
| 117 | 47 | `'{' is not preceded with whitespace.` |
| 129 | 21 | `Expected @param tag for '<T>'.` |
| 129 | 78 | `'{' is not preceded with whitespace.` |
| 130 | 22 | `Name 'StringCopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 132 | 36 | `'{' is not preceded with whitespace.` |
| 137 | 36 | `'{' is not preceded with whitespace.` |
| 138 | 41 | `'{' is not preceded with whitespace.` |
| 139 | 17 | `'if' is not followed by whitespace.` |
| 139 | 43 | `'{' is not preceded with whitespace.` |
| 161 | 20 | `Expected @param tag for '<T>'.` |
| 164 | 9 | `'for' is not followed by whitespace.` |
| 164 | 41 | `'{' is not preceded with whitespace.` |
| 165 | 29 | `Name 'BFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 176 | None | `Line is longer than 100 characters (found 102).` |
| 183 | None | `Line is longer than 100 characters (found 118).` |
| 183 | 21 | `Expected @param tag for '<T>'.` |
| 183 | 29 | `Name 'BFSHelper' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 183 | 55 | `Name 'BFSSequence' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 199 | None | `Line is longer than 100 characters (found 117).` |
| 212 | 9 | `'for' is not followed by whitespace.` |
| 212 | 40 | `'{' is not preceded with whitespace.` |
| 213 | 13 | `'if' is not followed by whitespace.` |
| 213 | 49 | `'{' is not preceded with whitespace.` |
| 216 | 13 | `'for' is not followed by whitespace.` |
| 216 | 44 | `'{' is not preceded with whitespace.` |
| 217 | 42 | `',' is not followed by whitespace.` |
| 217 | 44 | `',' is not followed by whitespace.` |
| 218 | 17 | `'if' is not followed by whitespace.` |
| 218 | 50 | `'{' is not preceded with whitespace.` |
| 221 | 17 | `'if' is not followed by whitespace.` |
| 221 | 77 | `'{' is not preceded with whitespace.` |
| 227 | 9 | `'if' is not followed by whitespace.` |
| 227 | 22 | `')' is preceded with whitespace.` |
| 227 | 23 | `'{' is not preceded with whitespace.` |
| 234 | None | `Line is longer than 100 characters (found 108).` |
| 244 | None | `Line is longer than 100 characters (found 102).` |
| 244 | 20 | `Expected @param tag for '<T>'.` |
| 258 | None | `Line is longer than 100 characters (found 108).` |
| 267 | None | `Line is longer than 100 characters (found 103).` |
| 267 | 20 | `Expected @param tag for '<T>'.` |
| 267 | 103 | `'{' is not preceded with whitespace.` |
| 271 | 9 | `'for' is not followed by whitespace.` |
| 271 | 41 | `'{' is not preceded with whitespace.` |
| 273 | 13 | `'if' is not followed by whitespace.` |
| 273 | 65 | `'{' is not preceded with whitespace.` |
### `TwitterAnalysis.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 23 | 9 | `'try' is not followed by whitespace.` |
| 23 | 12 | `'{' is not preceded with whitespace.` |
| 28 | 13 | `'while' is not followed by whitespace.` |
| 28 | 57 | `'{' is not preceded with whitespace.` |
| 33 | 17 | `'while' is not followed by whitespace.` |
| 33 | 52 | `'{' is not preceded with whitespace.` |
| 41 | 17 | `'while' is not followed by whitespace.` |
| 41 | 48 | `'{' is not preceded with whitespace.` |
| 46 | 79 | `',' is not followed by whitespace.` |
| 47 | 79 | `',' is not followed by whitespace.` |
| 49 | 17 | `'if' is not followed by whitespace.` |
| 49 | 58 | `'{' is not preceded with whitespace.` |
| 53 | 17 | `'if' is not followed by whitespace.` |
| 53 | 58 | `'{' is not preceded with whitespace.` |
| 60 | 11 | `'catch' is not followed by whitespace.` |
| 60 | 31 | `'{' is not preceded with whitespace.` |
| 66 | None | `Line is longer than 100 characters (found 107).` |
| 83 | None | `Line is longer than 100 characters (found 115).` |
| 85 | 9 | `'for' is not followed by whitespace.` |
| 99 | None | `Line is longer than 100 characters (found 106).` |
| 113 | 56 | `',' is not followed by whitespace.` |
| 113 | 59 | `',' is not followed by whitespace.` |
| 123 | 43 | `'{' is not preceded with whitespace.` |
| 138 | 9 | `'if' is not followed by whitespace.` |
| 138 | 48 | `'{' is not preceded with whitespace.` |
| 140 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 141 | 48 | `'{' is not preceded with whitespace.` |
| 23 | 9 | `'try' is not followed by whitespace.` |
| 23 | 12 | `'{' is not preceded with whitespace.` |
| 28 | 13 | `'while' is not followed by whitespace.` |
| 28 | 57 | `'{' is not preceded with whitespace.` |
| 33 | 17 | `'while' is not followed by whitespace.` |
| 33 | 52 | `'{' is not preceded with whitespace.` |
| 41 | 17 | `'while' is not followed by whitespace.` |
| 41 | 48 | `'{' is not preceded with whitespace.` |
| 46 | 79 | `',' is not followed by whitespace.` |
| 47 | 79 | `',' is not followed by whitespace.` |
| 49 | 17 | `'if' is not followed by whitespace.` |
| 49 | 58 | `'{' is not preceded with whitespace.` |
| 53 | 17 | `'if' is not followed by whitespace.` |
| 53 | 58 | `'{' is not preceded with whitespace.` |
| 60 | 11 | `'catch' is not followed by whitespace.` |
| 60 | 31 | `'{' is not preceded with whitespace.` |
| 66 | None | `Line is longer than 100 characters (found 107).` |
| 83 | None | `Line is longer than 100 characters (found 115).` |
| 85 | 9 | `'for' is not followed by whitespace.` |
| 99 | None | `Line is longer than 100 characters (found 106).` |
| 113 | 56 | `',' is not followed by whitespace.` |
| 113 | 59 | `',' is not followed by whitespace.` |
| 123 | 43 | `'{' is not preceded with whitespace.` |
| 138 | 9 | `'if' is not followed by whitespace.` |
| 138 | 48 | `'{' is not preceded with whitespace.` |
| 140 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 141 | 48 | `'{' is not preceded with whitespace.` |
### `AdjacencyMatrixGraph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 17 | None | `Type Javadoc comment is missing @author tag.` |
| 37 | None | `Line is longer than 100 characters (found 122).` |
| 95 | 57 | `'{' is not preceded with whitespace.` |
| 96 | 62 | `'{' is not preceded with whitespace.` |
| 105 | 22 | `Name 'Stringcopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 107 | 36 | `'{' is not preceded with whitespace.` |
| 112 | 36 | `'{' is not preceded with whitespace.` |
| 113 | 40 | `'{' is not preceded with whitespace.` |
| 114 | 17 | `'if' is not followed by whitespace.` |
| 114 | 43 | `'{' is not preceded with whitespace.` |
| 125 | 13 | `'assert' is not followed by whitespace.` |
| 130 | 13 | `'assert' is not followed by whitespace.` |
| 133 | 13 | `'assert' is not followed by whitespace.` |
| 135 | 17 | `'assert' is not followed by whitespace.` |
| 17 | None | `Type Javadoc comment is missing @author tag.` |
| 37 | None | `Line is longer than 100 characters (found 122).` |
| 95 | 57 | `'{' is not preceded with whitespace.` |
| 96 | 62 | `'{' is not preceded with whitespace.` |
| 105 | 22 | `Name 'Stringcopy' must match pattern '^([A-Z][0-9]*|[a-z][a-zA-Z0-9]*)$'.` |
| 107 | 36 | `'{' is not preceded with whitespace.` |
| 112 | 36 | `'{' is not preceded with whitespace.` |
| 113 | 40 | `'{' is not preceded with whitespace.` |
| 114 | 17 | `'if' is not followed by whitespace.` |
| 114 | 43 | `'{' is not preceded with whitespace.` |
| 125 | 13 | `'assert' is not followed by whitespace.` |
| 130 | 13 | `'assert' is not followed by whitespace.` |
| 133 | 13 | `'assert' is not followed by whitespace.` |
| 135 | 17 | `'assert' is not followed by whitespace.` |

