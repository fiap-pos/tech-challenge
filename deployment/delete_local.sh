#!/bin/sh

echo "Deletando aplicação lanchonete..."
kubectl delete -f lanchonete-service.yaml
kubectl delete -f lanchonete-deployment.yaml
echo "Lanchonete deletada"

echo "Deletando mysql..."
kubectl delete -f mysql-service.yaml
kubectl delete -f mysql-deployment.yaml
echo "Mysql deletado"

echo "Deletando secrets e configmap..."
kubectl delete -f secrets.yaml
kubectl delete -f configmap.yaml
echo "Secrets e configmap deletados"
