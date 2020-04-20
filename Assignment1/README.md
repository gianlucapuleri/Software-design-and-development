# Assignment 1

Puleri Gianluca 807064

## L'applicazione
L'applicazione consente il login da parte di un utente e, se presente nel database, gli viene presentata una pagina contenente il proprio nome e la propria età.

## DevOps

### Containerization/Virtualization
Abbiamo utilizzato inoltre Docker-Compose per la gestione dell'ambiente multi-container.
È stata realizzata la parte di containerizzazione e virtualizzazione utilizzando Docker.
È stato utilizzato inoltre Docker-Compose per la gestione dell'ambiente multi-container.
Sono stati realizzati 6 container: 
* per il web server (Apache)
* per il database (MySql) 
* per il codice (PHP)
* per il monitoring (Prometheus)
* per la dashboard del monitoring (Grafana)
* per la misurazione delle risorse (Node-exporter)

### Continuos Integration/Continuos Development
È stata realizzata la parte relativa al continuos integration/continuos development tramite lo strumento CI/CD perchè già presente all'interno di GitLab.
Questa parte è stata suddivisa in 4 stages: build, test, release, deploy. Le prime 3 sono state realizzate con successo mentre l'ultima risulta non essere funzionante ed è stata commentata.

### Monitoring
È stata realizzata la parte di monitoring tramite l'utilizzo di Prometheus e Grafana.
È stato inoltre utilizzato Node-exporter per l'esportazione delle metriche.

## Repository
https://gitlab.com/gianlucapuleri/assignment-1/