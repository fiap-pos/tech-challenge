#!/bin/sh

minikube start
kubectl apply -f secrets.yaml
kubectl apply -f configmap.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml
echo "Configurando mysql..."
sleep 1m
kubectl apply -f lanchonete-deployment.yaml
kubectl apply -f lanchonete-service.yaml
echo "Configurando aplicação lanchonete..."
sleep 80s
minikube service lanchonete-service