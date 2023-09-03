#!/bin/sh

echo "Configurando secrets e configmap..."
kubectl apply -f secrets.yaml
kubectl apply -f configmap.yaml
echo "Secrets e configmap ok"

echo "Configurando mysql..."
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml
sleep 1m
echo "Mysql ok"

echo "Configurando aplicação lanchonete..."
kubectl apply -f lanchonete-deployment.yaml
kubectl apply -f lanchonete-service.yaml
echo "Lanchonete ok"
