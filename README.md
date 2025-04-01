# Introduzione
## Storia 
Inventata dall’inventore tedesco tedesco Arthur Scherbius nel 1918 la macchina Enigma è stata uno strumento di crittografia utilizzato principalmente dalle forze armate tedesche durante la Seconda Guerra Mondiale per proteggere le comunicazioni militari.
#### Come funzionava
Enigma utilizzava una serie di rotori elettrici che modificavano continuamente l'alfabeto cifrato, rendendo ogni messaggio praticamente impossibile da decifrare senza conoscere la configurazione esatta della macchina.
Ogni giorno, gli operatori cambiavano la posizione dei rotori e le impostazioni iniziali, creando milioni di combinazioni possibili.

#### Caratteristiche principali di Enigma A (1923)
- **Aspetto e struttura**: aveva una forma simile a una macchina da scrivere, con una tastiera per l'inserimento del testo.
- **Sistema di cifratura**: utilizzava tre rotori elettromeccanici che ruotavano a ogni pressione di un tasto, cambiando continuamente la crittografia.
- **Meccanismo di stampa**: a differenza delle versioni successive, Enigma A stampava il testo cifrato su carta invece di mostrarlo su un pannello luminoso.
- **Ingombro**: era piuttosto grande e poco pratica rispetto ai modelli successivi.
## Il Nostro Progetto
Questo simulatore offre un'esperienza interattiva per comprendere il funzionamento interno della prima versione della macchina di Enigma, consentendo agli utenti di esplorare e sperimentare con la crittografia storica.
All'interno del progetto abbiamo implementato alcune classi per gestire il funzionamento della macchina Enigma, in particolare:
- **Rotore**: rappresenta un singolo rotore della macchina Enigma, con la capacità di ruotare e trasformare i caratteri.
- **GestioneRotori**: gestisce i tre rotori che compongono la macchina e la loro posizione, consentendo di configurare la macchina Enigma. Contiene inoltre Il riflessore.
- **Riflessore**: simula il funzionamento del circuito che faceva tornare indietro il segnale su un altro percorso trasmettendolo infine sul circuito delle luci.
- **PannelloScambiatore e Cavi**: gestisce la sezione del pannello scambiatore di Enigma


## Funzionalità
- **Cifratura e decifratura**: Consente di cifrare e decifrare testi utilizzando la logica della macchina Enigma.
- **Configurazione personalizzabile**: Permette di impostare vari parametri, come la sequenza dei rotori, le posizioni iniziali e le connessioni della plugboard.
- **Finestre di input ed output**: Permettono di visualizzare il messaggio inserito in entrata e quello cifrato dalla macchina.
- **Simulazione delle luci**: Consente di visualizzare l'ultimo carattere cifrato, simulando il funzionamento della macchina.



## Riconoscimenti
 
Colombo Francesco - Eisa Faris - Freddi Marco - Zaafrani Ahmed. 

Scuola I.I.S. Castelli di Brescia, articolazione Informatica. 

Classe 4AI - Anno Scolastico 2024/2025
