#!/bin/bash

# Vider les chaînes de la table filter
iptables --flush

# Autoriser le trafic entrant ssh
iptables --append INPUT --protocol tcp --destination-port 22 --jump ACCEPT

# Autoriser les communications TCP en provenance de 172.31.250.166
iptables --append INPUT --protocol tcp --source 172.31.250.166 --jump ACCEPT

# Autoriser les communications TCP entrantes sur le port 2023
iptables --append INPUT --protocol tcp --destination-port 2023 --jump ACCEPT

# Accepter les demandes de ping entrantes
iptables --append INPUT --protocol icmp --icmp-type echo-request --jump ACCEPT

# Accepter les paquets entrants correspondant à des connexions établies ou associées
iptables --append INPUT --match state --state RELATED,ESTABLISHED --jump ACCEPT

# Rejeter tout le trafic entrant sur l'interface externe
iptables --append INPUT --in-interface ens160 --jump DROP

# Autoriser le trafic entrant en loopback
iptables --append INPUT --in-interface lo --jump ACCEPT

# Afficher la configuration avec les adresses au format numérique et les numéro de lignes affichées
iptables --list --numeric --line-numbers --verbose
