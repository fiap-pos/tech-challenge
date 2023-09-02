#!/bin/sh

kubectl apply -f secrets.yaml
kubectl apply -f configmap.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml
kubectl apply -f lanchonete-deployment.yaml
kubectl apply -f lanchonete-service.yaml
