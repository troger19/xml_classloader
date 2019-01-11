Just call GET :  http://localhost:8002/test
First endpoint (/test) is calling second endpoint (/xml) in parallel stream 4 times.

With Java 11 running outside of IDEA (java -jar xml-0.0.1-SNAPSHOT.jar) it crashed 1. time. Every next attempt works. 
When running inside IDEA XmlApplication with Java 11, parallelStream() works.
When running with Java 8 everything works.
When running with Java 11 and replace parallelStream with stream, it works
When assigning thead before the call, it works : Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());

In Java 8 no problems, in IDEA no problems 