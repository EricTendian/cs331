FILES=Tree.java TestTree.java
CLASSFILES=$(FILES:%.java=%.class)

CLASSPATH=.:/usr/share/java/junit.jar

JAVAOPTS=-cp $(CLASSPATH)
#JAVAOPTS=-1.5 -cp $(CLASSPATH)

.PHONY:
targets:
	@echo Supported targets:
	@echo compile - Compile all java files
	@echo tests - Run all tests
	@echo classfiles: $(CLASSFILES)

.PHONY:
clean:
	rm *.class

.PHONY:
compile: $(FILES)
	javac $(JAVAOPTS) $(FILES)

%.class: %.java
	javac $(JAVAOPTS) $<

.PHONY:
tests: $(CLASSFILES)
	java -cp $(CLASSPATH) junit.textui.TestRunner TestTree

