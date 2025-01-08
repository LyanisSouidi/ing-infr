#!/bin/bash

# Vider les chaînes de la table filter
iptables --flush

# Autoriser le trafic entrant ssh
iptables --append INPUT --protocol tcp --destination-port 22 --jump ACCEPT

# Rejeter tout le trafic entrant sur l'interface externe
iptables --append INPUT --in-interface ens160 --jump DROP

# Autoriser le trafic entrant en loopback
iptables --append INPUT --in-interface lo --jump ACCEPT

# Autoriser les communications TCP en provenance de 172.31.250.166
iptables --insert INPUT 2 --protocol tcp --source 172.31.250.166 --jump ACCEPT

# Autoriser les communications TCP entrantes sur le port 2023
iptables --insert INPUT 3 --protocol tcp --destination-port 2023 --jump ACCEPT

# Accepter les demandes de ping entrantes
iptables --insert INPUT 4 --protocol icmp --icmp-type echo-request --jump ACCEPT

# Accepter les paquets entrants correspondant à des connexions établies ou associées
iptables --insert INPUT 5 --match state --state RELATED,ESTABLISHED --jump ACCEPT

# Afficher la configuration avec les adresses au format numérique et les numéro de lignes affichées
iptables --list --numeric --line-numbers 
