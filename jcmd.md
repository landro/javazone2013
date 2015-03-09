Utilities in $JAVA_HOME/bin
============================

    cd $JAVA_HOME/bin
    ls


### Start app

    mvn clean compile exec:java


### Listing processes

    jps
    jps -m
    jps -v

    jcmd
    jcmd <pid> help

### Thread dumping

    jcmd <pid> Thread.print 

    jcmd <pid> JFR.start duration=10s filename=/tmp/myrecording.jfr

### Java Mission Control

    jmc

#### Heap dumping

    jcmd <pid> GC.class_histogram | more
    jcmd <pid> GC.heap_dump /tmp/heap.bin

### Eclipse Memory Analyzer

[eclipse plugin (mat)](https://eclipse.org/mat/)

### Alternative commands

    jstack
    jmap -dump:format=b,file=/tmp/heap.bin 


