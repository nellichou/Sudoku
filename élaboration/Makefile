### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java LancePartie.class
	${JC} ${JCFLAGS} Main.java

LancePartie.class : LancePartie.java ListenerButton.class
	${JC} ${JCFLAGS} LancePartie.java

ListenerButton.class : ListenerButton.java Grille.class
	${JC} ${JCFLAGS} ListenerButton.java

Grille.class : Grille.java GestionSouris.class MyPanel.class
	${JC} ${JCFLAGS} Grille.java

GestionSouris.class : GestionSouris.java Grille.class MyPanel.class ChoixData.class
	${JC} ${JCFLAGS} GestionSouris.java

MyPanel.class : MyPanel.java 
	${JC} ${JCFLAGS} MyPanel.java

ChoixData.class : ChoixData.java MajGrilleListener.class
	${JC} ${JCFLAGS} ChoixData.java

MajGrilleListener.class : MajGrilleListener.java Grille.class ListenerValider.class
	${JC} ${JCFLAGS} MajGrilleListener.java

ListenerValider.class : ListenerValider.java Grille.class
	${JC} ${JCFLAGS} ListenerValider.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###