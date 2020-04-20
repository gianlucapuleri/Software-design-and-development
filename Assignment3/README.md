# Assignment 3

Puleri Gianluca 807064

## Il progetto

Il progetto implementa un semplice sistema per la gestione di una squadra di calcio.

È possibile eseguire operazioni CRUD sulle varie entità del sistema:

- *`Calciatore`*, che rappresenta un giocatore di una determinata *Squadra*. È rappresentato da un nome, un cognome, un ruolo e una nazionalità.
- *`Squadra`*, che rappresenta la società calcistica. È rappresentata da un nome, una lega (ad esempio Serie A, Premier League ecc.), i colori sociali e un fatturato.
- *`Sponsor`*, che rappresenta una società finanziatrice della *Squadra*. È rappresentato da un nome.
- *`Dirigente`*, che rappresenta una persona facente parte dell'organigramma della *Squadra*. È rappresentato da un nome, un cognome e un ruolo.
- *`Città`*, che rappresenta la città nella quale la *Squadra* ha sede. È rappresentata da un nome, una provincia e uno stato.


In questo progetto si utilizza Hibernate, che fornisce un servizio di ORM necessario per gestire la persistenza dei dati attraverso la rappresentazione di entità e relazioni su database MySQL di oggetti di tipo Java. La connessione al database è realizzata tramite MySQL JDBC connector e tutte le dipendenze nel progetto sono gestite attraverso l'utilizzo di Maven.

## Diagramma ER

Il seguente diagramma mostra le varie entità e relazioni presenti nel sistema. 

Vi è una relazione ricorsiva uno-a-molti in *Calciatore*, per la quale un calciatore può essere figlio di un altro calciatore e un calciatore può essere genitore (padre) di più calciatori (si presuppone che il sistema non tenga in considerazione il calcio femminile). È presente quindi all'interno dell'entità *Calciatore* un campo che identifica il padre. 

Vi sono tre ulteriori relazioni uno-a-molti, tra:

- *Squadra* e *Calciatore*, infatti una squadra può avere molti calciatori e un calciatore può appartenere solamente a una squadra in un dato momento.
- *Squadra* e *Città*, infatti una squadra può avere solamente una città in cui ha sede e una città può ospitare più squadre differenti.
- *Squadra* e *Dirigente*, infatti una squadra può avere molti dirigenti e un dirigente può lavorare solamente per una squadra in un dato momento.


Vi è una relazione molti-a-molti tra *Squadra* e *Sponsor*, infatti una squadra può essere finanziata da molteplici sponsor e uno sponsor può finanziare molteplici squadre.

![](.readme/ER.png)

## Diagramma del database

Il diagramma del database è pressoché identico all'ER se non per l'aggiunta formale della classe `Finanzia` che permette di rappresentare la relazione tra *Squadra* e *Sponsor* del diagramma ER.

![](.readme/database.png)

## Installazione ed esecuzione test

Il file di configurazione per la connessione al database è disponibile in `src/main/resources/META-INF/persistence.xml`. 
Viene utilizzato un database MySQL (5.7), che è quindi necessario per l'esecuzione. 
Di default username e password corrispondono a `root:root`, il database è nominato `football` e si trova in `localhost` alla porta di default MySQL `3306`.

È necessario eseguire MySQL in un'istanza di Docker utilizzando il seguente comando:
`docker run --rm --name football -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7`

Successivamente è necessario:

- compilare il progetto con il comando `mvn compile`

- Eseguire i test con il comando `mvn test`


È possibile popolare il database con il comando `mvn exec:java -Dexec.mainClass="com.puleri.seeders.DBSeeder"` per testare che il popolamento avvenga con successo e rispetti i vincoli dello schema.

## Test

Sono stati realizzati dei test JUnit per testare il corretto funzionamento delle classi `services`, mentre non è stato ritenuto necessario il test delle classi `daos`.

In questi test vengono utilizzate le classi dentro il package `fakefactories`, utili per la generazione automatica dei dati.

## Descrizione delle classi

Il package di base è `com.puleri`. 

Al suo interno vi sono i seguenti package:

- `daos`, che contiene i DAO utili per la gestione delle entità, ovvero gli oggetti che consentono il salvataggio e il recupero dei dati dal database.
  - Contiene `Dao` che è la classe astratta base che viene estesa e implementata dagli altri specifici DAO presenti.
- `models`, che contiene le entità JPA per la rappresentazione del sistema sul database. 
  - Ogni entità ha un `costruttore di default` e uno `non di default`, un metodo `hashCode()`, un metodo `equals()` e un metodo `toString()`. Inoltre ogni attributo di ogni entità ha il rispettivo metodo `get()` e metodo `set()`.
- `seeders`, che contiene le classi che vengono eseguite. 
  - `DBSeeder`, questa classe si occupa di generare dei dati finti che serviranno per popolare le entità del database. Fa uso delle classi all'interno del package `fakefactories`.
  - `fakefactories`, contiene al suo interno le varie classi che si occupano di generare dati automatici che verranno utilizzati nella fase di test.
- `services`, che contiene i servizi utili per la gestione delle entità a un livello superiore dei DAO.
  - Contiene `DaoInterface<T, Id>` che è l'interfaccia comune che viene estesa e implementata dagli altri specifici servizi. 

## Repository

https://gitlab.com/gianlucapuleri/assignment-3
