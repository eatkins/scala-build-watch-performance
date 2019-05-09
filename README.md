This project provides a benchmarking tool of the common development
feedback loop of edit/compile/test repeat. The tool tests performance
of a simple scala project that has a library dependency on
[akka](https://akka.io). There is a simple [scalatest](http://www.scalatest.org)
test that starts and stops an actor system and then writes a result
code to a file. The benchmark program forks a new instance of the build
tool in continuous test execution mode. For each iteration of the test,
the benchmark tool modifies the source file that contains the output file
of the test with a new output file. This triggers a continuous build in the
forked build tool process. The benchmark program monitors the new test output
until it has been written. It then compares the last modified time of the source
file and the test output file to determine the end to end latency between
modifying the source file and the test completing.

The results below are taken from 10 iterations. Before the first iteration,
the tool warms up the jvm with 5 iterations whose results are discareded. The
total time is the time between forking the process and all of the test iterations
completing.

### linux
bloop-1.2.5 (3 source files) | 6760 | 8392 | 7219 | 152217
gradle-5.4.1 (3 source files) | 2755 | 3282 | 2965 | 81608
mill-0.3.6 (3 source files) | 4734 | 5261 | 5069 | 133660
sbt-0.13.17 (3 source files) | 1591 | 2059 | 1753 | 51715
sbt-1.3.0 (3 source files) | 428 | 675 | 523 | 44759
bloop-1.2.5 (5003 source files) | 7256 | 8252 | 7681 | 165192
gradle-5.4.1 (5003 source files) | 4074 | 4442 | 4263 | 118309
mill-0.3.6 (5003 source files) | 6985 | 7548 | 7174 | 156972
sbt-0.13.17 (5003 source files) | 2571 | 3667 | 2840 | 88025

### mac
project | min (ms) | max (ms) | mean (ms) | total (ms)
:------- | :------: | :------: | :-------: | :--------:
bloop-1.2.5 (3 source files) | 4232 | 4467 | 4311 | 80204
gradle-5.4.1 (3 source files) | 2181 | 2347 | 2277 | 46967
mill-0.3.6 (3 source files) | 3287 | 3489 | 3397 | 84559
sbt-0.13.17 (3 source files) | 1184 | 1362 | 1277 | 35507
sbt-1.3.0 (3 source files) | 274 | 391 | 328 | 25058
bloop-1.2.5 (5003 source files) | 5223 | 6133 | 5419 | 116007
gradle-5.4.1 (5003 source files) | 4225 | 4413 | 4324 | 92826
mill-0.3.6 (5003 source files) | 5856 | 6150 | 5964 | 121911
sbt-0.13.17 (5003 source files) | 3023 | 3647 | 3223 | 79273
sbt-1.3.0 (5003 source files) | 1051 | 1234 | 1140 | 50327

### windows
project | min (ms) | max (ms) | mean (ms) | total (ms)
:-------: | :------: | :------: | :------: | :------:
gradle-5.4.1 (3 source files) | 9900 | 10853 | 10310 | 161303
mill-0.3.6 (3 source files) | 3432 | 3747 | 3587 | 87893
sbt-0.13.17 (3 source files) | 1204 | 1535 | 1316 | 38361
sbt-1.3.0 (3 source files) | 302 | 574 | 383 | 31899
gradle-5.4.1 (5003 source files) | 9994 | 10785 | 10371 | 190361
mill-0.3.6 (5003 source files) | 6227 | 6600 | 6399 | 124603
sbt-0.13.17 (5003 source files) | 3233 | 3844 | 3454 | 96458
sbt-1.3.0 (5003 source files) | 1430 | 1754 | 1553 | 65112
