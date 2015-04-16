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

### Garbage Collection

    jstat -gc <pid> 2s 50 // 50 GC reports in 2s interval

#### Heap dumping

    jcmd <pid> GC.class_histogram | more
    jcmd <pid> GC.heap_dump /tmp/heap.bin

### Eclipse Memory Analyzer

[eclipse plugin (mat)](https://eclipse.org/mat/)

### Alternative commands

    jstack
    jmap -dump:format=b,file=/tmp/heapdump.bin 


