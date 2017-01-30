Questo repository contiente uno scheletro per costruire un'applicazione JAVA 
che usa:
1) Maven come gestore di dipendenze e di build
2) Hibernate per la gestione della persistenza
3) HSQL come DB

Sono presenti tutte le directory necessarie, vengono rispettate le convenzioni di maven 
per facilitare compilazione e lancio di test automatici (gerarchia delle cartelle
e nomenclatura dei sorgenti)

é presente un DAO generico che gestisce le principali operazioni sulla base dati

è presente un factory per l'accesso alla base dati (usato da Hibernate)

Per usare questo scheletro è sufficiente creare un nuovo repository di progetto e
selezionare questo repository come sorgente.

